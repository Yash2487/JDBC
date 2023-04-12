package com.insert.single.data.dynamically;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInput {

	private void insertStudentData(String name, String add, String city, int age, String mobNum) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			connection = connectionTest.getConnectionDetails();
			// step-4 create prepared statemnt
			preparedStatement = connection
					.prepareStatement("insert into yash(name,address,city,age,mobilenumber)values(?,?,?,?,?)");

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, add);
			preparedStatement.setString(3, city);
			preparedStatement.setInt(4, age);
			preparedStatement.setString(5, mobNum);

			int a = preparedStatement.executeUpdate();
			System.out.println("Record Inserted>>" + a);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		System.out.println("Enter The Name>>");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.println("Enter The Address>>");
		String add = scanner.next();
		System.out.println("Enter The City>>");
		String city = scanner.next();
		System.out.println("Enter The Age>>");
		int age = scanner.nextInt();
		System.out.println("Enter The Mobile Number>>");
		String mobNum = scanner.next();

		UserInput userInput = new UserInput();
		userInput.insertStudentData(name, add, city, age, mobNum);

	}

}
