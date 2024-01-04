/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.lab2;
import cst8288.lab2.RecipientsDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

        
        /**
         * 
         * @author Tai Nguyen
         *  The `RecipientsDAOImpl` class is an implementation of the `RecipientsDAO` interface.
         * It provides methods to interact with the database, including retrieving recipient data,
         * adding, updating, and deleting recipient records.
         * This class uses JDBC to establish a connection to the database and perform operations on recipient data.
         */
public class RecipientsDAOImpl implements RecipientsDAO {

    /**
     *    
     *  Retrieves a list of all recipient records from the database.
     *  
     * @return  A list of `RecipientsDTO` containing all recipient records.
     */
    @Override
    public List<RecipientsDTO> getAllReciepients() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<RecipientsDTO> recipients = null;
        try{
            ConnectDB ds = new ConnectDB();
            con =  ds.createConnection();
            pre = con.prepareStatement(
            "SELECT AwardID, Name, Year, City, Category FROM Recipients ORDER BY AwardID");
            rs = pre.executeQuery();    
            recipients = new ArrayList<>();
            while(rs.next()){
                RecipientsDTO recipient = new RecipientsDTO();
                recipient.setAwardID(rs.getInt("AwardID"));
                recipient.setName(rs.getString("Name"));
                recipient.setYear(rs.getInt("Year"));
                recipient.SetCity(rs.getString("City"));
                recipient.SetCategory(rs.getString("Category"));
                recipients.add(recipient);

            }
        }
        catch(SQLException e){
        }
        finally{
            try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pre != null){ pre.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
                        if(con != null){ try {
                            con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RecipientsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
}
        }
        return recipients;
        
    }
/**
 * 
 * Retrieves a recipient record by its award ID from the database.
 * @param awardID The unique identifier of the recipient.
 * @return The `RecipientsDTO` object representing the recipient.
 */
    @Override
    public RecipientsDTO getReciepientsByAwardID(Integer awardID) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        RecipientsDTO recipient = null;
        try{
            ConnectDB ds = new ConnectDB();
            con =  ds.createConnection();
            pre = con.prepareStatement("SELECT AwardID, Name, Year, City, Category FROM Recipients WHERE AwardID = ?");
            pre.setInt(1, awardID.intValue());
            rs = pre.executeQuery();
            while(rs.next()){
                recipient = new RecipientsDTO();
                recipient.setAwardID(rs.getInt("AwardID"));
                recipient.setName(rs.getString("Name"));
                recipient.setYear(rs.getInt("Year"));
                recipient.SetCity(rs.getString("City"));
                recipient.SetCategory(rs.getString("Category"));
            }
        }
        catch (SQLException e){
        }
        finally{
            try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pre != null){ pre.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
                        if(con != null){ try {
                            con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RecipientsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
}
        }
        return recipient;
    }
/**
 * Adds a new recipient to the database after cleaning and validating the recipient data.
 * @param recipient recipient The `RecipientsDTO` object representing the recipient to be added.
 */
    @Override
    public void addRecipient(RecipientsDTO recipient) {
        Connection con = null;
        PreparedStatement pre = null;
        try{
            ConnectDB ds = new ConnectDB();
            con =  ds.createConnection();
            
            pre = con.prepareStatement(" INSERT INTO Recipients (Name, Year, City, Category) " + "VALUES(?, ?, ?, ?)");
            pre.setString(1, recipient.getName());
            pre.setInt(2, recipient.getYear());
            pre.setString(3, recipient.getCity());
            pre.setString(4, recipient.getCategory());
            pre.executeUpdate();
        }
    catch(SQLException e){
    }
    finally{
            try { if(pre != null){ pre.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());
            }
            if(con != null){ try {
                con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RecipientsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
}

        }
    }
        /**
         * Updates an existing recipient's information in the database after cleaning and validating the data.
         * @param recipient recipient The `RecipientsDTO` object representing the recipient to be updated
         */
            @Override
    public void updateRecipient(RecipientsDTO recipient) {
        Connection con = null;
	PreparedStatement pre = null;
			try{
				ConnectDB ds = new ConnectDB();
				con =  ds.createConnection();
				pre = con.prepareStatement(
						"UPDATE Authors SET Name = ?, Year = ?, City = ?, Category = ?  WHERE AwardID = ?");
				pre.setString(1, recipient.getName());
				pre.setInt(2, recipient.getYear());
                                pre.setString(3, recipient.getCity());
                                pre.setString(4, recipient.getCategory());
				pre.setInt(5, recipient.getAwardID());
				pre.executeUpdate();
			}
			catch(SQLException e){
			}
			finally{
				try{ if(pre != null){ pre.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
                                if(con != null){ try {
                                    con.close();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RecipientsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                        }
    }
    
		      
        
    
    
/**
 * Deletes a recipient from the database.
 * @param recipient The `RecipientsDTO` object representing the recipient to be deleted.
 */
    @Override
    public void deleteRepcipient(RecipientsDTO recipient) {
                Connection con = null;
		PreparedStatement pre = null;
		try{
			ConnectDB ds = new ConnectDB();
			con =  ds.createConnection();
			pre = con.prepareStatement(
					"DELETE FROM Recipients WHERE AwardID = ?");	
			pre.setInt(1, recipient.getAwardID());
			pre.executeUpdate();
		}
		catch(SQLException e){
		}
		finally{
			try{ if(pre != null){ pre.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
                        if(con != null){ try {
                            con.close();
                            } catch (SQLException ex) {
                                Logger.getLogger(RecipientsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
}
		}
    }
    
    /**
     * This method is not part of the interface and should be documented if it is part of the public API.
     * It appears to be a method for obtaining and printing column attributes, but its usage and purpose should be clarified
     * @param recipient The recipient object for which column attributes are to be printed.
     * @throws SQLException If there is an SQL exception while accessing column attributes.
     */
    public void columnAttri(RecipientsDTO recipient) throws SQLException{
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ResultSetMetaData metaData = null;
        int columnCount = 0;
        for (int i =1; i <= columnCount ; i++){
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");        
        
    }


    }

 
    
}
