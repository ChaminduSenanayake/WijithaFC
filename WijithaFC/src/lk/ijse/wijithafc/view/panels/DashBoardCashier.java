/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.view.panels;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class DashBoardCashier extends javax.swing.JPanel {

    /**
     * Creates new form DashBoardCashier
     */
    public DashBoardCashier() {
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
        lblAddGRN = new javax.swing.JLabel();
        lblViewGRN = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddGRN.setBackground(new java.awt.Color(102, 102, 102));
        lblAddGRN.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblAddGRN.setForeground(new java.awt.Color(204, 204, 204));
        lblAddGRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddGRN.setText("Make Order");
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(0, 102, 153));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        lblAddGRN.setBorder(dropShadowBorder1);
        lblAddGRN.setOpaque(true);
        lblAddGRN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddGRNMouseClicked(evt);
            }
        });
        jPanel1.add(lblAddGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        lblViewGRN.setBackground(new java.awt.Color(255, 255, 255));
        lblViewGRN.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblViewGRN.setForeground(new java.awt.Color(204, 204, 204));
        lblViewGRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViewGRN.setText("View Orders");
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShadowColor(new java.awt.Color(0, 102, 153));
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        lblViewGRN.setBorder(dropShadowBorder2);
        lblViewGRN.setOpaque(true);
        lblViewGRN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewGRNMouseClicked(evt);
            }
        });
        jPanel1.add(lblViewGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 240, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAddGRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddGRNMouseClicked
        lblAddGRN.setBackground(new Color(102,102,102));
        lblViewGRN.setBackground(new Color(255,255,255));
        JPanel middlePanel = lk.ijse.wijithaFC.view.MainFrame.getMiddlePanel();
        CashierPanel cashierPanel = new CashierPanel();
        middlePanel.removeAll();
        cashierPanel.setSize(middlePanel.getSize());
        middlePanel.add(cashierPanel);
        middlePanel.revalidate();
        middlePanel.repaint();
    }//GEN-LAST:event_lblAddGRNMouseClicked

    private void lblViewGRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewGRNMouseClicked
        lblViewGRN.setBackground(new Color(102,102,102));
        lblAddGRN.setBackground(new Color(255,255,255));
        JPanel middlePanel = lk.ijse.wijithaFC.view.MainFrame.getMiddlePanel();
        ViewOrders viewOrders = new ViewOrders();
        middlePanel.removeAll();
        viewOrders.setSize(middlePanel.getSize());
        middlePanel.add(viewOrders);
        middlePanel.revalidate();
        middlePanel.repaint();
    }//GEN-LAST:event_lblViewGRNMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddGRN;
    private javax.swing.JLabel lblViewGRN;
    // End of variables declaration//GEN-END:variables
}
