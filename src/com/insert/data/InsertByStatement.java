package com.insert.data;

import java.sql.Connection;		
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// program for inser the student data using statement through JDBC
public class InsertByStatement {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			// step 1- insert into user
			String inser_Query = "insert into user(lastName,firstname,address,city,salary)values('pawar','ram','sangvi','pune',50000)";

			// step2- load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// step3- Establish connection
			// Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");
			// step6- create local variable of Connection connection to close it inside finally block
			// where yashdb1 is my scema name
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");

			// step4- create statement
			// Statement statement = connection.createStatement();
			// step7- create local variable of Statement statement to close it inside finally block
			statement = connection.createStatement();

			// step5- submit the sql statement
			statement.execute(inser_Query);

			System.out.println("Insertion Succesfull>>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}

	}

}
