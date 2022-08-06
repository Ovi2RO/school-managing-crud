package school.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static final String dbURL = "jdbc:mysql://localhost:3306/school_schema";
	public static final String dbUserName = "root";
	public static final String dbPassword = "Fustitza22";	
	
	public static Connection getConnection() {
		
		System.out.println("Start getConnection");
		
		try{
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Open connection
			connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			
			if(connection != null) {
				System.out.println("Connected!");
				return connection;
			} else {
				System.out.println("Not connected!!!");
				return null;
			}
			
		}catch(Exception e){
			System.out.println("Exception in DB Connection" + e.getMessage());
			e.printStackTrace();
			return null;
		}		
	}
	
	
	public static Connection connection = getConnection();
	
	public static void main(String[] args) {
		System.out.println(DBConnection.connection); 
	}

}
