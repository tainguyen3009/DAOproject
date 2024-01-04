package cst8288.lab2;
import cst8288.lab2.ConnectDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import cst8288.lab2.RecipientsDTO;
/**
 * 
 * @author Tai Nguyen
 * Student number: 041086103
 * Main class to run the program 
 */
public class Main{

    private static RecipientsDTO RecipientsDTO;
    /**
     * 
     * @param args main method
     */
    public static void main(String[] args) throws SQLException {
      
        (new demo()).test();
        (new RecipientsDAOImpl()).columnAttri(RecipientsDTO);
    }
}