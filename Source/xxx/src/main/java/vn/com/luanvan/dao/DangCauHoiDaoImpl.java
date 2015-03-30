package vn.com.luanvan.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.Dangcauhoi;

@Repository("dangCauHoiDao")
public class DangCauHoiDaoImpl implements DangCauHoiDao{
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
	public void ThemDangCauHoi(Dangcauhoi DangCauHoi) {
		try{
			sessionFactory.getCurrentSession().save(DangCauHoi);
			System.out.println("Them DangCauHoi thanh cong");
		} catch (Exception e) {
			System.out.println("Them DangCauHoi that bai" +e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaDangCauHoi(Dangcauhoi DangCauHoi) {
		try {
			sessionFactory.getCurrentSession().update(DangCauHoi);
			System.out.println("Sua DangCauHoi thanh cong");
		} catch(Exception e) {
			System.out.println("Sua DangCauHoi that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaDangCauHoi(Dangcauhoi DangCauHoi) {
		try {
			sessionFactory.getCurrentSession().delete(DangCauHoi);
			System.out.println("Xoa DangCauHoi thanh cong");
		} catch(Exception e) {
			System.out.println("Xoa DangCauHoi that bai");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer getMaDangCauHoiMax() {
		int ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("select max(msdch) from Dangcauhoi");
			ketQua = (Integer) query.uniqueResult();
		} catch(Exception e) {
			System.out.println("getMaDoKhoMax: Loi lay ma Dokho");
		}
		return ketQua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Dangcauhoi LayDangCauHoiByMa(Integer maDangCauHoi) {
		Dangcauhoi DangCauHoi = new Dangcauhoi();
		try {
			DangCauHoi = (Dangcauhoi) sessionFactory.getCurrentSession().get(Dangcauhoi.class, maDangCauHoi);
		} catch(Exception e) {
			System.out.println("LayDangCauHoiByMa: Loi khi lay DangCauHoi");
		}
		return DangCauHoi;
	}
	

}
