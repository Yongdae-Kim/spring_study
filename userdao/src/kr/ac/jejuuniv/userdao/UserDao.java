package kr.ac.jejuuniv.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	private ConnectionMaker connectionMaker;

	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection connection = connectionMaker.getConnection();

		String sql = "SELECT id, name, password FROM userinfo WHERE id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();

		User user = new User();
		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));

		resultSet.close();
		preparedStatement.close();
		connection.close();

		return user;
	}

	public void add(User user) throws SQLException, ClassNotFoundException {
		Connection connection = connectionMaker.getConnection();
		String sql = "INSERT INTO userinfo(id, name, password) VALUES(?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.executeUpdate();

		preparedStatement.close();
		connection.close();
	}
}
