package com.get.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllDataWithSomeCondition2 {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// jdbc:mysql://localhost:3306/schema_name-> JDBC connection string
			// step1- load driver class
			Class.forName("com.mysql.jdbc.Driver");

			// step2- establish the connection call getConnection() method with three
			// arguments

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");

			// step3- create prepared statement by using object of connection
			preparedStatement = connection.prepareStatement("select * from user where salary>=50000 and salary<=60000");

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("ID>> " + resultSet.getInt(1));
				System.out.println("First Name>> " + resultSet.getString(2));
				System.out.println("Last Name>> " + resultSet.getString(3));
				System.out.println("Address>> " + resultSet.getString(4));
				System.out.println("City>> " + resultSet.getString(5));
				System.out.println("Salary>> " + resultSet.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}

}
