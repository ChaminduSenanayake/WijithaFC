/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.SuperService;
import lk.ijse.wijithafc.service.custom.impl.BatchServiceImpl;
import lk.ijse.wijithafc.service.custom.impl.CategoryServiceImpl;
import lk.ijse.wijithafc.service.custom.impl.GRNServiceImpl;
import lk.ijse.wijithafc.service.custom.impl.ItemServiceImpl;
import lk.ijse.wijithafc.service.custom.impl.LoginServiceImpl;
import lk.ijse.wijithafc.service.custom.impl.OrderServiceImpl;
import lk.ijse.wijithafc.service.custom.impl.ReportServiceImpl;
import lk.ijse.wijithafc.service.custom.impl.SupplierServiceImpl;

/**
 *
 * @author ASUS
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    public static ServiceFactory serviceFactory;

    private ServiceFactoryImpl() throws RemoteException {

    }

    public static ServiceFactory getInstance() throws RemoteException {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type) {
            case ITEM:
                return new ItemServiceImpl();
            case SUPPLIER:
                return new SupplierServiceImpl();
            case BATCH:
                return new BatchServiceImpl();
            case GRN:
                return new GRNServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            case LOGIN:
                return new LoginServiceImpl();
            case REPORT:
                return new ReportServiceImpl();
            case CATEGOTY:
                return new CategoryServiceImpl();
            default:
                return null;
        }
    }
}
