package kr.ac.jejuuniv.userdao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;

public class UserDaoTest {
	@Test
	public void get() throws ClassNotFoundException, SQLException {

		UserDao userDao = new DaoFactory().getUserDao();

		String id = "hulk";
		String name = "허윤호";
		String password = "1111";

		User user = userDao.get(id);

		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(password, user.getPassword());
	}

	@Test
	public void add() throws ClassNotFoundException, SQLException {

		User user = new User();

		String id = String.valueOf(new Random().nextInt());
		String name = "허윤호";
		String password = "111";

		user.setId(id);
		user.setName(name);
		user.setPassword(password);

		UserDao userDao = new DaoFactory().getUserDao();
		userDao.add(user);
		User addUser = userDao.get(id);

		assertEquals(id, addUser.getId());
		assertEquals(name, addUser.getName());
		assertEquals(password, addUser.getPassword());
	}
}
