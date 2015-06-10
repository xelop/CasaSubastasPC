/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subastas.UI;

import java.awt.Component;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import subastas.Logic.DataBaseConnection;
import subastas.Logic.DefaultTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Xelop
 */
public class ListAuctions extends javax.swing.JFrame {

    /**
     * Creates new form ListSubastas
     */
    DataBaseConnection _Connection;
    JFrame _Previous;
    String[] _ItemNames;
    Integer[] _AuctionId;
    String[] _ItemDescription;
    int _Action;
    
    public ListAuctions(JFrame pPrevious, int pAction, String pCategory, String pSubCategory, int pId){ // 1:Inactive, 2:Bids
                                                                                                       //3:list, 4:bids per auction
                                                                                                       // 5: auctions user
                                                                                                       //6: won 7:bought 8:sold 9:midnight 10:participants
        initComponents();
        _Connection = DataBaseConnection.getInstance();
        _Action = pAction;
        if(_Action==1){
            ResultSet rs =_Connection.listInactiveAuctions();
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
        }else if(_Action == 2){
            _lbl_Action.setText("AUCTIONS");
            jButton1.setText("Bid");
            ResultSet rs =_Connection.listSubastasCategory(pCategory, pSubCategory);
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
            
        }else if(_Action == 3){
            _lbl_Action.setText("AUCTIONS");
            jButton1.setVisible(false);
            
            ResultSet rs =_Connection.listSubastasCategory(pCategory, pSubCategory);
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
        }else if(_Action == 4){
            _lbl_Action.setText("BIDS");
            jButton1.setVisible(false);
            
            ResultSet rs =_Connection.bidsPerAuction(pId);
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
            
        }else if(_Action == 5){
            _lbl_Action.setText("AUCTIONS");
            jButton1.setVisible(false);
            
            ResultSet rs =_Connection.auctionsPerUser(pCategory);
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
            
        }else if(_Action == 6){
            _lbl_Action.setText("WON AUCTIONS");
            jButton1.setVisible(false);
            
            ResultSet rs =_Connection.wonAuctionsPerUser(pCategory);
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
        }else if(_Action == 7){
            _lbl_Action.setText("BOUGHT AUCTIONS");
            jButton1.setText("Add Comment");
            
            ResultSet rs =_Connection.listBought();
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
        }else if(_Action == 8){
            _lbl_Action.setText("SOLD AUCTIONS");
            jButton1.setText("Add Comment");
            
            ResultSet rs = _Connection.listSold();
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
        }else if(_Action == 9){
            _lbl_Action.setText("AUCTIONS ENDING AT MIDNIGHT");
            jButton1.setVisible(false);
            
            ResultSet rs = _Connection.midNightAuctions();
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
        }else if(_Action == 10){
            _lbl_Action.setText("ALL PARTICIPANTS");
            jButton1.setVisible(false);
            
            ResultSet rs = _Connection.listParticipants();
            
            if(rs != null){
                _lst_Auctions.setModel(DbUtils.resultSetToTableModel(rs));
                resizeColumnWidth(_lst_Auctions);
            }
            
        }
        _Previous = pPrevious;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _lbl_Action = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        _lst_Auctions = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _lbl_Action.setText("RESTART AUCTIONS");

        jButton1.setText("Restart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        _lst_Auctions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        _lst_Auctions.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(_lst_Auctions);

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(_lbl_Action)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lbl_Action)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(344, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRowIndex = _lst_Auctions.getSelectedRow();
            
        if(_Action == 1){
            int index = (int) _lst_Auctions.getModel().getValueAt(selectedRowIndex, 0);
            new CreateAuction(_Previous, 2, index).setVisible(true);
            this.dispose();
        }else if(_Action == 2){
            int index = (int) _lst_Auctions.getModel().getValueAt(selectedRowIndex, 0);
            new MakeBid(_Previous, index).setVisible(true);
            this.dispose();
        }else if( _Action == 7){
            int index = (int) _lst_Auctions.getModel().getValueAt(selectedRowIndex, 0);
            new Comments(_Previous, 1, index).setVisible(true);
            this.dispose();
        }else if (_Action == 8){
            int index = (int) _lst_Auctions.getModel().getValueAt(selectedRowIndex, 0);
            new Comments(_Previous, 2, index).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this._Previous.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 50; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width, width);
        }
        columnModel.getColumn(column).setPreferredWidth(width);
    }
    }
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
            java.util.logging.Logger.getLogger(ListAuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListAuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListAuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListAuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ListSubastas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _lbl_Action;
    private javax.swing.JTable _lst_Auctions;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
