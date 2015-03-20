package kr.ac.jejuuniv.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://113.198.165.184/jeju?characterEncoding=utf-8",
				"jeju", "jejupw");
		return connection;
	}
}
