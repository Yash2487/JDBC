package com.insert.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// program for inser the data using prepared statement
public class InserByPreparedStatement {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// step1- loading driver class
			Class.forName("com.mysql.jdbc.Driver");

			// step2- Establish connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");

			// step3- create prepared statement
			preparedStatement = connection
					.prepareStatement("insert into employee(fName,lName,address,salary,age)values(?,?,?,?,?)");
			
			// step4- call setString() method by using object of preparedStatement
			preparedStatement.setString(1, "drishti");// driver will convert this value into SQL varchar value
			preparedStatement.setString(2, "ghune");
			preparedStatement.setString(3, "dharavi");
			preparedStatement.setString(4, "85680");
			preparedStatement.setInt(5, 54);// driver will convert this value into SQL varchar value

			preparedStatement.executeUpdate();

			System.out.println("Record is inserted>>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();

		}

	}

}
