/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.view.panels;

import java.awt.Dialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import lk.ijse.jasper.IJSEJasperViewer;
import lk.ijse.wijithafc.controller.ReportsController;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author ASUS
 */
public class ReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportPanel
     */
    public ReportPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtOrderID = new org.jdesktop.swingx.JXTextField();
        btnReportOrder = new org.jdesktop.swingx.JXButton();
        jPanel2 = new javax.swing.JPanel();
        txtUserID = new org.jdesktop.swingx.JXTextField();
        txtDate = new org.jdesktop.swingx.JXTextField();
        btnUserDailyReport = new org.jdesktop.swingx.JXButton();
        jPanel3 = new javax.swing.JPanel();
        btnexp1 = new org.jdesktop.swingx.JXButton();
        jPanel4 = new javax.swing.JPanel();
        btnexp = new org.jdesktop.swingx.JXButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtOrderID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOrderID.setPrompt("Order ID");
        jPanel1.add(txtOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 33, 220, -1));

        btnReportOrder.setBackground(new java.awt.Color(0, 153, 153));
        btnReportOrder.setText("Report");
        btnReportOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportOrderActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 140, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 320, 210));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUserID.setPrompt("User ID");
        jPanel2.add(txtUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 32, 224, -1));

        txtDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDate.setPrompt("Date");
        jPanel2.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 72, 224, -1));

        btnUserDailyReport.setBackground(new java.awt.Color(0, 153, 153));
        btnUserDailyReport.setText("Report");
        btnUserDailyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserDailyReportActionPerformed(evt);
            }
        });
        jPanel2.add(btnUserDailyReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 140, 50));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 320, 210));

        btnexp1.setBackground(new java.awt.Color(0, 153, 153));
        btnexp1.setText("Batch expire Report");
        btnexp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexp1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(btnexp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(btnexp1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 320, 210));

        btnexp.setBackground(new java.awt.Color(0, 153, 153));
        btnexp.setText("Batch expire Report");
        btnexp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(btnexp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(btnexp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 320, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportOrderActionPerformed
       try {
            JasperPrint filledReport = ReportsController.getBill(txtOrderID.getText());
            IJSEJasperViewer frmJasperViewer = new IJSEJasperViewer(filledReport);
            frmJasperViewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frmJasperViewer.setTitle("Orderss");
            frmJasperViewer.setSize(1000, 800);
            frmJasperViewer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            frmJasperViewer.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ReportPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportOrderActionPerformed

    private void btnexpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexpActionPerformed
      try {
            JasperPrint filledReport = ReportsController.getExpiringBatches();
            IJSEJasperViewer frmJasperViewer = new IJSEJasperViewer(filledReport);
            frmJasperViewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frmJasperViewer.setTitle("Expiring Batches");
            frmJasperViewer.setSize(1000, 800);
            frmJasperViewer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            frmJasperViewer.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ReportPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnexpActionPerformed

    private void btnUserDailyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDailyReportActionPerformed
       try {
            JasperPrint filledReport = ReportsController.getUserReport(txtUserID.getText(), txtDate.getText());
            IJSEJasperViewer frmJasperViewer = new IJSEJasperViewer(filledReport);
            frmJasperViewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frmJasperViewer.setTitle("User Report By Date");
            frmJasperViewer.setSize(1000, 800);
            frmJasperViewer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            frmJasperViewer.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ReportPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUserDailyReportActionPerformed

    private void btnexp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnexp1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnReportOrder;
    private org.jdesktop.swingx.JXButton btnUserDailyReport;
    private org.jdesktop.swingx.JXButton btnexp;
    private org.jdesktop.swingx.JXButton btnexp1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private org.jdesktop.swingx.JXTextField txtDate;
    private org.jdesktop.swingx.JXTextField txtOrderID;
    private org.jdesktop.swingx.JXTextField txtUserID;
    // End of variables declaration//GEN-END:variables
}
