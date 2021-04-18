/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.view.panels;

import com.sun.javafx.iio.ImageStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.wijithaFC.controller.ManageItemsController;
import lk.ijse.wijithaFC.controller.ManageSupplierController;
import lk.ijse.wijithafc.controller.ManageBatchController;
import lk.ijse.wijithafc.controller.ManageGRNController;
import lk.ijse.wijithafc.dto.BatchDTO;
import lk.ijse.wijithafc.dto.GRNDTO;
import lk.ijse.wijithafc.dto.GRNDetailDTO;
import lk.ijse.wijithafc.dto.ItemDTO;
import lk.ijse.wijithafc.dto.SupplierDTO;

/**
 *
 * @author ASUS
 */
public class ViewGRNPanel extends javax.swing.JPanel {

   

    /**
     * Creates new form ViewGRNPanel
     */
    public ViewGRNPanel() {
        initComponents();
        loadAll();
        loadAllSupplier();

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
        jLabel44 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        cmbCompanyName = new org.jdesktop.swingx.JXComboBox();
        txtSupplierID = new javax.swing.JTextField();
        cmbGRNID = new org.jdesktop.swingx.JXComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGRNDetail = new org.jdesktop.swingx.JXTable();
        btnEditSupplier = new javax.swing.JLabel();
        btnRemoveSupplier = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText(" Supplier ID   -");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 120, 30));

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("GRN Details");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 40));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText(" GRN NO        -");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 120, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText(" Date              -");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, 30));

        txtDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 260, 30));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText(" Company Name       -");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 160, 30));

        cmbCompanyName.setBorder(null);
        cmbCompanyName.setEditable(true);
        cmbCompanyName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbCompanyName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCompanyNameItemStateChanged(evt);
            }
        });
        cmbCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCompanyNameActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 990, 30));

        txtSupplierID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSupplierID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 260, 30));

        cmbGRNID.setBorder(null);
        cmbGRNID.setEditable(true);
        cmbGRNID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbGRNID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGRNIDItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbGRNID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 260, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 200));

        tblGRNDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch", "ItemCode", "Unit Cost", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGRNDetail);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1600, 300));

        btnEditSupplier.setBackground(new java.awt.Color(102, 102, 102));
        btnEditSupplier.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnEditSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btnEditSupplier.setText("      Edit ");
        btnEditSupplier.setOpaque(true);
        btnEditSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditSupplierMouseClicked(evt);
            }
        });
        add(btnEditSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 590, 130, 50));

        btnRemoveSupplier.setBackground(new java.awt.Color(102, 102, 102));
        btnRemoveSupplier.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRemoveSupplier.setForeground(new java.awt.Color(189, 103, 107));
        btnRemoveSupplier.setText("  Remove");
        btnRemoveSupplier.setOpaque(true);
        btnRemoveSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveSupplierMouseClicked(evt);
            }
        });
        add(btnRemoveSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 590, 130, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditSupplierMouseClicked
        List<GRNDetailDTO> dTOs = new ArrayList<>();
        if (tblGRNDetail.getRowCount() >= 0) {
            for (int i = 0; i < tblGRNDetail.getRowCount(); i++) {
                GRNDetailDTO dTO = new GRNDetailDTO(tblGRNDetail.getValueAt(i, 0).toString(), Double.parseDouble(tblGRNDetail.getValueAt(i, 2).toString()), Integer.parseInt(tblGRNDetail.getValueAt(i, 3).toString()));
                dTOs.add(dTO);
            }
        }
        if (cmbGRNID.getSelectedIndex() != -1) {
            try {
                GRNDTO grndto = new GRNDTO(cmbGRNID.getSelectedItem().toString(), txtDate.getText(), txtSupplierID.getText(), dTOs);
                boolean updateGRN = ManageGRNController.updateGRN(grndto);
                if (updateGRN) {
                    JOptionPane.showMessageDialog(null, "GRN has been updated successfully");
                    clearFields();
                    loadAll();
                } else {
                    JOptionPane.showMessageDialog(null, "updated Fail");
                }
            } catch (Exception ex) {
                Logger.getLogger(ViewGRNPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnEditSupplierMouseClicked

    private void btnRemoveSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveSupplierMouseClicked
        List<GRNDetailDTO> dTOs = new ArrayList<>();
        if (tblGRNDetail.getRowCount() >= 0) {
            for (int i = 0; i < tblGRNDetail.getRowCount(); i++) {
                GRNDetailDTO dTO = new GRNDetailDTO(tblGRNDetail.getValueAt(i, 0).toString(), Double.parseDouble(tblGRNDetail.getValueAt(i, 2).toString()), Integer.parseInt(tblGRNDetail.getValueAt(i, 3).toString()));
                dTOs.add(dTO);
            }
        }
        if (cmbGRNID.getSelectedIndex() != -1) {
            GRNDTO grndto = new GRNDTO(cmbGRNID.getSelectedItem().toString(), txtDate.getText(), txtSupplierID.getText(), dTOs);
            try {
                boolean deleteGRN = ManageGRNController.deleteGRN(grndto);
                if (deleteGRN) {
                    JOptionPane.showMessageDialog(null, "GRN has been Deleted successfully");
                    clearFields();
                    loadAll();
                } else {
                    JOptionPane.showMessageDialog(null, "Deleted Fail");
                }
            } catch (Exception ex) {
                Logger.getLogger(ViewGRNPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRemoveSupplierMouseClicked

    private void cmbGRNIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGRNIDItemStateChanged
        DefaultTableModel dtm = (DefaultTableModel) tblGRNDetail.getModel();
        dtm.setRowCount(0);
        try {
            if (cmbGRNID.getSelectedIndex() != -1) {
                GRNDTO searchGRN = ManageGRNController.searchGRN(cmbGRNID.getSelectedItem().toString());
                txtDate.setText(searchGRN.getDate());
                txtSupplierID.setText(searchGRN.getSupplierID());
                SupplierDTO searchSupplier = ManageSupplierController.searchSupplier(searchGRN.getSupplierID());
                cmbCompanyName.setSelectedItem(searchSupplier.getCompanyName());
                for (GRNDetailDTO dto : searchGRN.getDetailList()) {
                    BatchDTO searchBatch = ManageBatchController.searchBatch(dto.getBatchID());
                    Object[] rawData = {dto.getBatchID(), searchBatch.getItemCode(), dto.getUnitCost(), dto.getQty()};
                    dtm.addRow(rawData);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ViewGRNPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbGRNIDItemStateChanged

    private void txtSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierIDActionPerformed
        try {
            SupplierDTO searchSupplier = ManageSupplierController.searchSupplier(txtSupplierID.getText());
            cmbCompanyName.setSelectedItem(searchSupplier.getCompanyName());
        } catch (Exception ex) {
            Logger.getLogger(ViewGRNPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSupplierIDActionPerformed

    private void cmbCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCompanyNameActionPerformed

    private void cmbCompanyNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCompanyNameItemStateChanged
        if (cmbCompanyName.getSelectedIndex() != -1) {
            try {
                SupplierDTO searchSupplier = ManageSupplierController.searchSupplierByName(cmbCompanyName.getSelectedItem().toString());
                txtSupplierID.setText(searchSupplier.getSupplierID());
            } catch (Exception ex) {
                Logger.getLogger(ViewGRNPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmbCompanyNameItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEditSupplier;
    private javax.swing.JLabel btnRemoveSupplier;
    private org.jdesktop.swingx.JXComboBox cmbCompanyName;
    private org.jdesktop.swingx.JXComboBox cmbGRNID;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tblGRNDetail;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtSupplierID;
    // End of variables declaration//GEN-END:variables

    private void loadAll() {
        try {
            List<GRNDTO> all = ManageGRNController.getAll();
            cmbGRNID.removeAllItems();
            if (all != null) {
                for (GRNDTO grnd : all) {
                    cmbGRNID.addItem(grnd.getGRNID());
                }
            }
           
        } catch (Exception ex) {
            Logger.getLogger(ViewGRNPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllSupplier() {

        cmbCompanyName.removeAllItems();
        try {
            List<SupplierDTO> all = ManageSupplierController.getAll();
            if (all != null) {
                for (SupplierDTO supplier : all) {
                    cmbCompanyName.addItem(supplier.getCompanyName());
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(lk.ijse.wijithafc.view.panels.GRNPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearFields() {
        DefaultTableModel dtm = (DefaultTableModel) tblGRNDetail.getModel();
        dtm.setRowCount(0);
        txtDate.setText(null);
        txtSupplierID.setText(null);
    }
    
  
}