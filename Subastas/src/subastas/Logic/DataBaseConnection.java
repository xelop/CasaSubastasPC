/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subastas.Logic;
//Asda
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Xelop
 */
public class DataBaseConnection {
    
    private static DataBaseConnection Instance;
    private String DataBaseURL;//= "jdbc:sqlserver://localhost;integratedSecurity=true;database=SUBASTAS";
    private static Connection Connection;
    private CallableStatement StoredProcCall;
    private boolean ErrorOcurred=false;
    private int _UserIdentification = 0;
    private String _UserAlias = "";
    
    private DataBaseConnection(){
        
    }
    
    public static DataBaseConnection getInstance(){
        if(Instance==null)
            Instance=new DataBaseConnection();
        return Instance;   
    }
    public boolean setConnection(String pUsername, String pPassword){
        if(Connection == null){
            try {
                //String URL = "jdbc:sqlserver://localhost;user="+pUsername+";password="+pPassword+";database=SUBASTAS";
                Connection = DriverManager.getConnection("jdbc:sqlserver://localhost;integratedSecurity=true;database=SUBASTAS");
                // Imprimir datos de conexión
                System.out.println("Connection Succesful:");
                DatabaseMetaData dm = (DatabaseMetaData) Connection.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                return false;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                sendError("Your username or password are incorrect");
                return true;

            }
        }
        return false;
    }
    private void sendError(String pMessage){
        JOptionPane.showMessageDialog(null, pMessage);
    }
    public int getUser(String pAlias){
        try{ 
            StoredProcCall = Connection.prepareCall("{? = call USP_GetUsuarioAlias(?,?)}");
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            StoredProcCall.setString(2,pAlias);
            StoredProcCall.registerOutParameter(3, Types.INTEGER);
            StoredProcCall.execute();
            int type = StoredProcCall.getInt(1);
            _UserIdentification = StoredProcCall.getInt(3);
            _UserAlias = pAlias;
            return type;
        } catch (SQLException ex) {
            
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return 0;
        }
    }
    public boolean createAgent(int pIdentification, String pNickName, String pPassword, 
            String pName, String pLastName1, String pLastName2){
        try {
            StoredProcCall= Connection.prepareCall("{? = call USP_CreateAgente(?,?,?,?,?,?)}");
            
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.setString(3,pNickName);
            StoredProcCall.setString(4,pPassword);
            StoredProcCall.setString(5, pName);
            StoredProcCall.setString(6, pLastName1);
            StoredProcCall.setString(7, pLastName2);
            StoredProcCall.execute();
            int error = StoredProcCall.getInt(1);
            System.out.println(error);
            if(error == -4){
                sendError("An user with that Identification or Alias already exists");
                return true;
            }
            return false;
            
            } catch (SQLException ex) {
            
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    public boolean suspendAgent(int pIdentification){
        try {
            StoredProcCall = Connection.prepareCall("{? = call USP_SuspendAgente(?)}");
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.execute();
            int error = StoredProcCall.getInt(1);
            if(error == -1){
                sendError("The provided ID doesnt exists");
                return true;
            }
            return false;
        } catch (SQLException ex) {
            
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    public boolean activateAgent(int pIdentification){
        try{
            StoredProcCall = Connection.prepareCall("{? = call USP_ReactivateAgente(?)}");
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.execute();
            int error = StoredProcCall.getInt(1);
            if(error == -1){
                sendError("The provided ID doesnt exists");
                return true;
            }
            return false;
        } catch (SQLException ex) {
            
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    public int getAgent(int pIdentification){
        try{ 
            StoredProcCall = Connection.prepareCall("{? = call USP_GetUsuario(?)}");
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.execute();
            int type = StoredProcCall.getInt(1);
            if(type == -5){
                return pIdentification;
            }
            return -1;
        } catch (SQLException ex) {
            
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return -1;
        }
    }
    public boolean modifyAgent(int pIdentification, String pNickName, String pPassword, 
            String pName, String pLastName1, String pLastName2){
        try {
            StoredProcCall= Connection.prepareCall("{call USP_UpdateAgente(?,?,?,?,?,?)}");
            
            StoredProcCall.setInt(1,pIdentification);
            StoredProcCall.setString(2,pNickName);
            StoredProcCall.setString(3,pPassword);
            StoredProcCall.setString(4, pName);
            StoredProcCall.setString(5, pLastName1);
            StoredProcCall.setString(6, pLastName2);
            StoredProcCall.execute();
            return false;
            
            } catch (SQLException ex) {
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    public boolean createParticipant(int pIdentification, String pNickName, String pPassword, 
            String pName, String pLastName1, String pLastName2, String pCreditNumber){
        try {
            StoredProcCall= Connection.prepareCall("{? = call USP_CreateParticipante(?,?,?,?,?,?,?)}");
            
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.setString(3,pNickName);
            StoredProcCall.setString(4,pPassword);
            StoredProcCall.setString(5, pName);
            StoredProcCall.setString(6, pLastName1);
            StoredProcCall.setString(7, pLastName2);
            StoredProcCall.setString(8, pCreditNumber);
            StoredProcCall.execute();
            int error = StoredProcCall.getInt(1);
            if(error == -4){
                sendError("An user with that Identification or Alias already exists");
                return true;
            }
            return false;
            
            } catch (SQLException ex) {
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    public boolean updateCreditCard(int pIdentification, String pCard){
        try {
            StoredProcCall= Connection.prepareCall("{? = call USP_UpdateTarjetaParticipante(?,?)}");
            
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.setString(3,pCard);
            StoredProcCall.execute();
            int error = StoredProcCall.getInt(1);
            if(error == -1){
                sendError("An user with that Identification or Alias  doesnt already exists");
                return true;
            }
            return false;
            
            } catch (SQLException ex) {
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    public int getParticipant(int pIdentification){
        try{ 
            StoredProcCall = Connection.prepareCall("{? = call USP_GetUsuario(?)}");
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.execute();
            int type = StoredProcCall.getInt(1);
            if(type == -7){
                return pIdentification;
            }
            return -1;
        } catch (SQLException ex) {
            
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return -1;
        }
    }
    public boolean modifyParticipant(int pIdentification, String pNickName, String pPassword, 
            String pName, String pLastName1, String pLastName2){
        try {
            StoredProcCall= Connection.prepareCall("{call USP_UpdateParticipante(?,?,?,?,?,?)}");
            
            StoredProcCall.setInt(1,pIdentification);
            StoredProcCall.setString(2,pNickName);
            StoredProcCall.setString(3,pPassword);
            StoredProcCall.setString(4, pName);
            StoredProcCall.setString(5, pLastName1);
            StoredProcCall.setString(6, pLastName2);
            StoredProcCall.execute();
            return false;
            
            } catch (SQLException ex) {
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    public boolean suspendParticipant(int pIdentification){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_SuspendParticipante(?)}");
            StoredProcCall.setInt(1,pIdentification);
            StoredProcCall.execute();
            return false;
        } catch (SQLException ex) {
            
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    public boolean activateParticipant(int pIdentification){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_ReactivateParticipante(?)}");
            StoredProcCall.setInt(1,pIdentification);
            StoredProcCall.execute();
            return false;
        } catch (SQLException ex) {
            
            sendError(ex.getMessage());
            return true;
        }
    }
    public boolean createSubasta(Auction pAuction) throws FileNotFoundException{
        try{
            StoredProcCall = Connection.prepareCall("{call USP_CreateSubasta(?,?,?,?,?,?,?,?,?)}");
            StoredProcCall.setString(1, pAuction.getItemName());
            StoredProcCall.setString(2, pAuction.getDescription());
            File file = new File(pAuction.getImage());
            FileInputStream stream = new FileInputStream(file);
            StoredProcCall.setBinaryStream(3, stream, (int) file.length());
            StoredProcCall.setString(4, pAuction.getSubCategory());
            StoredProcCall.setString(5, pAuction.getCategory());
            StoredProcCall.setString(6, pAuction.getDeliverDetails());
            StoredProcCall.setString(7, pAuction.getLastDate());
            StoredProcCall.setString(8, this._UserAlias);
            StoredProcCall.setInt(9, pAuction.getPrice());
            StoredProcCall.execute();
            return false;
        }catch (SQLException ex){
            sendError(ex.getMessage());
            return true;
        }
    }
	
}
