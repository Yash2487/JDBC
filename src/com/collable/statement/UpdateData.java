package com.collable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateData {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		CallableStatement callableStatement=null;
		try {
			// step1- loading driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			// step2- establish connection
			 connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1", "root", "Yash_Mate@#2487");
			
			// step3- create collable statement
			 callableStatement =connection.prepareCall("update user set city=? where id=?");
			
			callableStatement.setString(1, "pune");
			callableStatement.setInt(2, 5);
			
			callableStatement.execute();
		} catch (Exception e) {
			connection.close();
			callableStatement.close();
		}

	}

}
