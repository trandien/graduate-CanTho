package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Monhoc;

@Repository("monHocDao")
public class MonHocDaoImpl implements MonHocDao{

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
	public void ThemMonHoc(Monhoc MonHoc) {
		try{
			sessionFactory.getCurrentSession().save(MonHoc);
			System.out.println("Them Mon hoc thanh cong");
		} catch (Exception e) {
			System.out.println("Them Mon hoc that bai" +e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaMonHoc(Monhoc MonHoc) {
		try {
			sessionFactory.getCurrentSession().update(MonHoc);
			System.out.println("Sua Mon hoc thanh cong");
		} catch(Exception e) {
			System.out.println("Sua Mon hoc that bai");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaMonHoc(Monhoc MonHoc) {
		try {
			sessionFactory.getCurrentSession().delete(MonHoc);
			System.out.println("Xoa MonHoc thanh cong");
		} catch(Exception e) {
			System.out.println("Xoa MonHoc that bai");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Monhoc> DSMonHoc() {
		List<Monhoc> listMonhoc = new ArrayList<Monhoc>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Monhoc");
			listMonhoc = query.list();
		} catch(Exception e) {
			System.out.println("ds monhoc: Loi khi lay danh sach mon hoc");
		}
		return listMonhoc;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Monhoc LayMonHocByMa(int maMonHoc) {
		Monhoc monhoc = new Monhoc();
		try {
			monhoc = (Monhoc) sessionFactory.getCurrentSession().get(Monhoc.class, maMonHoc);
		} catch(Exception e) {
			System.out.println("LayMonHocByMa: Loi khi lay LayMonHocByMa");
		}
		return monhoc;
	}

}
