package com.get.data;
//program to select all data from DB & print it on console
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllData {

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
			preparedStatement = connection.prepareStatement("select * from user");

			// step4-
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int ab = resultSet.getInt(1);
				System.out.println("ID>> " + ab);
				String str = resultSet.getString(2);
				System.out.println("firstName>> " + str);
				String str1 = resultSet.getString(3);
				System.out.println("lastName>> " + str1);
				String str2 = resultSet.getString(4);
				System.out.println("address>> " + str2);
				String str3 = resultSet.getString(5);
				System.out.println("city>> " + str3);
				String str4 = resultSet.getString(6);
				System.out.println("Salary>> " + str4);
			}

		} catch (Exception e) {

		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}

	}

}
