package com.insert.single.data.dynamically;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public Connection getConnectionDetails() throws SQLException {
		Connection connection = null;
		try {
			// step1- load driver class
			Class.forName("com.mysql.jdbc.Driver");
			// step 2- establish connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
