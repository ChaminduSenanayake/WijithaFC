/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.controller;

import java.util.List;
import lk.ijse.wijithaFC.proxy.ProxyHandler;
import lk.ijse.wijithafc.dto.OrderDTO;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.custom.OrderService;
import lk.ijse.wijithafc.service.custom.SupplierService;

/**
 *
 * @author ASUS
 */
public class manageOrderController {
     public static boolean addOrder(OrderDTO dTO) throws Exception {
        OrderService service=(OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
        return service.addOrder(dTO);
    }

    public static boolean updateOrder(OrderDTO dTO) throws Exception {
       OrderService service=(OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
        return service.updateOrder(dTO);
    }

    public static boolean deleteOrder(OrderDTO dTO) throws Exception {
       OrderService service=(OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
        return service.deleteOrder(dTO);
    }

    public static List<OrderDTO> getAll() throws Exception {
      OrderService service=(OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
        return service.getAll();
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
    }

    public static boolean reserveOrder(String orderID) throws Exception {
        OrderService service=(OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
        return service.reserve(orderID);
    }

    public static boolean releaseOrder(String orderID) throws Exception {
        OrderService service=(OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
        return service.release(orderID);
    }
}
