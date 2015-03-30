package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Cautraloi;
import vn.com.luanvan.model.Chude;

@Repository("cauTraLoiDao")
public class CauTraLoiDaoImpl implements CauTraLoiDao {
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
	public void ThemCauTraLoi(Cautraloi CauTraLoi) {
		try {
			sessionFactory.getCurrentSession().save(CauTraLoi);
			System.out.println("Them CauTraLoi thanh cong");
		} catch (Exception e) {
			System.out.println("Them CauTraLoi that bai" + e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaCauTraLoi(Cautraloi CauTraLoi) {
		try {
			sessionFactory.getCurrentSession().update(CauTraLoi);
			System.out.println("Sua CauTraLoi thanh cong");
		} catch (Exception e) {
			System.out.println("Sua CauTraLoi that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaCauTraLoi(Cautraloi CauTraLoi) {
		try {
			sessionFactory.getCurrentSession().delete(CauTraLoi);
			System.out.println("Xoa CauTraLoi thanh cong");
		} catch (Exception e) {
			System.out.println("Xoa CauTraLoi that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cautraloi> LayDSCauTraLoi(Integer maCauHoi) {
		List<Cautraloi> listCauTraLoi = new ArrayList<Cautraloi>();
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Cautraloi ctl WHERE ctl.cauhoi.msch=:msch");
			query.setParameter("msch", maCauHoi);
			listCauTraLoi = query.list();
		} catch (Exception e) {
			System.out.println("LayDSCauTraLoi: Loi khi lay DS Cau Tra Loi");
		}
		return listCauTraLoi;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Cautraloi LayCauTraLoiByMa(Integer maCauTraLoi) {
		Cautraloi CauTraLoi = new Cautraloi();
		try {
			CauTraLoi = (Cautraloi)sessionFactory.getCurrentSession().get(Cautraloi.class, maCauTraLoi);
		} catch (Exception e) {
			System.out.println("LayCauTraLoiByMa: Loi khi Lay Cau Tra Loi By Ma");
		}
		return CauTraLoi;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer LayMaxCauTraLoi(Integer maCauHoi) {
		int ketQua = 0;
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(
							"select max(msctrl) from Cautraloi ctl WHERE clt.cauhoi.msch=:msch");
			query.setParameter("msch", maCauHoi);
			ketQua = (Integer) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("LayMaxCauTraLoi: Loi Lay Max Cau Tra Loi");
		}
		return ketQua;
	}

}
