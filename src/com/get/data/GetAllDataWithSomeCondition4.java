package com.get.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllDataWithSomeCondition4 {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// jdbc:mysql://localhost:3306/?user=root
		try {
			// step1- load driver
			Class.forName("com.mysql.jdbc.Driver");

			// step2- Establish connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");

			// step3- prepare statement
			preparedStatement = connection.prepareStatement("select * from user where salary>=50000");

			// step4- call method
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("ID>> " + resultSet.getString("id"));
				System.out.println("First Name>> " + resultSet.getString("firstName"));
				System.out.println("Last Name>> " + resultSet.getString("lastName"));
				System.out.println("Address>> " + resultSet.getString("address"));
				System.out.println("City>> " + resultSet.getString("salary"));

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
