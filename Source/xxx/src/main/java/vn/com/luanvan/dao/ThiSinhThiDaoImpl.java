package vn.com.luanvan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Thi;

@Repository("thiSinhThiDao")
public class ThiSinhThiDaoImpl implements ThiSinhThiDao {
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
	public void CreateTableExam(String taiKhoan, int msdt, int soLanThi) {
		try {
			System.out.println(taiKhoan + "_" + msdt + "_" + soLanThi);
			Query query = sessionFactory.getCurrentSession().createSQLQuery(
					"Create table Z" + taiKhoan + "_" + msdt + "_" + soLanThi
							+ "(" + "MSCH int," + "DAPANDACHON text,"
							+ "DAPANDUNG text," + "DIEM float,"
							+ "PRIMARY KEY (MSCH)" + ");");
			query.executeUpdate();
			System.out.println("Tao table thanh cong");
		} catch (Exception e) {
			System.out.println("Tao table that bai: " + e.getMessage());
		}
	}

	@Override
	public Integer KiemTraSoLanThi(String taiKhoan, int msdt) {
		Integer ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"select count(*) from Thi t WHERE t.user.ndTaikhoan=:taiKhoan "
							+ "AND t.dethi.msdt=:msdt");
			query.setParameter("taiKhoan", taiKhoan);
			query.setParameter("msdt", msdt);
			return ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le KiemTraSoLanThi : "
					+ e.getMessage());
		}
		System.out.println("So lan thi : " + ketQua);
		return ketQua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void ThemThiSinhThi(Thi thi) {
		try {
			sessionFactory.getCurrentSession().save(thi);
			System.out.println("Them ThemThiSinhThi thanh cong");
		} catch (Exception e) {
			System.out
					.println("Them ThemThiSinhThi that bai " + e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaThiSinhThi(Thi thi) {
		try {
			sessionFactory.getCurrentSession().update(thi);
			System.out.println("Sua SuaThiSinhThi thanh cong");
		} catch (Exception e) {
			System.out.println("Sua SuaThiSinhThi that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaThiSinhThi(Thi thi) {
		try {
			sessionFactory.getCurrentSession().delete(thi);
			System.out.println("Xoa XoaThiSinhThi thanh cong");
		} catch (Exception e) {
			System.out.println("Xoa XoaThiSinhThi that bai");
		}
	}

	@Override
	public void LuuKQThiSinh(String tableName, int msch, int msctl) {
		try {
			Query query = sessionFactory.getCurrentSession().createSQLQuery(
					"INSERT INTO Z" + tableName
							+ "(MSCH, DAPANDACHON, DAPANDUNG, DIEM) "
							+ "VALUES(:msch, :msctl, null , 0)");
			query.setParameter("msch", msch);
			query.setParameter("msctl", msctl);
			query.executeUpdate();
			System.out.println("LuuKQThiSinh thanh cong");
		} catch (Exception e) {
			System.out.println("LuuKQThiSinh that bai");
		}
	}

	@Override
	public void SuaKQThiSinh(String tableName, int msch, int msctl) {
		try {
			Query query = sessionFactory.getCurrentSession().createSQLQuery(
					"UPDATE Z" + tableName
							+ " SET DAPANDACHON=:msctl WHERE MSCH=:msch ");
			query.setParameter("msch", msch);
			query.setParameter("msctl", msctl);
			query.executeUpdate();
			System.out.println("SuaKQThiSinh thanh cong");
		} catch (Exception e) {
			System.out.println("SuaKQThiSinh that bai "+e.getMessage());
		}
	}

	@Override
	public boolean KTCHDaDuocChon(String tableName, int msch) {
		boolean ketQua = false;
		try {
			Query query = sessionFactory.getCurrentSession().createSQLQuery(
					"select * from Z" + tableName + " WHERE MSCH=:msch ");
			query.setParameter("msch", msch);
			query.uniqueResult();
			ketQua = (query.uniqueResult() != null ? true : false);
			System.out.println("KTCHDaDuocChon thanh cong");
		} catch (Exception e) {
			System.out.println("KTCHDaDuocChon loi "+e.getMessage());
		}
		return ketQua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public String LayBangDangThi(String taiKhoan, int msch) {
		String ketQua = "";
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Thi t WHERE t.user.ndTaikhoan=:taiKhoan AND t.cauhoi.msch=:msch");
			query.setParameter("taiKhoan", taiKhoan);
			query.setParameter("msch", msch);
			List<Thi> thi = query.list();
			String soLanThi = String.valueOf(thi.get(thi.size()-1).getSolanthi());
			ketQua = "Z"+taiKhoan+"_"+msch+"_"+soLanThi;
			System.out.println("LayBangDangThi thanh cong : "+ketQua);
		} catch (Exception e) {
			System.out.println("LayBangDangThi loi");
		}
		return ketQua;
	}

}
