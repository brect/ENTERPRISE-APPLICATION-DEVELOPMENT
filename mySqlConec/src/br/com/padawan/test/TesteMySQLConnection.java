package br.com.padawan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteMySQLConnection {

	static String username = "jovemjedi";
	static String password = "jm090419*";

	static String dbUrl = "jdbc:mysql://mysql669.umbler.com:41890/padawan";

	
	public static void main(String[] args) throws SQLException {

		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbUrl, username, password);
			
			System.out.println("Connection sucess");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			connection.close();
		}

	}

}
