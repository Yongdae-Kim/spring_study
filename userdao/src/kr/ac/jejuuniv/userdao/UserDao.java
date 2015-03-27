package kr.ac.jejuuniv.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDao {

	private DataSource dataSource;

	public UserDao() {

	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public User get(String id) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			connection = dataSource.getConnection();

			String sql = "SELECT id, name, password FROM userinfo WHERE id = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e2) {
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
			}
		}
		return user;
	}

	public void add(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String sql = "INSERT INTO userinfo(id, name, password) VALUES(?, ?, ?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
			}
		}

	}

	public void delete(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String sql = "DELETE FROM userinfo WHERE id = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
			}
		}
	}
}
