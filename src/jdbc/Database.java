package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	

	
	public static final String CONNECTION_STRING ="jdbc:mysql://localhost:3306/sys";
    

	public static final String uname="root";
	public static final String pswd="root";

    private static Connection conn;
    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING,uname,pswd);
        System.out.println("Database connected");
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            
        }
		return conn;
    }

}