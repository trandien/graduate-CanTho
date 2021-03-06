package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
    protected JavaMailSender mailSender;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*Ham dung de tim kiem nguoi dung*/
	@SuppressWarnings("unchecked")
	@Transactional
	public User findByUserName(String taikhoan) {
		User user = new User();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from User where taikhoan=:taikhoan");
			query.setString("taikhoan", taikhoan);
			user = (User) query.uniqueResult();
		} catch(Exception e) {
			System.out.println("Loi khi lay user");
		}
		return user;
	}
	
	/**
	 * @author lonel_000
	 */
	@Transactional
	public void update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			System.out.println("Update thanh cong");
		} catch(Exception e) {
			System.out.println("Update that bai");
		}
	}

	/**
	 * @author lonel_000
	 */
	@Transactional
	public void add(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			System.out.println("Them thanh cong");
		}catch(Exception e) {
			System.out.println("Them that bai");
		}
	}
	
	
	@Transactional
	public void sendMail(String emailTo, String subject, String text){
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailTo);
        email.setSubject(subject);
        email.setText(text);
        // sends the e-mail
        email.setFrom("ankianpata@gmail.com");
        mailSender.send(email);
	}
	
	@Transactional
	public boolean checkOldPassword (User user, String oldPass){
		if(oldPass.equals(user.getMatKhau())){
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public boolean ExistEmail(String email) {
		User user = new User();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from User where email=:email");
			query.setString("email", email);
			user = (User) query.uniqueResult();
			if(user!=null) {
				System.out.println("Email ton tai");
			} else {
				System.out.println("Email chua ton tai");
			}
		} catch(Exception e) {
			System.out.println("Loi khi lay user");
		}
		return user!=null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public String RanCode() {
		Random rm = new Random();
		String matKhauRandom = "";
		int tam = 0;
		for (int i = 0; i < 8; i++) {
			tam = rm.nextInt(74) + 48;
			while ((tam > 57 && tam < 65) || (tam > 90 && tam < 97)) {
				tam = rm.nextInt(74) + 48;
			}
			matKhauRandom += (char) tam;
		}
		return matKhauRandom;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public User getUserByEmail(String email) {
		User user = new User();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from User WHERE email=:email");
			query.setString("email", email);
			user = (User) query.uniqueResult();
		} catch(Exception e) {
			System.out.println("getUserByEmail: Loi khi lay user");
		}
		return user;
	}

}