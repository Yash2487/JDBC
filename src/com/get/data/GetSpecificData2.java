package com.get.data;

//program to get specific data from DB & print it on console
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSpecificData2 {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// step1- load driver class
			Class.forName("com.mysql.jdbc.Driver");

			// step2- Establishing connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");

			// step3- create prepared statement
			preparedStatement = connection.prepareStatement("select firstName,lastName,salary from user order by firstName,lastName,salary desc");

			// step4- fetch data from DB & store it inside one variable
			resultSet = preparedStatement.executeQuery();
			/*
			 * now resultSet is having firstName,lastName,address from DB table user
			 */

			while (resultSet.next()) {

				String str = resultSet.getString(1);
				System.out.println("firstName>> " + str);
				String str1 = resultSet.getString(2);
				System.out.println("lastName>> " + str1);
				String str2 = resultSet.getString(3);
				System.out.println("Salary>> " + str2);

			}

		} catch (Exception e) {

		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}

	}

}
