/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithaFC.controller;

import java.util.List;
import lk.ijse.wijithaFC.proxy.ProxyHandler;
import lk.ijse.wijithafc.dto.ItemDTO;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.custom.ItemService;

/**
 *
 * @author ASUS
 */
public class ManageItemsController {

    public static boolean addItem(ItemDTO item) throws Exception {
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.addItem(item);
    }

    public static boolean updateItem(ItemDTO item) throws Exception {
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.updateItem(item);
    }

    public static boolean deleteItem(ItemDTO item) throws Exception {
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.deleteItem(item);
    }

    public static List<ItemDTO> getAll() throws Exception {
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.getAll();
    }

    public static ItemDTO searchItem(String id) throws Exception {
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.SearchItem(id);
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
    }

    public static boolean reserveItem(String itemCode) throws Exception {
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.reserve(itemCode);
    }

    public static boolean releaseItem(String itemCode) throws Exception {
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.release(itemCode);
    }
}
