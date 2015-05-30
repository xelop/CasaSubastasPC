/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subastas;

import subastas.Logic.DataBaseConnection;
import subastas.UI.*;

/**
 *
 * @author Xelop
 */
public class Subastas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //DataBaseConnection x= DataBaseConnection.getInstance();
        //x.setConnection(null, null);
        new LogIn().setVisible(true);
    }
    
}
