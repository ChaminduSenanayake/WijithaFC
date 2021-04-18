/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.view;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.wijithaFC.controller.ManageItemsController;
import lk.ijse.wijithafc.common.IDGenerator;
import lk.ijse.wijithafc.controller.ManageBatchController;
import lk.ijse.wijithafc.dto.BatchDTO;
import lk.ijse.wijithafc.dto.ItemDTO;
import lk.ijse.wijithafc.observer.Observer;

/**
 *
 * @author ASUS
 */
public class DialogFormAddNewBatch extends javax.swing.JDialog implements Observer {

    /**
     * Creates new form DialogAddNewBatch
     */
    public DialogFormAddNewBatch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadAll();
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageBatchController.getSubject().registerObserver(this);
            ManageItemsController.getSubject().registerObserver(this);
        } catch (RemoteException ex) {
            Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbItemCode.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtBatchID = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        txtDate = new org.jdesktop.swingx.JXDatePicker();
        cmbItemCode = new org.jdesktop.swingx.JXComboBox();
        jLabel16 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(250, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 135, 173), 5));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(29, 120, 156));
        jLabel41.setText("Add New Batch");
        jPanel8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 220, 40));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(40, 135, 173));
        jLabel27.setText("ItemCode    -");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 30));

        txtDesc.setBackground(new java.awt.Color(250, 255, 255));
        txtDesc.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtDesc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });
        jPanel8.add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 910, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(40, 135, 173));
        jLabel15.setText("Item Desc.  -");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, 30));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(40, 135, 173));
        jLabel45.setText("Batch ID      -");
        jPanel8.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 30));

        txtBatchID.setBackground(new java.awt.Color(250, 255, 255));
        txtBatchID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBatchID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBatchID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBatchIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBatchIDFocusLost(evt);
            }
        });
        txtBatchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBatchIDActionPerformed(evt);
            }
        });
        jPanel8.add(txtBatchID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 220, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(40, 135, 173));
        jLabel46.setText("Expire Date-");
        jPanel8.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 110, 30));

        btnAdd.setBackground(new java.awt.Color(102, 102, 102));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("+ New Batch");
        btnAdd.setOpaque(true);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel8.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 130, 50));

        btnCancel.setBackground(new java.awt.Color(217, 83, 79));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("       Cancel");
        btnCancel.setOpaque(true);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelMouseReleased(evt);
            }
        });
        jPanel8.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 130, 50));
        jPanel8.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 220, 30));

        cmbItemCode.setBorder(null);
        cmbItemCode.setEditable(true);
        cmbItemCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbItemCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItemCodeItemStateChanged(evt);
            }
        });
        jPanel8.add(cmbItemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 220, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(40, 135, 173));
        jLabel16.setText("Unit Cost     -");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, 30));

        txtCost.setBackground(new java.awt.Color(250, 255, 255));
        txtCost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCost.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(txtCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 220, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbItemCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItemCodeItemStateChanged
        try {
            if (cmbItemCode.getSelectedIndex() != -1) {
                ItemDTO dto = ManageItemsController.searchItem(cmbItemCode.getSelectedItem().toString());
                txtDesc.setText(dto.getDescription());
            }
        } catch (Exception ex) {
            Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbItemCodeItemStateChanged

    private void btnCancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseReleased
        btnCancel.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnCancelMouseReleased

    private void btnCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMousePressed
        btnCancel.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_btnCancelMousePressed

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        try {
            BatchDTO batchDTO = new BatchDTO(txtBatchID.getText(), cmbItemCode.getSelectedItem().toString(), 0, Double.parseDouble(txtCost.getText()), convertDate(txtDate.getDate()));
            boolean addItem = ManageBatchController.addBatch(batchDTO);
            if (addItem) {
                JOptionPane.showMessageDialog(null, "Batch has been added successfully");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
        } catch (Exception ex) {
            Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void txtBatchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBatchIDActionPerformed

    }//GEN-LAST:event_txtBatchIDActionPerformed

    private void txtBatchIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBatchIDFocusLost

    }//GEN-LAST:event_txtBatchIDFocusLost

    private void txtBatchIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBatchIDFocusGained

    }//GEN-LAST:event_txtBatchIDFocusGained

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        txtCost.requestFocus();
    }//GEN-LAST:event_txtDescActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogFormAddNewBatch dialog = new DialogFormAddNewBatch(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnCancel;
    private org.jdesktop.swingx.JXComboBox cmbItemCode;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtCost;
    private org.jdesktop.swingx.JXDatePicker txtDate;
    private javax.swing.JTextField txtDesc;
    // End of variables declaration//GEN-END:variables
    private void loadAll() {
        cmbItemCode.removeAllItems();
        try {
            List<ItemDTO> all = ManageItemsController.getAll();
            if (all != null) {
                for (ItemDTO itemDTO : all) {
                    cmbItemCode.addItem(itemDTO.getItemCode());
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(DialogFormAddNewBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String convertDate(Date date) {
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
        String dateString = sdfr.format(date);
        return dateString;
    }

    @Override
    public void updateObservers() throws Exception {
        loadAll();
    }
}