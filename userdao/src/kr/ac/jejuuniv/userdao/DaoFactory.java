package kr.ac.jejuuniv.userdao;

public class DaoFactory {

	public UserDao getUserDao() {
		return new UserDao(new DConnectionMaker());
	}

}
