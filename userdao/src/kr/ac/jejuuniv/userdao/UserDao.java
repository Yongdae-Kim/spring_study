package kr.ac.jejuuniv.userdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserDao() {

	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User get(String id) throws SQLException {
		String sql = "SELECT id, name, password FROM userinfo WHERE id = ?";
		String[] params = new String[] { id };

		User user = null;

		try {
			return jdbcTemplate.queryForObject(sql, params,
					new RowMapper<User>() {
						@Override
						public User mapRow(ResultSet resultSet, int rowNum)
								throws SQLException {
							User user = new User();
							user.setId(resultSet.getString("id"));
							user.setName(resultSet.getString("name"));
							user.setPassword(resultSet.getString("password"));
							return user;
						}
					});
		} catch (EmptyResultDataAccessException e) {
		}
		return user;
	}

	public void add(User user) throws SQLException {
		String sql = "INSERT INTO userinfo(id, name, password) VALUES(?, ?, ?)";
		String[] params = new String[] { user.getId(), user.getName(),
				user.getPassword() };

		jdbcTemplate.update(sql, params);
	}

	public void delete(String id) throws SQLException {
		String sql = "DELETE FROM userinfo WHERE id = ?";
		String[] params = new String[] { id };

		jdbcTemplate.update(sql, params);
	}

}
