/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.jasper.JasperUtil;
import lk.ijse.jasper.Report;
import lk.ijse.wijithafc.business.custom.ReportBO;
import lk.ijse.wijithafc.resource.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
@Report("lk.ijse.wijithafc.reports")
public class ReportBOImpl implements ReportBO {

    private Connection connection;

    @Override
    public JasperPrint getBill(String orderID) throws Exception {
        JasperUtil.init(ReportBOImpl.class);
        JasperReportsContext ctx = JasperUtil.getReportContext();
        try {
            JasperReport progressingJR = JasperUtil.getCompiledReport("Bill.jasper");
            JasperFillManager fillManager = JasperFillManager.getInstance(ctx);
            HashMap<String, Object> reportParams = new HashMap<>();
            reportParams.put("orderID", orderID);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.doWork((cnctn) -> {
                connection = cnctn;
            });
            JasperPrint filledReport = fillManager.fill(progressingJR, reportParams, connection);
            return filledReport;
        } catch (JRException ex) {
            Logger.getLogger(ReportBOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public JasperPrint getUserReport(String userID, String date) throws Exception {
        JasperUtil.init(ReportBOImpl.class);
        JasperReportsContext ctx = JasperUtil.getReportContext();
        try {
            JasperReport progressingJR = JasperUtil.getCompiledReport("UserReport.jasper");
            JasperFillManager fillManager = JasperFillManager.getInstance(ctx);
            HashMap<String, Object> reportParams = new HashMap<>();
            reportParams.put("userID", userID);
            reportParams.put("orderDate", date);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.doWork((cnctn) -> {
                connection = cnctn;
            });
            JasperPrint filledReport = fillManager.fill(progressingJR, reportParams, connection);
            return filledReport;
        } catch (JRException ex) {
            Logger.getLogger(ReportBOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public JasperPrint getExpiringBatches() throws Exception {
        JasperUtil.init(ReportBOImpl.class);
        JasperReportsContext ctx = JasperUtil.getReportContext();
        try {
            JasperReport progressingJR = JasperUtil.getCompiledReport("BatchExpireReport.jasper");
            JasperFillManager fillManager = JasperFillManager.getInstance(ctx);
            HashMap<String, Object> reportParams = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.doWork((cnctn) -> {
                connection = cnctn;
            });
            JasperPrint filledReport = fillManager.fill(progressingJR, reportParams, connection);
            return filledReport;
        } catch (JRException ex) {
            Logger.getLogger(ReportBOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
