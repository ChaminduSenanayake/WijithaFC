/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.view.panels;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.wijithaFC.controller.ManageSupplierController;
import lk.ijse.wijithaFC.view.DialogFormAddSupplier;
import lk.ijse.wijithaFC.view.MainFrame;
import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.observer.Observer;

/**
 *
 * @author ASUS
 */
public class SupplierPanel extends javax.swing.JPanel implements Observer {
private String reservedID = "";
    /**
     * Creates new form SupplierPanel
     */
    public SupplierPanel() {
        initComponents();
        loadAll();
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageSupplierController.getSubject().registerObserver(this);
        } catch (RemoteException ex) {
            Logger.getLogger(SupplierPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SupplierPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblSupplierData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblSupplierData.getSelectedRow() == -1) {
                   // btnRemoveSupplier.setEnabled(false);
                    return;
                }
                try {
                    if (reservedID == "") {
                        ManageSupplierController.releaseSupplier(reservedID);
                    }
                    reservedID = tblSupplierData.getValueAt(tblSupplierData.getSelectedRow(), 0).toString();
                    boolean reserveCustomer = ManageSupplierController.reserveSupplier(reservedID);

                    if (reserveCustomer) {
                        int row = tblSupplierData.getSelectedRow();
                        cmbSupplierID.setSelectedItem(tblSupplierData.getValueAt(tblSupplierData.getSelectedRow(), 0));
                    } else {
                        JOptionPane.showMessageDialog(SupplierPanel.this, "Item has been already reserved");
                        tblSupplierData.clearSelection();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ItemPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplierData = new org.jdesktop.swingx.JXTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnEditSupplier = new javax.swing.JLabel();
        btnRemoveSupplier = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtNum = new javax.swing.JTextField();
        cmbSupplierID = new org.jdesktop.swingx.JXComboBox();
        txtCompanyName = new javax.swing.JTextField();
        btnAddNew = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSupplierData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Company Name", "Address", "Contact No"
            }
        ));
        tblSupplierData.setEditable(false);
        tblSupplierData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSupplierData);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1600, 270));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText(" Address                -");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText(" Company Name   -");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, 30));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText(" Supplier ID           -");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText(" Contact Number  -");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 160, 30));

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("Edit Supplier Details");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 40));

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
        jPanel1.add(btnEditSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 240, 130, 50));

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
        jPanel1.add(btnRemoveSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 240, 130, 50));

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAddress.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 910, 30));

        txtNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNum.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(txtNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 260, 30));

        cmbSupplierID.setBorder(null);
        cmbSupplierID.setEditable(true);
        cmbSupplierID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbSupplierID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSupplierIDItemStateChanged(evt);
            }
        });
        cmbSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierIDActionPerformed(evt);
            }
        });
        jPanel1.add(cmbSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 62, 260, 30));

        txtCompanyName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCompanyName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCompanyName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCompanyName.setFocusCycleRoot(true);
        jPanel1.add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 910, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 1600, 300));

        btnAddNew.setBackground(new java.awt.Color(204, 204, 204));
        btnAddNew.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAddNew.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/wijithaFC/images/add.png"))); // NOI18N
        btnAddNew.setText(" New Supplier");
        btnAddNew.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAddNew.setOpaque(true);
        btnAddNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddNewMouseClicked(evt);
            }
        });
        add(btnAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void tblSupplierDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierDataMouseClicked
        if (tblSupplierData.getSelectedRow() != -1) {
            cmbSupplierID.setSelectedItem(tblSupplierData.getValueAt(tblSupplierData.getSelectedRow(), 0));
        }
    }//GEN-LAST:event_tblSupplierDataMouseClicked

    private void btnEditSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditSupplierMouseClicked
        try {
            SupplierDTO dTO = new SupplierDTO(cmbSupplierID.getSelectedItem().toString(), txtCompanyName.getText(), txtAddress.getText(), txtNum.getText());
            boolean updateSupplier = ManageSupplierController.updateSupplier(dTO);
            if (updateSupplier) {
                JOptionPane.showMessageDialog(null, "Supplier has been updated successfully");
                clearFields();
                loadAll();
            } else {
                JOptionPane.showMessageDialog(null, "update Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(SupplierPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditSupplierMouseClicked

    private void btnRemoveSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveSupplierMouseClicked
        try {
            SupplierDTO dTO = new SupplierDTO(cmbSupplierID.getSelectedItem().toString(), txtCompanyName.getText(), txtAddress.getText(), txtNum.getText());
            boolean remove = ManageSupplierController.deleteSupplier(dTO);
            if (remove) {
                JOptionPane.showMessageDialog(null, "Supplier has been removed successfully");
                clearFields();
                loadAll();
            } else {
                JOptionPane.showMessageDialog(null, "removed Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(SupplierPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveSupplierMouseClicked

    private void btnAddNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewMouseClicked
        DialogFormAddSupplier addSupplier = new DialogFormAddSupplier(MainFrame.getMainFrame(), true);
        addSupplier.setVisible(true);
        loadAll();

    }//GEN-LAST:event_btnAddNewMouseClicked

    private void cmbSupplierIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSupplierIDItemStateChanged
        try {
            if (cmbSupplierID.getSelectedIndex() != -1) {
                SupplierDTO supplier = ManageSupplierController.searchSupplier(cmbSupplierID.getSelectedItem().toString());
                txtCompanyName.setText(supplier.getCompanyName());
                txtAddress.setText(supplier.getAddress());
                txtNum.setText(supplier.getContactNo());
            }
        } catch (Exception ex) {
            Logger.getLogger(ItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbSupplierIDItemStateChanged

    private void cmbSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSupplierIDActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddNew;
    private javax.swing.JLabel btnEditSupplier;
    private javax.swing.JLabel btnRemoveSupplier;
    private org.jdesktop.swingx.JXComboBox cmbSupplierID;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tblSupplierData;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
private void loadAll() {
        DefaultTableModel dtm = (DefaultTableModel) tblSupplierData.getModel();
        dtm.setRowCount(0);
        cmbSupplierID.removeAllItems();
        try {
            List<SupplierDTO> all = ManageSupplierController.getAll();
            if (all != null) {
                for (SupplierDTO supplier : all) {
                    Object[] rawData = {supplier.getSupplierID(), supplier.getCompanyName(), supplier.getAddress(), supplier.getContactNo()};
                    dtm.addRow(rawData);
                    cmbSupplierID.addItem(supplier.getSupplierID());
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(SupplierPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateObservers() throws Exception {
        clearFields();
        loadAll();
        
    }

    private void clearFields() {
       txtAddress.setText(null);
       txtCompanyName.setText(null);
       txtNum.setText(null);
    }
}