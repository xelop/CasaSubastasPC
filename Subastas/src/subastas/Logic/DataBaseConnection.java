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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
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
        
            try {
           
                String URL = "jdbc:sqlserver://localhost;user="+pUsername+";password="+pPassword+";database=SUBASTAS";
                Connection = DriverManager.getConnection(URL);
                // Imprimir datos de conexión
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
    private void sendError(String pMessage){
        JOptionPane.showMessageDialog(null, pMessage);
    }
    public boolean verifyPassword(String pAlias, String pPassword){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetPassForUsuario(?,?)}");
            StoredProcCall.setString(1, pAlias);
            StoredProcCall.registerOutParameter(2, Types.VARCHAR);
            StoredProcCall.execute();
            String password = StoredProcCall.getString(2);
            System.out.println(password);
            System.out.println(HashTextTest.sha2(pPassword));
            if(password.equals(HashTextTest.sha2(pPassword))){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return false;
        }
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
            
            sendError(ex.getMessage());
            return 0;
        }
    }
    
    public boolean createAgent(int pIdentification, String pNickName, String pPassword, 
            String pName, String pLastName1, String pLastName2, String pAddress){
        try {
            StoredProcCall= Connection.prepareCall("{? = call USP_CreateAgente(?,?,?,?,?,?,?)}");
            
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.setString(3,pNickName);
            StoredProcCall.setString(4,pPassword);
            StoredProcCall.setString(5, pName);
            StoredProcCall.setString(6, pLastName1);
            StoredProcCall.setString(7, pLastName2);
            StoredProcCall.setString(8, pAddress);
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
    
    public void insertTelephones(int pId, ArrayList<String> pTelephones){
        for(int counter = 0; counter < pTelephones.size(); counter++){
            try {
                StoredProcCall = Connection.prepareCall("{call USP_CreateTelefonoUsuario(?,?)}");
                StoredProcCall.setInt(1,pId);
                StoredProcCall.setString(2, pTelephones.get(counter));
                StoredProcCall.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            String pName, String pLastName1, String pLastName2, String pAddress){
        try {
            StoredProcCall= Connection.prepareCall("{call USP_UpdateAgente(?,?,?,?,?,?,?)}");
            
            StoredProcCall.setInt(1,pIdentification);
            StoredProcCall.setString(2,pNickName);
            StoredProcCall.setString(3,pPassword);
            StoredProcCall.setString(4, pName);
            StoredProcCall.setString(5, pLastName1);
            StoredProcCall.setString(6, pLastName2);
            StoredProcCall.setString(7, pAddress);
            StoredProcCall.execute();
            return false;
            
            } catch (SQLException ex) {
            sendError(ex.getMessage() +" "+ ex.getErrorCode());
            return true;
        }
    }
    
    public boolean createParticipant(int pIdentification, String pNickName, String pPassword, 
            String pName, String pLastName1, String pLastName2, String pCreditNumber, String pEmail, String pAddress){
        try {
            StoredProcCall= Connection.prepareCall("{? = call USP_CreateParticipante(?,?,?,?,?,?,?,?,?)}");
            
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            
            StoredProcCall.setInt(2,pIdentification);
            StoredProcCall.setString(3,pNickName);
            StoredProcCall.setString(4,pPassword);
            StoredProcCall.setString(5, pName);
            StoredProcCall.setString(6, pLastName1);
            StoredProcCall.setString(7, pLastName2);
            StoredProcCall.setString(8, pCreditNumber);
            StoredProcCall.setString(9, pEmail);
            StoredProcCall.setString(10, pAddress);
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
            String pName, String pLastName1, String pLastName2, String pEmail, String pAddress){
        try {
            StoredProcCall= Connection.prepareCall("{call USP_UpdateParticipante(?,?,?,?,?,?,?,?)}");
            
            StoredProcCall.setInt(1,pIdentification);
            StoredProcCall.setString(2,pNickName);
            StoredProcCall.setString(3,pPassword);
            StoredProcCall.setString(4, pName);
            StoredProcCall.setString(5, pLastName1);
            StoredProcCall.setString(6, pLastName2);
            StoredProcCall.setString(7, pEmail);
            StoredProcCall.setString(8, pAddress);
            StoredProcCall.execute();
            StoredProcCall.close(); //buena practica!!!!!!!!!!!!
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
        }catch (SQLException ex) {
            
            sendError(ex.getMessage());
            return true;
        }
    }
    
    public boolean createSubasta(Auction pAuction) throws FileNotFoundException{
        try{
            StoredProcCall = Connection.prepareCall("{?=call USP_CreateSubasta(?,?,?,?,?,?,?,?,?)}");
            StoredProcCall.registerOutParameter(1, Types.INTEGER);
            StoredProcCall.setString(2, pAuction.getItemName());
            StoredProcCall.setString(3, pAuction.getDescription());
            FileInputStream stream;
            
            if(pAuction.getImage()!=null){
                stream = new FileInputStream(pAuction.getImage());
                StoredProcCall.setBinaryStream(4, stream, (int) pAuction.getImage().length());   
            }else{
                stream = null;
                StoredProcCall.setBinaryStream(4, stream, 0);   
            }
            StoredProcCall.setString(5, pAuction.getSubCategory());
            StoredProcCall.setString(6, pAuction.getCategory());
            StoredProcCall.setString(7, pAuction.getDeliverDetails());
            StoredProcCall.setString(8, pAuction.getLastDate());
            StoredProcCall.setString(9, this._UserAlias);
            StoredProcCall.setInt(10, pAuction.getPrice());
            StoredProcCall.execute();
            System.out.println(StoredProcCall.getInt(1));
            return false;
        }catch (SQLException ex){
            sendError(ex.getMessage());
            return true;
        }
    }
    
    public ResultSet listInactiveAuctions(){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetSubastasReiniciables(?)}");
            StoredProcCall.setString(1, this._UserAlias);
            ResultSet rs = StoredProcCall.executeQuery();
            return rs;
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    
    public Integer[] valuesRestartAuction(int pId){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetSubasta(?,?,?)}");
            StoredProcCall.setInt(1, pId);
            StoredProcCall.registerOutParameter(2,Types.INTEGER);
            StoredProcCall.registerOutParameter(3, Types.INTEGER);
            StoredProcCall.execute();
            return new Integer[]{StoredProcCall.getInt(2), StoredProcCall.getInt(3)};
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
            //Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void restartAuction(int pId){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_RestartSubasta(?)}");
            StoredProcCall.setInt(1, pId);
            StoredProcCall.execute();
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            
        }
    }
    
    public ResultSet listSubastasCategory(String pCategory, String pSubCategory){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetSubastasActivasCategoria(?,?)}");
            StoredProcCall.setString(1, pCategory);
            StoredProcCall.setString(2, pSubCategory);
            ResultSet rs = StoredProcCall.executeQuery();
            return rs;
            
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    
    public boolean makeBid(int pIdAuction, int pMoney){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_CreatePuja(?,?,?)}");
            StoredProcCall.setString(1, this._UserAlias);
            StoredProcCall.setInt(2, pMoney);
            StoredProcCall.setInt(3, pIdAuction);
            StoredProcCall.execute();
            return false;
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return true;
        }
            
    }
    
    public ResultSet bidsPerAuction(int pIdAuction){
        
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetPujasForSubasta(?)}");
            StoredProcCall.setInt(1, pIdAuction);
            ResultSet rs = StoredProcCall.executeQuery();
            return rs;
            
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    
    public ResultSet auctionsPerUser(String pAlias){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetSubastasForVendedor(?)}");
            StoredProcCall.setString(1, pAlias);
            ResultSet rs = StoredProcCall.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    
    public ResultSet wonAuctionsPerUser(String pAlias){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetPujasGanadorasForUsuario(?)}");
            StoredProcCall.setString(1, pAlias);
            ResultSet rs = StoredProcCall.executeQuery();
            return rs;
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    
    public ResultSet listBought(){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetComprasForComprador(?)}");
            StoredProcCall.setInt(1, _UserIdentification);
            ResultSet rs = StoredProcCall.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    
    public ResultSet listSold(){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetComprasForComprador(?)}");
            StoredProcCall.setInt(1, _UserIdentification);
            ResultSet rs = StoredProcCall.executeQuery();
            
            return rs;
           } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    
    public void addCommentSold(int pId, String pComment){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_AddCommentVendedor(?,?)}");
            StoredProcCall.setInt(1, pId);
            StoredProcCall.setString(2, pComment);
            StoredProcCall.execute();
        } catch (SQLException ex) {
            sendError(ex.getMessage());
        }
    }
    
    public void addCommentBought(int pId, String pComment){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_AddCommentComprador(?,?)}");
            StoredProcCall.setInt(1, pId);
            StoredProcCall.setString(2, pComment);
            StoredProcCall.execute();
        } catch (SQLException ex) {
            sendError(ex.getMessage());
        }
    }
    
    public ResultSet midNightAuctions(){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_GetTodaySubastas()}");
            ResultSet rs = StoredProcCall.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    
    public ResultSet listParticipants(){
        try {
            StoredProcCall = Connection.prepareCall("{call USP_ListParticipants()}");
            ResultSet rs = StoredProcCall.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            sendError(ex.getMessage());
            return null;
        }
    }
    public Boolean isSuspendido(){
        try{
            StoredProcCall = Connection.prepareCall("{call USP_GetSuspendido(?,?)}");
            StoredProcCall.setString(1, _UserAlias);
            StoredProcCall.registerOutParameter(2,Types.BIT);
            StoredProcCall.execute();
            Byte x=StoredProcCall.getByte(2);
            if(x.intValue()==1){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            sendError(ex.getMessage());
            return true;
        }
    }
    public Boolean modifyValues(Integer pComission, Integer pDecrease){
        try{
            StoredProcCall = Connection.prepareCall("{call USP_UpdateCasaSubasta(?,?)}");
            if(pComission == null)
                StoredProcCall.setNull(1,Types.INTEGER );
            else
                StoredProcCall.setInt(1, pComission);
            if(pDecrease == null)
                StoredProcCall.setNull(2,Types.INTEGER );
            else
                StoredProcCall.setInt(2, pDecrease);
            
            StoredProcCall.execute();
            return false;
        }catch (SQLException ex){
            sendError(ex.getMessage());
            return true;
        }
    }
    
    
    
    public void setcon(){
        Connection = null;
    }
	
}
