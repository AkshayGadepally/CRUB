package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static final String URL = "jdbc:postgresql://localhost:5432/studentdb";
	public static final String USER = "postgres";
	public static final String PASSWORD = "Dream";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
}
