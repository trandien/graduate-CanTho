package vn.com.luanvan.service;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.UserDao;
import vn.com.luanvan.dao.UserDaoImpl;
import vn.com.luanvan.model.User;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void sendMail(User user) {
		userDao.sendMail(user);
		
	}

	@Override
	public boolean checkOldPassword(User user, String oldPass) {
		return userDao.checkOldPassword(user, oldPass);
	}

	@Override
	public boolean ExistEmail(String email) {
		return userDao.ExistEmail(email);
	}

}
