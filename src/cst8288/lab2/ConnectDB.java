
package cst8288.lab2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.Statement;

/**
 * 
 * @author Tai Nguyen
 * Student number: 041086103
 * This class will use jdbc to connect with database
 */
public class ConnectDB {
	private Connection connection = null;
	/**
         * Constructs a new ConnectDB object
         */
	public ConnectDB(){}
/*
 * Only use one connection for this application, prevent memory leaks.
 */
        /**
         * Create a database connection based on the properties specified
         * in the database.properties file.
         * @return the database connection established
         * @throws SQLException if an error occurs while creating the connection
         */
	public Connection createConnection() throws SQLException{
            // added use of Properties and try-with-resources - kriger
            Properties props = new Properties();

		try (InputStream in = Files.newInputStream(Paths.get("src/data/database.properties"));) {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch()

	    String url = props.getProperty("jdbc.url");
	    String username = props.getProperty("jdbc.username");
	    String password = props.getProperty("jdbc.password");
            
//            try(
//                Connection connection = DriverManager.getConnection(url, username, password);
//                Statement statement = connection.createStatement();


//                ResultSet resultSet = statement.executeQuery("SELECT * FROM Recipients ORDER BY AwardID");
//                    ){
//                ResultSetMetaData metaData = resultSet.getMetaData();
//                int numberOfColumns = metaData.getColumnCount();
//                System.out.println("Recipients Database:\n");
//                
//                
//                for (int i = 1; i <= numberOfColumns; i++){
//                    System.out.printf("%-25s\t", metaData.getColumnName(i));
//                }
//                System.out.println();
//                
//                while (resultSet.next()){
//                    for (int i = 1; i <= numberOfColumns; i++){
//                        System.out.printf("%-25s\t", resultSet.getObject(i));
//                    }
//                    System.out.println();
//                }
//            System.out.println("\nRecipients Table - Column Attributs:");
//
//            for (int i = 1; i <= numberOfColumns; i++) {
//                System.out.printf("%-8s\t", metaData.getColumnName(i));
//                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
//                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
//                System.out.printf("\n");
//            }
//                System.out.println();
//            }
//            
		try {
			if(connection != null){
				System.out.println("Cannot create new connection, one exists already");
			}
			else{
				connection = DriverManager.getConnection(url, username, password);
			}
                } 
		catch(SQLException ex){
                   ex.printStackTrace();
                        }
		return connection;
            }
        }

  
