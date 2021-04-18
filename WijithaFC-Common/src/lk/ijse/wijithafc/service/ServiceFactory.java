/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service;

import java.rmi.Remote;

/**
 *
 * @author ASUS
 */
public interface ServiceFactory extends Remote{
    public enum ServiceTypes{
        ITEM,SUPPLIER,BATCH,GRN,ORDER,LOGIN,REPORT,CATEGOTY
    }
    
    public SuperService getService(ServiceTypes type) throws Exception;
}
