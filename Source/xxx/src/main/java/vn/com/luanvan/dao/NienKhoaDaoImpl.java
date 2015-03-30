package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.Monhoc;
import vn.com.luanvan.model.Nienkhoa;

@Repository("nienKhoaDao")
public class NienKhoaDaoImpl implements NienKhoaDao{
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
	public void ThemNienKhoa(Nienkhoa NienKhoa) {
		try{
			sessionFactory.getCurrentSession().save(NienKhoa);
			System.out.println("Them NienKhoa thanh cong");
		} catch (Exception e) {
			System.out.println("Them NienKhoa that bai" +e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaNienKhoa(Nienkhoa NienKhoa) {
		try {
			sessionFactory.getCurrentSession().update(NienKhoa);
			System.out.println("Sua NienKhoa thanh cong");
		} catch(Exception e) {
			System.out.println("Sua NienKhoa that bai");
		}		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaNienKhoa(Nienkhoa NienKhoa) {
		try {
			sessionFactory.getCurrentSession().delete(NienKhoa);
			System.out.println("Xoa NienKhoa thanh cong");
		} catch(Exception e) {
			System.out.println("Xoa NienKhoa that bai");
		}		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Nienkhoa TimNienKhoaByMa(int maNienKhoa) {
		Nienkhoa NienKhoa = new Nienkhoa();
		try {
			NienKhoa = (Nienkhoa) sessionFactory.getCurrentSession().get(Nienkhoa.class, maNienKhoa);
		} catch(Exception e) {
			System.out.println("TimNienKhoaByMa: Loi khi lay Nienkhoa");
		}
		return NienKhoa;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Nienkhoa> TimNienKhoaByTen(String tenNienKhoa) {
		List<Nienkhoa> listNienKhoa = new ArrayList<Nienkhoa>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Nienkhoa WHERE nk_Ten=:tenNienKhoa");
			listNienKhoa = query.setString("tenNienKhoa", tenNienKhoa).list();
		} catch(Exception e) {
			System.out.println("listNienKhoa: Loi khi lay danh sach nienkhoa");
		}
		return listNienKhoa;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer getMaNienKhoaMax() {
		int ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("select max(msnk) from Nienkhoa");
			ketQua = (Integer) query.uniqueResult();
		} catch(Exception e) {
			System.out.println("getMaNienkhoaMax: Loi lay ma nien khoa");
		}
		return ketQua;
	}

	@Override
	public List<Nienkhoa> DSNienKhoa() {
		List<Nienkhoa> listNienKhoa = new ArrayList<Nienkhoa>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Nienkhoa");
			listNienKhoa = query.list();
		} catch(Exception e) {
			System.out.println("listNienKhoa: Loi khi lay listNienKhoa");
		}
		return listNienKhoa;
	}

}
