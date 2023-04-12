package com.insert.many.data.dynamically;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public Connection getConnection() {
		Connection connection = null;
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");

			// establish connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
