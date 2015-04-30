package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.DethiLop;

@Repository("deThiLopDao")
public class DeThiLopDaoImpl implements DeThiLopDao {

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
	public void ThemDeThiLop(DethiLop dtl) {
		try {
			sessionFactory.getCurrentSession().save(dtl);
			System.out.println("Them dtl thanh cong");
		} catch (Exception e) {
			System.out.println("Them dtl that bai" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaDeThiLop(DethiLop dtl) {
		try {
			sessionFactory.getCurrentSession().update(dtl);
			System.out.println("Sua dtl thanh cong");
		} catch (Exception e) {
			System.out.println("Sua dtl that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaDeThiLop(DethiLop dtl) {
		try {
			sessionFactory.getCurrentSession().delete(dtl);
			System.out.println("Xoa dtl thanh cong");
		} catch (Exception e) {
			System.out.println("Xoa dtl that bai");
		}
	}

	@Override
	public List<DethiLop> LayDSDeThiLop(Date ngay, int mspt) {
		List<DethiLop> listDeThiLop = new ArrayList<DethiLop>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"select * from Dethi_lop WHERE ngay=:ngay "
							+ "AND mspt=:mspt");
			query.setParameter("ngay", ngay);
			query.setParameter("mspt", mspt);
			listDeThiLop = query.list();
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le LayDSDeThiLop : "
					+ e.getMessage());
		}
		return listDeThiLop;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public DethiLop LayDeThiLopById(int msdt, String msl) {
		DethiLop dtl = new DethiLop();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"select * from Dethi_lop dtl WHERE dtl.dethi.msdt=:msdt "
							+ "AND dtl.lop.msl=:msl");
			dtl = (DethiLop) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le LayDeThiLopById : "
					+ e.getMessage());
		}
		return dtl;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public DethiLop LayDTLByPhongVaThoiGian(int mspt, Date ngay,
			Date gioBatDau, Date gioKetThuc) {
		DethiLop dtl = new DethiLop();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"select * from Dethi_lop WHERE mspt=:mspt "
							+ "AND ngay=:ngay AND giobatdau=:giobatdau AND gioketthuc=:gioketthuc");
			query.setParameter("mspt", mspt);
			query.setParameter("ngay", ngay);
			query.setParameter("giobatdau", gioBatDau);
			query.setParameter("gioketthuc", gioKetThuc);
			dtl = (DethiLop) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le LayDTLByPhongVaThoiGian : "
					+ e.getMessage());
		}
		return dtl;
	}

}
