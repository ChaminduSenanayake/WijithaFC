/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.controller;

import java.util.List;
import lk.ijse.wijithaFC.proxy.ProxyHandler;
import lk.ijse.wijithafc.dto.BatchDTO;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.SuperService;
import lk.ijse.wijithafc.service.custom.BatchService;

/**
 *
 * @author ASUS
 */
public class ManageBatchController {

    public static boolean addBatch(BatchDTO batch) throws Exception {
        BatchService service = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return service.addBatch(batch);
    }

    public static boolean updateBatch(BatchDTO batch) throws Exception {
        BatchService service = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return service.updateBatch(batch);
    }

    public static boolean deleteBatch(BatchDTO batch) throws Exception {
        BatchService service = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return service.deleteBatch(batch);
    }

    public static List<BatchDTO> getAll() throws Exception {
        BatchService service = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return service.getAll();
    }

    public static BatchDTO searchBatch(String id) throws Exception {
        BatchService service = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return service.SearchBatch(id);
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
    }

    public static boolean reserveBatch(String itemCode) throws Exception {
        BatchService service = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return service.reserve(itemCode);
    }

    public static boolean releaseBatch(String itemCode) throws Exception {
        BatchService service = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return service.release(service);
    }

    public static List<BatchDTO> searchByItemCode(String itemCode) throws Exception {
        BatchService service = (BatchService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BATCH);
        return service.SearchByItemCode(itemCode);
    }
}
