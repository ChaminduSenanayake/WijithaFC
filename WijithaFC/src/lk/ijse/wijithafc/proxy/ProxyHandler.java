/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithaFC.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.ServiceFactory.ServiceTypes;
import lk.ijse.wijithafc.service.SuperService;
import lk.ijse.wijithafc.service.custom.BatchService;
import lk.ijse.wijithafc.service.custom.CategoryService;
import lk.ijse.wijithafc.service.custom.GRNDetailService;
import lk.ijse.wijithafc.service.custom.GRNService;
import lk.ijse.wijithafc.service.custom.ItemService;
import lk.ijse.wijithafc.service.custom.LoginService;
import lk.ijse.wijithafc.service.custom.OrderDetailService;
import lk.ijse.wijithafc.service.custom.OrderService;
import lk.ijse.wijithafc.service.custom.ReportService;
import lk.ijse.wijithafc.service.custom.SupplierService;

/**
 *
 * @author ASUS
 */
public class ProxyHandler implements ServiceFactory {

    private static ProxyHandler proxyHandler;
    private ServiceFactory serviceFactory;
    private ItemService itemService;
    private SupplierService supplierService;
    private BatchService batchService;
    private GRNService gRNService;
    private OrderService orderService;
    private LoginService loginService;
    private ReportService reportService;
    private CategoryService categoryService;

    private ProxyHandler() {
        try {
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/wijithaFC");
            itemService = (ItemService) serviceFactory.getService(ServiceTypes.ITEM);
            supplierService = (SupplierService) serviceFactory.getService(ServiceTypes.SUPPLIER);
            batchService = (BatchService) serviceFactory.getService(ServiceTypes.BATCH);
            gRNService = (GRNService) serviceFactory.getService(ServiceTypes.GRN);
            orderService = (OrderService) serviceFactory.getService(ServiceTypes.ORDER);
            loginService = (LoginService) serviceFactory.getService(ServiceTypes.LOGIN);
            reportService = (ReportService) serviceFactory.getService(ServiceTypes.REPORT);
            categoryService = (CategoryService) serviceFactory.getService(ServiceTypes.CATEGOTY);
        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ProxyHandler getInstance() {
        if (proxyHandler == null) {
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type) {
            case ITEM:
                return itemService;
            case SUPPLIER:
                return supplierService;
            case BATCH:
                return batchService;
            case GRN:
                return gRNService;
            case ORDER:
                return orderService;
            case LOGIN:
                return loginService;
            case REPORT:
                return reportService;
            case CATEGOTY:
                return categoryService;
            default:
                return null;
        }
    }

}
