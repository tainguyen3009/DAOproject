/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.lab2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tai Nguyen
 * This class will responsible for managing and modifying recipient data in a database
 * It provides methods to add, update, delete, and retrieve recipient records.
 */


public class modifyRecipients {
    private static final int NAME_MAX_lENGTH = 30;
    private static final int YEAR_MAX_LENGTH = 4;
    private static final int CITY_MAX_LENGTH = 40;
    private static final int CATEGORY_MAX_LENGTH = 40;
    
    private RecipientsDAO recipientsDao = null;
    /**
     * construct a new object and initializes the associated DAO class
     */
    public modifyRecipients(){
        recipientsDao = new RecipientsDAOImpl();
    }
    /**
     * Retrieves a list of all recipient records.
     * @return A list of `RecipientsDTO` containing all recipient records.
     */
    public List<RecipientsDTO> getAllRecipients(){
        return recipientsDao.getAllReciepients();
    }
    /**
     * Retrieves a recipient record by its award ID
     * @param awardID the primary identifier of the recipient.
     * @return the object representing the recipient
     */
    public RecipientsDTO getRecipient (Integer awardID){
        return recipientsDao.getReciepientsByAwardID(awardID);
    }
    /**
     * Adds a new recipient to the database after cleaning and validating the recipient data.
     * @param recipient the DTO class object representing the recipient
     * @throws ValidationException 
     */
    public void addRecipients(RecipientsDTO recipient) throws ValidationException{
        cleanRecipient(recipient);
        validateRecipient(recipient);
        recipientsDao.addRecipient(recipient);
        
    }
    
//    /**
//     * 
//     * @param recipient
//     * @throws SQLException 
//     */
//     public void columnAttri(RecipientsDTO recipient) throws SQLException{
//        Connection con = null;
//        PreparedStatement pre = null;
//        ResultSet rs = null;
//        ResultSetMetaData metaData = null;
//        int i = 0;
//                System.out.printf("%-8s\t", metaData.getColumnName(i));
//                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
//                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
//                System.out.printf("\n");  }
    /**
     * Updates an existing recipient's information in the database after cleaning and validating the data.
     * @param recipient the DTO object representing the recipient.
     * @throws ValidationException if the recipient data is invalid
     */
    public void updateRecipient (RecipientsDTO recipient) throws ValidationException {
        cleanRecipient(recipient);
        validateRecipient(recipient);
        recipientsDao.updateRecipient(recipient);
    }
    /**
     * Deletes a recipient from the database.
     * @param recipient the DTO object representing the recipient.
     */
    public void deleteRecipient (RecipientsDTO recipient) {
        recipientsDao.deleteRepcipient(recipient);
    }
    /**
     * Clean the recipients from database
     * @param recipient the DTO object representing the recipient.
     */
    private void cleanRecipient(RecipientsDTO recipient){
        if (recipient.getName() != null){
            recipient.setName(recipient.getName().trim());
        }
        if (recipient.getYear() != null) {
            recipient.setYear(recipient.getYear());
        }
        if (recipient.getCity() != null) {
            recipient.SetCity(recipient.getCity().trim());
        }
        if (recipient.getCategory() != null){
            recipient.SetCategory(recipient.getCategory().trim());
        }
    }
    
    private void validateRecipient(RecipientsDTO recipient) throws ValidationException{
        validateString(recipient.getName(), "Name", NAME_MAX_lENGTH, true);
        validateInt(recipient.getYear(), "Year", YEAR_MAX_LENGTH, true);
        validateString(recipient.getCity(), "City", CITY_MAX_LENGTH, true);
        validateString(recipient.getCategory(), "Category", CATEGORY_MAX_LENGTH, true);
        
    }
    
    private void validateString( String value, String fieldName, int maxLength, boolean isNullAllowed)
            throws ValidationException{
        if (value == null && isNullAllowed){
    }
        else if (value == null && ! isNullAllowed){
            throw new ValidationException(String.format("%s cannot be null", fieldName));
        }
        else if (value.length() == 0){
            throw new ValidationException(String.format("%s cannot be empty or only whitespace", fieldName));
        }
        else if (value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
        }
    }
    private void validateInt(Integer year, String fieldName, int value, boolean par)
	    throws ValidationException{
		if(value <= 0){
			throw new ValidationException(String.format("%s cannot be a negative number", 
					fieldName));
		}
    }
}
