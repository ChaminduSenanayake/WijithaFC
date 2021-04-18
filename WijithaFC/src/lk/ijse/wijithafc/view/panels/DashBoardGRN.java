/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.view.panels;

import java.awt.Color;
import javax.swing.JPanel;
import lk.ijse.wijithaFC.view.MainFrame;

/**
 *
 * @author ASUS
 */
public class DashBoardGRN extends javax.swing.JPanel {

    /**
     * Creates new form DashBoardGRN
     */
    public DashBoardGRN() {
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

        lblAddGRN = new javax.swing.JLabel();
        lblViewGRN = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddGRN.setBackground(new java.awt.Color(102, 102, 102));
        lblAddGRN.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblAddGRN.setForeground(new java.awt.Color(204, 204, 204));
        lblAddGRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddGRN.setText("ADD GRN");
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
        add(lblAddGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        lblViewGRN.setBackground(new java.awt.Color(255, 255, 255));
        lblViewGRN.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblViewGRN.setForeground(new java.awt.Color(204, 204, 204));
        lblViewGRN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViewGRN.setText("View GRN");
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
        add(lblViewGRN, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 240, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void lblAddGRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddGRNMouseClicked
       lblAddGRN.setBackground(new Color(102,102,102));
        lblViewGRN.setBackground(new Color(255,255,255));
        GRNPanel grnPanel = new GRNPanel();
        JPanel middlePanel = MainFrame.getMiddlePanel();
        middlePanel.removeAll();
        grnPanel.setSize(middlePanel.getSize());
        middlePanel.add(grnPanel);
        middlePanel.revalidate();
        middlePanel.repaint();
    }//GEN-LAST:event_lblAddGRNMouseClicked

    private void lblViewGRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewGRNMouseClicked
       lblViewGRN.setBackground(new Color(102,102,102));
       lblAddGRN.setBackground(new Color(255,255,255));
       
        JPanel pnlMiddle = MainFrame.getMiddlePanel();
        lk.ijse.wijithafc.view.panels.ViewGRNPanel view = new lk.ijse.wijithafc.view.panels.ViewGRNPanel();
        pnlMiddle.removeAll();
        view.setSize(pnlMiddle.getSize());
        pnlMiddle.add(view);
        pnlMiddle.revalidate();
        pnlMiddle.repaint();
    }//GEN-LAST:event_lblViewGRNMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAddGRN;
    private javax.swing.JLabel lblViewGRN;
    // End of variables declaration//GEN-END:variables
}
