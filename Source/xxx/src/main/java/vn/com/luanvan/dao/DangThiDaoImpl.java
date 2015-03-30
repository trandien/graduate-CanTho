package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.Dangthi;

@Repository("dangThiDao")
public class DangThiDaoImpl implements DangThiDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Dangthi> DSDangThi() {
		List<Dangthi> listDangThi = new ArrayList<Dangthi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Dangthi");
			listDangThi = query.list();
		} catch(Exception e) {
			System.out.println("ds dang thi: Loi khi lay danh sach mon hoc");
		}
		return listDangThi;
	}

	@Override
	public Dangthi TimDangThiByMa(int maDangThi) {
		Dangthi dangThi = new Dangthi();
		try {
			dangThi = (Dangthi) sessionFactory.getCurrentSession().get(Dangthi.class, maDangThi);
		} catch(Exception e) {
			System.out.println("TimDangThiByMa: Loi khi lay TimDangThiByMa");
		}
		return dangThi;
	}

}
