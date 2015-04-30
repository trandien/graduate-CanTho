package vn.com.luanvan.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.DethiLop;
import vn.com.luanvan.model.Phongthi;

@Repository("phongThiDao")
public class PhongThiDaoImpl implements PhongThiDao{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void ThemPhongThi(Phongthi PhongThi) {
		try {
			sessionFactory.getCurrentSession().save(PhongThi);
			System.out.println("Them PhongThi thanh cong");
		} catch (Exception e) {
			System.out.println("Them PhongThi that bai " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaPhongThi(Phongthi PhongThi) {
		try {
			sessionFactory.getCurrentSession().update(PhongThi);
			System.out.println("Sua PhongThi thanh cong");
		} catch (Exception e) {
			System.out.println("Sua PhongThi that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaPhongThi(Phongthi PhongThi) {
		try {
			sessionFactory.getCurrentSession().delete(PhongThi);
			System.out.println("Xoa PhongThi thanh cong");
		} catch (Exception e) {
			System.out.println("Xoa PhongThi that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Phongthi> danhSachPhongThi() {
		List<Phongthi> listPhongThi = new ArrayList<Phongthi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Phongthi");
			listPhongThi = query.list();
		} catch (Exception e) {
			System.out.println("Lay danh sach phong thi " + e.getMessage());
		}
		return listPhongThi;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Phongthi LayPhongThiByMa(int mspt) {
		try {
			Phongthi PhongThi = (Phongthi) sessionFactory.getCurrentSession().get(Phongthi.class, mspt);
			return PhongThi;
		} catch(Exception e) {
			return null;
		}
	}
	

}
