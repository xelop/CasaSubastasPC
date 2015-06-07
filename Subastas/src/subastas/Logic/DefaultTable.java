/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subastas.Logic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author Xelop
 */
public interface DefaultTable {
    public static void FillTable(JTable table, ResultSet rs){
        try {
            while(table.getRowCount() > 0)
            {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefaultTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DefaultTableModel fill(ResultSet rs){
        try {
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            while (rs.next())
            {
                Object [] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; ++i)
                {
                    rowData[i] = rs.getObject(i+1);
                }
                defaultTableModel.addRow(rowData);
            }
            System.out.println("yes?");
            return defaultTableModel;
        } catch (SQLException ex) {
            Logger.getLogger(DefaultTable.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
