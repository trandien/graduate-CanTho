package vn.com.luanvan.dao;


import vn.com.luanvan.model.User;

public interface UserDao {

	User findByUserName(String username);

	/**
	 * @author lonel_000
	 * @param user
	 */
	void update(User user);

	void add(User user);
	
	void sendMail (User user);

	boolean checkOldPassword (User user, String oldPass);
	
	boolean ExistEmail(String email);
	
	
}