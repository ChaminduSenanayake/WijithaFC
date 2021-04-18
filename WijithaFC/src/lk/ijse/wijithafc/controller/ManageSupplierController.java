/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithaFC.controller;

import java.util.List;
import lk.ijse.wijithaFC.proxy.ProxyHandler;
import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.custom.SupplierService;

/**
 *
 * @author ASUS
 */
public class ManageSupplierController {

    public static boolean addSupplier(SupplierDTO dTO) throws Exception {
        SupplierService service = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return service.addSupplier(dTO);
    }

    public static boolean updateSupplier(SupplierDTO dTO) throws Exception {
        SupplierService service = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return service.updateSupplier(dTO);
    }

    public static boolean deleteSupplier(SupplierDTO dTO) throws Exception {
        SupplierService service = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return service.deleteSupplier(dTO);
    }

    public static List<SupplierDTO> getAll() throws Exception {
        SupplierService service = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return service.getAll();
    }

    public static SupplierDTO searchSupplier(String id) throws Exception {
        SupplierService service = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return service.SearchSupplier(id);
    }

    public static SupplierDTO searchSupplierByName(String name) throws Exception {
        SupplierService service = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return service.SearchSupplierByName(name);
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
    }

    public static boolean reserveSupplier(String itemCode) throws Exception {
        SupplierService service = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return service.reserve(itemCode);
    }

    public static boolean releaseSupplier(String itemCode) throws Exception {
        SupplierService service = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return service.release(itemCode);
    }
}
