package kr.ac.jejuuniv.userdao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {

	private UserDao userDao;

	@Before
	public void setup() {
		ApplicationContext applicationContext = new GenericXmlApplicationContext(
				"daofactory.xml");
		userDao = applicationContext.getBean("userDao", UserDao.class);
	}

	@Test
	public void get() throws ClassNotFoundException, SQLException {

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

		userDao.add(user);
		User addUser = userDao.get(id);

		assertEquals(id, addUser.getId());
		assertEquals(name, addUser.getName());
		assertEquals(password, addUser.getPassword());
	}

	@Test
	public void delete() throws ClassNotFoundException, SQLException {
		User user = new User();

		String id = String.valueOf(new Random().nextInt());
		String name = "허윤호";
		String password = "111";

		user.setId(id);
		user.setName(name);
		user.setPassword(password);

		userDao.add(user);

		userDao.delete(id);

		assertNull(userDao.get(id));
		assertEquals(null, userDao.get(id));
	}
}
