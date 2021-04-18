/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.controller;

import java.util.List;
import lk.ijse.wijithaFC.proxy.ProxyHandler;
import lk.ijse.wijithafc.dto.GRNDTO;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.custom.GRNService;

/**
 *
 * @author ASUS
 */
public class ManageGRNController {

    public static boolean addGRN(GRNDTO grn) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.addGRN(grn);
    }

    public static boolean updateGRN(GRNDTO dTO) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.updateGRN(dTO);
    }

    public static boolean deleteGRN(GRNDTO grn) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.deleteGRN(grn);
    }

    public static List<GRNDTO> getAll() throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.getAll();
    }

    public static GRNDTO searchGRN(String id) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.SearchGRN(id);
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
    }

    public static boolean reserveGRN(String itemCode) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.reserve(itemCode);
    }

    public static boolean releaseGRN(String itemCode) throws Exception {
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.release(itemCode);
    }
}
