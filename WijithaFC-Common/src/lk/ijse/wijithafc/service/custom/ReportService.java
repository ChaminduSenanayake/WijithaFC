/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom;

import lk.ijse.wijithafc.service.SuperService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author ASUS
 */
public interface ReportService extends SuperService{
     public JasperPrint getBill(String orderID) throws Exception;

    public JasperPrint getUserReport(String userID, String date) throws Exception;

    public JasperPrint getExpiringBatches() throws Exception;
}
