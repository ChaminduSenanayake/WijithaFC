/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.controller;

import lk.ijse.wijithaFC.proxy.ProxyHandler;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.custom.ReportService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author ASUS
 */
public class ReportsController {
     public static JasperPrint getBill(String orderID) throws Exception {
         ReportService reportService=(ReportService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.REPORT);
        return reportService.getBill(orderID);

    }
     public static JasperPrint getUserReport(String userID, String date) throws Exception {
          ReportService reportService=(ReportService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.REPORT);
          return reportService.getUserReport(userID, date);
     }
         
    public static JasperPrint getExpiringBatches() throws Exception {
         ReportService reportService=(ReportService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.REPORT);
         return reportService.getExpiringBatches();
     }
}
