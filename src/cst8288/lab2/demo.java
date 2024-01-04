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
import java.util.Scanner;

/**
 *
 * @author TaiNguyen
 * The `demo` class serves as a demonstration of interacting with recipient data in a database.
 * It provides methods to print, insert, update, and delete recipient records, while using the `modifyRecipients` class
 * to handle the business logic for these operations.
 */
public class demo {
    /**
     * Demonstrates various recipient data operations, including printing, inserting, updating, and deleting records.
     */
    public void test(){

        try {
            modifyRecipients logic = new modifyRecipients();
            List<RecipientsDTO> list = null;
            RecipientsDTO recipient = null;
            
            

            System.out.println("Printing recipients");
            list = logic.getAllRecipients();
            printRecipients(list);
            
            System.out.println("Printing one Recipient");
            recipient = logic.getRecipient(60);
            printRecipient(recipient);
            System.out.println("");
            
            System.out.println("Inserting one Recipient");
            recipient = new RecipientsDTO();
            recipient.setName("Tai123");
            recipient.setYear(1999);
            recipient.SetCity("Nghe An123");
            recipient.SetCategory("HandSome123");
            logic.addRecipients(recipient);
            list = logic.getAllRecipients();
            printRecipients(list);
            
            System.out.println("Updating last recipient");
            Integer updatePrimaryKey = list.get(list.size() -1).getAwardID();
            recipient = new RecipientsDTO();
            recipient.setAwardID(updatePrimaryKey);
            recipient.setName("MIFA");
            recipient.setYear(2004);
            recipient.SetCity("Buon Me Thuot");
            recipient.SetCategory("Beautiful");
            logic.updateRecipient(recipient);
            list = logic.getAllRecipients();
            printRecipients(list);
            
            System.out.println("Deleting last recipient");
            recipient = list.get(list.size() - 1);
            logic.deleteRecipient(recipient);
            list = logic.getAllRecipients();
            printRecipients(list);

            
            
            

        }
        catch (ValidationException e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    private static void printRecipient(RecipientsDTO recipient){
	    	String output = String.format("%s, %s, %s, %s, %s",
	    			recipient.getAwardID().toString(),
	    			recipient.getName(),
	    			recipient.getYear().toString(),
                                recipient.getCity(), 
                                recipient.getCategory());
	    	System.out.println(output);
	}
	
	private static void printRecipients(List<RecipientsDTO> recipients){
	    for(RecipientsDTO recipient : recipients){
	    	printRecipient(recipient);
	    }
	    System.out.println();
	}

}

