package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.ChuDe;

@Repository("chuDeDao")
public class ChuDeDaoImpl implements ChuDeDao{
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
	public void ThemChuDe(ChuDe chude) {
		try{
			sessionFactory.getCurrentSession().save(chude);
			System.out.println("Them chu de thanh cong");
		} catch (Exception e) {
			System.out.println("Them chu de that bai");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaChuDe(ChuDe chude) {
		try {
			sessionFactory.getCurrentSession().update(chude);
			System.out.println("Sua chu de thanh cong");
		} catch(Exception e) {
			System.out.println("Sua chu de that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaChuDe(ChuDe chude) {
		try {
			sessionFactory.getCurrentSession().delete(chude);
			System.out.println("Xoa chu de thanh cong");
		} catch(Exception e) {
			System.out.println("Xoa chu de that bai");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ChuDe TimChuDeByMa(int maChuDe) {
		ChuDe chuDe = new ChuDe();
		try {
			chuDe = (ChuDe) sessionFactory.getCurrentSession().get(ChuDe.class, maChuDe);
		} catch(Exception e) {
			System.out.println("TimChuDeByMa: Loi khi lay chude");
		}
		return chuDe;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ChuDe> TimChuDeByTen (String tenChuDe){
		List<ChuDe> listChuDe = new ArrayList<ChuDe>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Chude WHERE cd_Ten=:tenchude");
			listChuDe = query.setString("tenchude", tenChuDe).list();
		} catch(Exception e) {
			System.out.println("TimChuDeByTen: Loi khi lay danh sach chu de");
		}
		return listChuDe;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer getMaChuDeMax() {
		int ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("select max(mscd) from Chude");
			ketQua = (Integer) query.uniqueResult();
		} catch(Exception e) {
			System.out.println("getMaChuDeMax: Loi lay ma chu de");
		}
		return ketQua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ChuDe> DSChuDe() {
		// TODO Auto-generated method stub
		return null;
	}

}
