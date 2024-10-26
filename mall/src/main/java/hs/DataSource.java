package hs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "mall";
	private static final String password = "mall";
	
	public static Connection getDataSource() {
		Connection connection = null;
		
		try {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
