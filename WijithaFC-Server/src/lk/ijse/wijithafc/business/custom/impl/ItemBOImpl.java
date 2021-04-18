
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.wijithafc.business.custom.ItemBO;
import lk.ijse.wijithafc.dto.ItemDTO;
import lk.ijse.wijithafc.entity.Item;
import lk.ijse.wijithafc.repository.RepositoryFactory;
import lk.ijse.wijithafc.repository.custom.ItemRepository;
import lk.ijse.wijithafc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class ItemBOImpl implements ItemBO {

    private ItemRepository itemRepository;

    public ItemBOImpl() {
        itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.ITEM);
    }

    @Override
    public boolean addItem(ItemDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Item item = new Item(dTO.getItemCode(), dTO.getDescription(), dTO.getCategory(), dTO.getUnitPrice(), dTO.getQtyOnHand(),dTO.getDiscountQTY(),dTO.getDiscount());
            boolean save = itemRepository.save(item);
            openSession.getTransaction().commit();
            return save;
        }
    }

    @Override
    public ItemDTO SearchItem(String id) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Item item1 = itemRepository.findById(id);
            ItemDTO idto = new ItemDTO(item1.getItemCode(), item1.getDescription(), item1.getCategory(), item1.getUnitPrice(), item1.getQtyOnHand(),item1.getDiscountQTY(),item1.getDiscount());
            openSession.getTransaction().commit();
            return idto;
        }
    }

    @Override
    public boolean updateItem(ItemDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Item item = new Item(dTO.getItemCode(), dTO.getDescription(), dTO.getCategory(), dTO.getUnitPrice(), dTO.getQtyOnHand(),dTO.getDiscountQTY(),dTO.getDiscount());
            itemRepository.update(item);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteItem(ItemDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Item item = new Item(dTO.getItemCode(), dTO.getDescription(), dTO.getCategory(), dTO.getUnitPrice(), dTO.getQtyOnHand(),dTO.getDiscountQTY(),dTO.getDiscount());
            itemRepository.delete(item);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<ItemDTO> getAll() throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            List<Item> findAll = itemRepository.findAll();
            List<ItemDTO> dTOs = new ArrayList<>();
            if (findAll != null) {
                for (Item item1 : findAll) {
                    ItemDTO idto = new ItemDTO(item1.getItemCode(), item1.getDescription(), item1.getCategory(), item1.getUnitPrice(), item1.getQtyOnHand(),item1.getDiscountQTY(),item1.getDiscount());
                    dTOs.add(idto);
                }
            } else {
                return null;

            }

            openSession.getTransaction().commit();
            return dTOs;
        }
    }

}
