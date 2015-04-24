package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.Cautraloi;
import vn.com.luanvan.model.Chude;

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
			System.out.println("Them CauHoi that bai " + e.getMessage());
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
	public int LayMaxIdCauHoi(String taiKhoan) {
		int ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createSQLQuery(
					"select max(msch) from Cauhoi ch, Dethi dt WHERE ch.msdt=dt.msdt AND dt.dt_nguoirade=:taiKhoan");
			query.setParameter("taiKhoan", taiKhoan);
			ketQua = (Integer) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("LayMaxIdCauHoi: Loi lay ma cau hoi "
					+ e.getMessage());
		}
		return ketQua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cauhoi> listCauHoi(Integer maDeThi) {
		List<Cauhoi> listDeThis = new ArrayList<Cauhoi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from Cauhoi ch WHERE ch.dethi.msdt=:maDeThi ORDER BY RAND()");
			query.setParameter("maDeThi", maDeThi);
			listDeThis = query.list();
		} catch (Exception e) {
			System.out.println("Lay danh sach cau hoi " + e.getMessage());
		}
		return listDeThis;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Cauhoi LayCauHoiByMa(Integer maCauHoi) {
		Cauhoi CauHoi = new Cauhoi();
		try {
			CauHoi = (Cauhoi) sessionFactory.getCurrentSession().get(
					Cauhoi.class, maCauHoi);
			
		} catch (Exception e) {
			System.out.println("LayCauHoiByMa: Loi khi lay cau hoi");
		}
		return CauHoi;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Integer> ListIdCauHoi(Integer maDeThi) {
		List<Integer>ketqua = new ArrayList<Integer>();
		List<Cauhoi> cautraloi = new ArrayList<Cauhoi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Cauhoi ch WHERE ch.dethi.msdt=:msdt");
			query.setParameter("msdt", maDeThi);
			cautraloi =  query.list();
			for(Cauhoi a : cautraloi) {
				ketqua.add(a.getMsch());
			}
		} catch(Exception e) {
			System.out.println("ListIdCauHoi: Loi List Id Cau Tra Hoi "+e.getMessage());
		}
		return ketqua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Integer> ListDoKho(Integer maDeThi) {
		List<Integer>ketqua = new ArrayList<Integer>();
		List<Cauhoi> cautraloi = new ArrayList<Cauhoi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Cauhoi ch WHERE ch.dethi.msdt=:msdt");
			query.setParameter("msdt", maDeThi);
			cautraloi =  query.list();
			for(Cauhoi a : cautraloi) {
				ketqua.add(a.getDokho().getMsdk());
			}
		} catch(Exception e) {
			System.out.println("ListIdCauHoi: Loi List Id Cau Tra Hoi "+e.getMessage());
		}
		return ketqua;
	}

}
