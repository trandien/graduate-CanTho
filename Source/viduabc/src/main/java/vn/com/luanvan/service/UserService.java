package vn.com.luanvan.service;

import vn.com.luanvan.model.User;

public interface UserService {
	User findByUserName(String username);

	/**
	 * @author lonel_000
	 * @param user
	 */
	void update(User user);

	void add(User user);
	
	void sendMail (String emailTo, String subject, String text);

	boolean checkOldPassword (User user, String oldPass);
	
	boolean ExistEmail(String email);
	
	User getUserByEmail(String email);
	
	String RanCode();
}
