package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.Khoi;
import vn.com.luanvan.model.Lop;

@Repository("lopDao")
public class LopDaoImpl implements LopDao {

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
	public void ThemLop(Lop lop) {
		try {
			sessionFactory.getCurrentSession().save(lop);
			System.out.println("Them lop thanh cong");
		} catch (Exception e) {
			System.out.println("Them lop that bai " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaLop(Lop lop) {
		try {
			sessionFactory.getCurrentSession().update(lop);
			System.out.println("Sua lop thanh cong");
		} catch (Exception e) {
			System.out.println("Sua lop that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaLop(Lop lop) {
		try {
			sessionFactory.getCurrentSession().delete(lop);
			System.out.println("Xoa lop thanh cong");
		} catch (Exception e) {
			System.out.println("Xoa lop that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Lop> listLop() {
		List<Lop> listLop = new ArrayList<Lop>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from Lop");
			listLop = query.list();
		} catch (Exception e) {
			System.out.println("Lay danh sach cau hoi " + e.getMessage());
		}
		return listLop;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Lop> listLopByKhoi(Integer msk) {
		List<Lop> listLop = new ArrayList<Lop>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from Lop l WHERE l.khoi.msk=:msk");
			query.setParameter("msk", msk);
			listLop = query.list();
		} catch (Exception e) {
			System.out.println("Loi listLopByKhoi " + e.getMessage());
		}
		return listLop;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void ThemLopVaoDeThi(Integer msdt, String msl) {
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(
							"INSSERT INTO Dethi_lop(msl, msdt) VALUES(msl=:msl, msdt=:msdt)");
			query.setParameter("msl", msl);
			query.setParameter("msdt", msdt);
		} catch (Exception e) {
			System.out.println("Loi ThemLopVaoDeThi " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Lop LayLopByMa(String msl) {
		Lop lop = new Lop();
		try {
			lop = (Lop) sessionFactory.getCurrentSession().get(Lop.class, msl);
		} catch (Exception e) {
			System.out.println("LayLopByMa: Loi khi lay cau hoi");
		}
		return lop;
	}

}
