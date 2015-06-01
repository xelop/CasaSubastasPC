/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subastas.UI;

import javax.swing.JFrame;

/**
 *
 * @author Xelop
 */
public class MenuAll extends javax.swing.JFrame {

    /**
     * Creates new form MenuAll
     */
    private JFrame previuos;
    
    public MenuAll(JFrame pPreviuos) {
        initComponents();
        previuos=pPreviuos;
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
        _lbl_Other = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        _btn_ListAuctions = new javax.swing.JButton();
        _btn_BidsHistoryOfProduct = new javax.swing.JButton();
        _btn_AuctionsHistoryforUser = new javax.swing.JButton();
        _btn_WonBidsHistoryforUser = new javax.swing.JButton();
        _btn_Back = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _lbl_Other.setText("OTHER");

        _btn_ListAuctions.setText("List Auctions");
        _btn_ListAuctions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_ListAuctionsActionPerformed(evt);
            }
        });

        _btn_BidsHistoryOfProduct.setText("Bids History of Product");
        _btn_BidsHistoryOfProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_BidsHistoryOfProductActionPerformed(evt);
            }
        });

        _btn_AuctionsHistoryforUser.setText("Auctions History of User");
        _btn_AuctionsHistoryforUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_AuctionsHistoryforUserActionPerformed(evt);
            }
        });

        _btn_WonBidsHistoryforUser.setText("Won Bids History of User");
        _btn_WonBidsHistoryforUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_WonBidsHistoryforUserActionPerformed(evt);
            }
        });

        _btn_Back.setText("Back");
        _btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_btn_ListAuctions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_btn_BidsHistoryOfProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_btn_AuctionsHistoryforUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_btn_WonBidsHistoryforUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_btn_Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(_btn_ListAuctions)
                .addGap(18, 18, 18)
                .addComponent(_btn_BidsHistoryOfProduct)
                .addGap(18, 18, 18)
                .addComponent(_btn_AuctionsHistoryforUser)
                .addGap(18, 18, 18)
                .addComponent(_btn_WonBidsHistoryforUser)
                .addGap(18, 18, 18)
                .addComponent(_btn_Back)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(_lbl_Other))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(_lbl_Other)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_BackActionPerformed
        // TODO add your handling code here:
        this.previuos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event__btn_BackActionPerformed

    private void _btn_ListAuctionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_ListAuctionsActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new FindAuctions(previuos, 3).setVisible(true);
    }//GEN-LAST:event__btn_ListAuctionsActionPerformed

    private void _btn_BidsHistoryOfProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_BidsHistoryOfProductActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new GetIdentification(previuos, 3).setVisible(true);
    }//GEN-LAST:event__btn_BidsHistoryOfProductActionPerformed

    private void _btn_AuctionsHistoryforUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_AuctionsHistoryforUserActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new GetIdentification((previuos), 4).setVisible(true);
    }//GEN-LAST:event__btn_AuctionsHistoryforUserActionPerformed

    private void _btn_WonBidsHistoryforUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_WonBidsHistoryforUserActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new GetIdentification(previuos, 5).setVisible(true);
    }//GEN-LAST:event__btn_WonBidsHistoryforUserActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenuAll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btn_AuctionsHistoryforUser;
    private javax.swing.JButton _btn_Back;
    private javax.swing.JButton _btn_BidsHistoryOfProduct;
    private javax.swing.JButton _btn_ListAuctions;
    private javax.swing.JButton _btn_WonBidsHistoryforUser;
    private javax.swing.JLabel _lbl_Other;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}