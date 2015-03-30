package vn.com.luanvan.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.Dokho;

@Repository("doKhoDao")
public class DoKhoDaoImpl implements DoKhoDao{

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
	public void ThemDoKho(Dokho DoKho) {
		try{
			sessionFactory.getCurrentSession().save(DoKho);
			System.out.println("Them DoKho thanh cong");
		} catch (Exception e) {
			System.out.println("Them DoKho that bai" +e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaNienKhoa(Dokho DoKho) {
		try {
			sessionFactory.getCurrentSession().update(DoKho);
			System.out.println("Sua DoKho thanh cong");
		} catch(Exception e) {
			System.out.println("Sua DoKho that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaDoKho(Dokho DoKho) {
		try {
			sessionFactory.getCurrentSession().delete(DoKho);
			System.out.println("Xoa DoKho thanh cong");
		} catch(Exception e) {
			System.out.println("Xoa DoKho that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer getMaDoKhoMax() {
		int ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("select max(msdk) from Dokho");
			ketQua = (Integer) query.uniqueResult();
		} catch(Exception e) {
			System.out.println("getMaDoKhoMax: Loi lay ma Dokho");
		}
		return ketQua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Dokho LayDoKhoByMa(Integer maDoKho) {
		Dokho DoKho = new Dokho();
		try {
			DoKho = (Dokho) sessionFactory.getCurrentSession().get(Dokho.class, maDoKho);
		} catch(Exception e) {
			System.out.println("LayDoKhoByMa: Loi khi lay maDoKho");
		}
		return DoKho;
	}
	
	
}
