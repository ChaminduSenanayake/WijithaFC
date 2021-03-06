/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithaFC.view;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.wijithaFC.controller.ManageSupplierController;
import lk.ijse.wijithafc.common.IDGenerator;
import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.observer.Observer;

/**
 *
 * @author ASUS
 */
public class DialogFormAddSupplier extends javax.swing.JDialog implements Observer {

    /**
     * Creates new form AddOwner
     */
    public DialogFormAddSupplier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadNewID();
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageSupplierController.getSubject().registerObserver(this);
        } catch (RemoteException ex) {
            Logger.getLogger(DialogFormAddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DialogFormAddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtID.requestFocus();
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
        txtID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAda = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        btnCancel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel8.setBackground(new java.awt.Color(250, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 135, 173), 5));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(29, 120, 156));
        jLabel41.setText("Add New Supplier");
        jPanel8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 40));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(40, 135, 173));
        jLabel27.setText("Supplier ID         -");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 30));

        txtID.setBackground(new java.awt.Color(250, 255, 255));
        txtID.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel8.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 220, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(40, 135, 173));
        jLabel15.setText("Address               -");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 30));

        txtAddress.setBackground(new java.awt.Color(250, 255, 255));
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAddress.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel8.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 910, 30));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(40, 135, 173));
        jLabel45.setText("Company Name  -");
        jPanel8.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, 30));

        txtName.setBackground(new java.awt.Color(250, 255, 255));
        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel8.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 910, 30));

        btnAda.setBackground(new java.awt.Color(102, 102, 102));
        btnAda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAda.setForeground(new java.awt.Color(255, 255, 255));
        btnAda.setText("+ New Supplier");
        btnAda.setOpaque(true);
        btnAda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdaMouseClicked(evt);
            }
        });
        jPanel8.add(btnAda, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 150, 50));

        txtContactNo.setBackground(new java.awt.Color(250, 255, 255));
        txtContactNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtContactNo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 220, 30));

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
        jPanel8.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 340, 130, 50));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(40, 135, 173));
        jLabel14.setText("Contact NO         -");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdaMouseClicked
        try {
            SupplierDTO dTO = new SupplierDTO(txtID.getText(), txtName.getText(), txtAddress.getText(), txtContactNo.getText());
            boolean addSupplier = ManageSupplierController.addSupplier(dTO);
            if (addSupplier) {
                JOptionPane.showMessageDialog(null, "Supplier has been added successfully");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
        } catch (Exception ex) {
            Logger.getLogger(DialogFormAddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdaMouseClicked

    private void btnCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMousePressed
        btnCancel.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_btnCancelMousePressed

    private void btnCancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseReleased
        btnCancel.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnCancelMouseReleased

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtAddress.requestFocus();
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        txtContactNo.requestFocus();
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        txtName.requestFocus();
    }//GEN-LAST:event_txtIDActionPerformed

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
            java.util.logging.Logger.getLogger(DialogFormAddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogFormAddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogFormAddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogFormAddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogFormAddSupplier dialog = new DialogFormAddSupplier(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel btnAda;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void loadNewID() {
        try {
            String lastID = IDGenerator.getLastID(IDGenerator.IdType.SUPPLIER);
            txtID.setText(lastID);
        } catch (Exception ex) {
            Logger.getLogger(DialogFormAddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateObservers() throws Exception {
        loadNewID();
    }

}
