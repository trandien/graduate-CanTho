package vn.com.luanvan.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DethiLop> LayDSDeThiLop(Date ngay, int mspt) {
		List<DethiLop> listDeThiLop = new ArrayList<DethiLop>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from Dethi_lop WHERE ngay=:ngay " + "AND mspt=:mspt");
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
		String sql = "select * from Dethi_lop WHERE msl=:msl AND msdt=:msdt";
		try {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.addEntity(DethiLop.class);
			query.setParameter("msl", msl);
			query.setParameter("msdt", msdt);
			dtl = (DethiLop) query.list().get(0);
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le LayDeThiLopById : "
					+ e.getMessage());
		}
		return dtl;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public DethiLop LayDTLByPhongVaThoiGian(int mspt, String ngay,
			String gioBatDau, String gioKetThuc) throws ParseException {
		DethiLop dtl = new DethiLop();
		System.out.println("MSDT :"+mspt);
		System.out.println("ngay :"+ngay);
		System.out.println("gioBatDau :"+gioBatDau);
		System.out.println("gioKetThuc :"+gioKetThuc);
		SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("yyyy-MM-dd");
		Date layNgay = dinhDangThoiGian.parse(ngay);
		SimpleDateFormat time = new SimpleDateFormat("hh:mm");
		Date layGioBatDau = time.parse(gioBatDau);
		Date layGioKetThuc = time.parse(gioKetThuc);
		try {
			SQLQuery query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(
							"select * from Dethi_lop WHERE mspt=:mspt AND ngay=:ngay AND giobatdau=:giobatdau AND gioketthuc=:gioketthuc");
			query.addEntity(DethiLop.class);
			query.setParameter("mspt", mspt);
			query.setParameter("ngay", layNgay);
			query.setParameter("giobatdau", layGioBatDau);
			query.setParameter("gioketthuc", layGioKetThuc);
			dtl = (DethiLop) query.list().get(0);
			System.out.println("dtl : " + dtl.getDethi().getMsdt());
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le LayDTLByPhongVaThoiGian : "
					+ e.getMessage());
		}
		return dtl;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DethiLop> listLopByMSDT(int msdt) {
		List<DethiLop> listDTL = new ArrayList<DethiLop>();
		try {
			SQLQuery query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(
							"select * from Dethi_lop WHERE msdt=:msdt");
			query.addEntity(DethiLop.class);
			query.setParameter("msdt", msdt);
			listDTL =  query.list();
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le listLopByMSDT : "
					+ e.getMessage());
		}
		return listDTL;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DethiLop> listDeThiByMSDT(String msl) {
		List<DethiLop> listDTL = new ArrayList<DethiLop>();
		try {
			SQLQuery query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(
							"select * from Dethi_lop WHERE msl=:msl");
			query.addEntity(DethiLop.class);
			query.setParameter("msl", msl);
			listDTL =  query.list();
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le listDeThiByMSDT : "
					+ e.getMessage());
		}
		return listDTL;
	}

}
