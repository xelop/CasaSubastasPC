/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subastas.UI;

/**
 *
 * @author Xelop
 */
public class AdministratorMenu extends javax.swing.JFrame {

    /**
     * Creates new form AdministratorMenu
     */
    public AdministratorMenu() {
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

        _lbl_Administrator = new javax.swing.JLabel();
        _btn_SuspendAgent = new javax.swing.JButton();
        _btn_CreateAgent1 = new javax.swing.JButton();
        _btn_ActivateAgent = new javax.swing.JButton();
        _btn_ModifyAgent = new javax.swing.JButton();
        _btn_More = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _lbl_Administrator.setText("ADMINISTRATOR");

        _btn_SuspendAgent.setText("Suspend Agent");
        _btn_SuspendAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_SuspendAgentActionPerformed(evt);
            }
        });

        _btn_CreateAgent1.setText("Create Agent");
        _btn_CreateAgent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_CreateAgent1ActionPerformed(evt);
            }
        });

        _btn_ActivateAgent.setText("Activate Agent");
        _btn_ActivateAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_ActivateAgentActionPerformed(evt);
            }
        });

        _btn_ModifyAgent.setText("Modify Agent");
        _btn_ModifyAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_ModifyAgentActionPerformed(evt);
            }
        });

        _btn_More.setText("More");
        _btn_More.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_MoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(_lbl_Administrator))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(_btn_SuspendAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_btn_CreateAgent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_btn_More, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_btn_ModifyAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_btn_ActivateAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lbl_Administrator)
                .addGap(33, 33, 33)
                .addComponent(_btn_CreateAgent1)
                .addGap(18, 18, 18)
                .addComponent(_btn_SuspendAgent)
                .addGap(18, 18, 18)
                .addComponent(_btn_ActivateAgent)
                .addGap(18, 18, 18)
                .addComponent(_btn_ModifyAgent)
                .addGap(18, 18, 18)
                .addComponent(_btn_More)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btn_CreateAgent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_CreateAgent1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AttributesUser(this, 3, 0).setVisible(true);
    }//GEN-LAST:event__btn_CreateAgent1ActionPerformed

    private void _btn_SuspendAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_SuspendAgentActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new StateUser(this,1).setVisible(true);
    }//GEN-LAST:event__btn_SuspendAgentActionPerformed

    private void _btn_ActivateAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_ActivateAgentActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new StateUser(this,2).setVisible(true);
    }//GEN-LAST:event__btn_ActivateAgentActionPerformed

    private void _btn_ModifyAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_ModifyAgentActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new GetIdentification(this, 1).setVisible(true);
    }//GEN-LAST:event__btn_ModifyAgentActionPerformed

    private void _btn_MoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_MoreActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuAll(this).setVisible(true);
    }//GEN-LAST:event__btn_MoreActionPerformed

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
            java.util.logging.Logger.getLogger(AdministratorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministratorMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btn_ActivateAgent;
    private javax.swing.JButton _btn_CreateAgent1;
    private javax.swing.JButton _btn_ModifyAgent;
    private javax.swing.JButton _btn_More;
    private javax.swing.JButton _btn_SuspendAgent;
    private javax.swing.JLabel _lbl_Administrator;
    // End of variables declaration//GEN-END:variables
}
