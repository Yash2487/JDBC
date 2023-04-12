package com.update.data;
// update only one data of DB by using connection
import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOne {

	public static void main(String[] args) throws SQLException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			// step1- loading Driver class
			Class.forName("com.mysql.jdbc.Driver");

			// step2- Establishing Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");

			// step3- create prepared statement
			preparedStatement = connection.prepareStatement("update user set address=? where id=?");

			// step4- call setString() by using object of preparedStatement
			preparedStatement.setString(1, "goa");
			preparedStatement.setInt(2, 3);

			preparedStatement.executeUpdate();

			System.out.println("Record Is updated>>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}

	}

}
