/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.wijithafc.business.custom.OrderBO;
import lk.ijse.wijithafc.dto.OrderDTO;
import lk.ijse.wijithafc.dto.OrderDetailDTO;
import lk.ijse.wijithafc.dto.PaymentDTO;
import lk.ijse.wijithafc.entity.Item;
import lk.ijse.wijithafc.entity.OrderDetail;
import lk.ijse.wijithafc.entity.OrderDetail_pk;
import lk.ijse.wijithafc.entity.Orders;
import lk.ijse.wijithafc.entity.Payment;
import lk.ijse.wijithafc.repository.RepositoryFactory;
import lk.ijse.wijithafc.repository.custom.ItemRepository;
import lk.ijse.wijithafc.repository.custom.OrderRepository;
import lk.ijse.wijithafc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class OrderBOImpl implements OrderBO {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    public OrderBOImpl() {
        orderRepository = (OrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.ORDER);
        itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.ITEM);
    }

    @Override
    public boolean addOrder(OrderDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            orderRepository.setSession(openSession);
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Orders orders = new Orders(dTO.getOrderID(), dTO.getUserID(), dTO.getOrderDate(), dTO.getOrderTime());
            List<OrderDetail> details = new ArrayList<>();
            for (OrderDetailDTO detail : dTO.getDetailList()) {
                Item item = itemRepository.findById(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
                OrderDetail_pk detail_pk = new OrderDetail_pk(orders.getOrderID(), item.getItemCode());
                OrderDetail orderDetail = new OrderDetail(orders, item, detail.getUnitPrice(), detail.getQty(), detail.getDiscount(), detail_pk);
                details.add(orderDetail);
            }
            PaymentDTO paymentDTO = dTO.getPaymentDTO();
            Payment payment = new Payment(dTO.getOrderID(), paymentDTO.getAmount(), paymentDTO.getTotalDiscount(), paymentDTO.getPaidByCus(), paymentDTO.getChange());
            orders.setDetailList(details);
            orders.setPayment(payment);

            boolean save = orderRepository.save(orders);
            openSession.getTransaction().commit();
            return save;
        }
    }

    @Override
    public boolean updateOrder(OrderDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            orderRepository.setSession(openSession);
            openSession.beginTransaction();
            Orders orders = new Orders(dTO.getOrderID(), dTO.getUserID(), dTO.getOrderDate(), dTO.getOrderTime());
            List<OrderDetail> details = new ArrayList<>();
            for (OrderDetailDTO detail : dTO.getDetailList()) {
                Item item = itemRepository.findById(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
                OrderDetail_pk detail_pk = new OrderDetail_pk(orders.getOrderID(), item.getItemCode());
                OrderDetail orderDetail = new OrderDetail(orders, item, detail.getUnitPrice(), detail.getQty(), detail.getDiscount(), detail_pk);
                details.add(orderDetail);
            }
            PaymentDTO paymentDTO = dTO.getPaymentDTO();
            Payment payment = new Payment(dTO.getOrderID(), paymentDTO.getAmount(), paymentDTO.getTotalDiscount(), paymentDTO.getPaidByCus(), paymentDTO.getChange());
            orders.setDetailList(details);
            orders.setPayment(payment);
            orderRepository.update(orders);
            openSession.getTransaction().commit();
            return true;
        }

    }

    @Override
    public boolean deleteOrder(OrderDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            orderRepository.setSession(openSession);
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Orders orders = new Orders(dTO.getOrderID(), dTO.getUserID(), dTO.getOrderDate(), dTO.getOrderTime());
            List<OrderDetail> details = new ArrayList<>();
            for (OrderDetailDTO detail : dTO.getDetailList()) {
                Item item = itemRepository.findById(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() + detail.getQty());
                OrderDetail_pk detail_pk = new OrderDetail_pk(orders.getOrderID(), item.getItemCode());
                OrderDetail orderDetail = new OrderDetail(orders, item, detail.getUnitPrice(), detail.getQty(), detail.getDiscount(), detail_pk);
                details.add(orderDetail);
            }
            PaymentDTO paymentDTO = dTO.getPaymentDTO();
            Payment payment = new Payment(dTO.getOrderID(), paymentDTO.getAmount(), paymentDTO.getTotalDiscount(), paymentDTO.getPaidByCus(), paymentDTO.getChange());
            orders.setDetailList(details);
            orders.setPayment(payment);
            orderRepository.delete(orders);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<OrderDTO> getAll() throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            orderRepository.setSession(openSession);
            openSession.beginTransaction();
            List<Orders> findAll = orderRepository.findAll();
            List<OrderDTO> list = new ArrayList<>();
            if (findAll != null) {
                for (Orders orders : findAll) {
                    List<OrderDetail> detailList = orders.getDetailList();
                    List<OrderDetailDTO> details = new ArrayList<>();
                    for (OrderDetailDTO detail : details) {
                        OrderDetailDTO detailDTO = new OrderDetailDTO(detail.getItemCode(), detail.getUnitPrice(), detail.getQty(), detail.getDiscount());
                        details.add(detail);
                    }
                    Payment payment = orders.getPayment();
                    PaymentDTO paymentDTO = new PaymentDTO(payment.getAmountPaid(), payment.getTotalDiscount(), payment.getPaidByCus(), payment.getChangePaid());
                    OrderDTO orderDTO = new OrderDTO(orders.getOrderID(), orders.getUserID(), orders.getOrderDate(), orders.getOrderTime(), details, paymentDTO);
                    list.add(orderDTO);

                }
            }
            openSession.getTransaction().commit();
            return list;
        }
    }

    @Override
    public OrderDTO SearchOrder(String id) throws Exception {
       return null;
    }

}
