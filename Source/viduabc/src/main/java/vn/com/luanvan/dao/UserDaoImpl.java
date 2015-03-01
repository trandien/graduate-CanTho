package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

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
	public void sendMail(User user){
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Đăng ký tài khoản Anki");
        email.setText("Xin chào bạn đã đăng ký thành công tài khoản \n\n"
        		+ "Tài khoản: "+user.getEmail() +"\n\n"
        		+"Mật khẩu: "+user.getMatKhau()+ "\n"
        		);
        // sends the e-mail
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
		boolean result = false;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from User where email=:email");
			System.out.println("Loi o day");
			query.setString("email", email);
			user = (User) query.uniqueResult();
			if(!user.getEmail().equals("") || user.getEmail()!=null) {
				result = true;
			} else {}
		} catch(Exception e) {
			System.out.println("ExistEmail: Loi khi lay user");
		}
		if(result == false) {
			System.out.println("ExistEmail: Tai khoan ton tai");
		} else {
			System.out.println("ExistEmail: Tai khoan khong ton tai");
		}
		return result;
	}

}