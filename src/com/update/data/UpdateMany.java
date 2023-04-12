package com.update.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMany {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// step1- loading Driver class
			Class.forName("com.mysql.jdbc.Driver");

			// step2- Establishing connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");

			// step3- create prepared statement
			preparedStatement = connection
					.prepareStatement("update user set firstName=?,lastname=?,address=? where id=?");

			// step4- call setString() by using preparedStatement
			preparedStatement.setString(1, "pratik");
			preparedStatement.setString(2, "potphode");
			preparedStatement.setString(3, "ahmdabad");
			preparedStatement.setInt(4, 5);

			// step5- call executeUpdate
			preparedStatement.executeUpdate();
			
			System.out.println("Record is update>>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}

	}

}
