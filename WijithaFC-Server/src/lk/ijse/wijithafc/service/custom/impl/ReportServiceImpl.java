/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.wijithafc.business.BOFactory;
import lk.ijse.wijithafc.business.custom.ReportBO;
import lk.ijse.wijithafc.service.custom.ReportService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author ASUS
 */
public class ReportServiceImpl extends UnicastRemoteObject implements ReportService {

    private ReportBO reportBO;

    public ReportServiceImpl() throws RemoteException {
        reportBO=(ReportBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REPORT);
    }

    @Override
    public JasperPrint getBill(String orderID) throws Exception {
       return reportBO.getBill(orderID);
    }

    @Override
    public JasperPrint getUserReport(String userID, String date) throws Exception {
       return reportBO.getUserReport(userID, date);
    }

    @Override
    public JasperPrint getExpiringBatches() throws Exception {
       return reportBO.getExpiringBatches();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
