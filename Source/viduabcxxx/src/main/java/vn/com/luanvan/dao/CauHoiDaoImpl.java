package vn.com.luanvan.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Cauhoi;

@Repository("cauHoiDao")
public class CauHoiDaoImpl implements CauHoiDao {
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
	public void ThemCauHoi(Cauhoi CauHoi) {
		try {
			sessionFactory.getCurrentSession().save(CauHoi);
			System.out.println("Them CauHoi thanh cong");
		} catch (Exception e) {
			System.out.println("Them CauHoi that bai" + e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaCauHoi(Cauhoi CauHoi) {
		try {
			sessionFactory.getCurrentSession().update(CauHoi);
			System.out.println("Sua CauHoi thanh cong");
		} catch (Exception e) {
			System.out.println("Sua CauHoi that bai");
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaCauHoi(Cauhoi CauHoi) {
		try {
			sessionFactory.getCurrentSession().delete(CauHoi);
			System.out.println("Xoa CauHoi thanh cong");
		} catch (Exception e) {
			System.out.println("Xoa CauHoi that bai");
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer LayMaxIdCauHoi(Integer maDeThi) {
		int ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"select max(msch) from Cauhoi WHERE msdt=:maDeThi");
			query.setInteger("maDeThi", maDeThi);
			ketQua = (Integer) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("LayMaxIdCauHoi: Loi lay ma cau hoi");
		}
		return ketQua;
	}

}
