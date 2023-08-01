package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlConnection {
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_QuitandaW", "root", "Leticia2205!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if(connection != null) connection.close();
		} catch (Exception e2) {
			e2.getStackTrace();
		}
	}
	
	public static void closePreparedStatement(PreparedStatement p_estatement) {
		try {
			if(p_estatement != null) p_estatement.close();
		} catch (Exception e2) {
			e2.getStackTrace();
		}
	}
}
