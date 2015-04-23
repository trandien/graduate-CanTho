package vn.com.luanvan.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
			Query query = sessionFactory.getCurrentSession().createSQLQuery(
					"Create table " + taiKhoan + "_" + msdt + "_" + soLanThi
							+ "(" + "MSCH int," + "DAPANDACHON text,"
							+ "DAPANDUNG text," + "DIEM float,"
							+ "PRIMARY KEY (MSCH)" + ");");
			System.out.println("Tao table thanh cong");
		} catch (Exception e) {
			System.out.println("Tao table that bai: " + e.getMessage());
		}
	}

	@Override
	public Integer KiemTraSoLanThi(String taiKhoan, int msdt) {
		Integer ketQua = 0;
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"select count(*) from Thi t WHERE t.user.ndTaikhoan=:taiKhoan "
											+ "AND t.dethi.msdt=:msdt");
			query.setParameter("taiKhoan", taiKhoan);
			query.setParameter("msdt", msdt);
			return ((Number)query.uniqueResult()).intValue();
		} catch(Exception e) {
			System.out.println("Xay ra ngoai le KiemTraSoLanThi : "+e.getMessage());
		}
		System.out.println("So lan thi : "+ketQua);
		return ketQua;
	}

}
