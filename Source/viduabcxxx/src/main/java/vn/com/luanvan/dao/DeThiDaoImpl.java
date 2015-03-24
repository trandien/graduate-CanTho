package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.Dethi;

@Repository("deThiDao")
public class DeThiDaoImpl implements DeThiDao{

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
	public void ThemDeThi(Dethi DeThi) {
		try{
			sessionFactory.getCurrentSession().save(DeThi);
			System.out.println("Them de thi thanh cong");
		} catch (Exception e) {
			System.out.println("Them de thi that bai" +e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaDeThi(Dethi DeThi) {
		try {
			sessionFactory.getCurrentSession().update(DeThi);
			System.out.println("Sua de thi thanh cong");
		} catch(Exception e) {
			System.out.println("Sua de thi that bai");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaDeThi(Dethi DeThi) {
		try {
			sessionFactory.getCurrentSession().delete(DeThi);
			System.out.println("Xoa de thi thanh cong");
		} catch(Exception e) {
			System.out.println("Xoa de thi that bai");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Dethi> LayDeThiByTen(String tenDeThi) {
		List<Dethi> listDeThi = new ArrayList<Dethi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Dethi WHERE dt_Ten=:tenDeThi");
			listDeThi = query.setString("tenDeThi", tenDeThi).list();
		} catch(Exception e) {
			System.out.println("TimDeThiByTen: Loi khi lay danh sach de thi");
		}
		return listDeThi;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Dethi> LayDeThiByNienKhoa(String tenNienKhoa) {
		List<Dethi> listDeThi = new ArrayList<Dethi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Dethi dt JOIN Nienkhoa nk "
					+ "ON dt.MSNK=nk.MSNK AND nk.nk_ten=:tenNienKhoa");
			listDeThi = query.setString("tenNienKhoa", tenNienKhoa).list();
		} catch(Exception e) {
			System.out.println("TimDeThiByNienKhoa: Loi khi lay danh sach de thi Boi nien khoa");
		}
		return listDeThi;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Dethi> LayDeThiByChuDe(String tenChuDe) {
		List<Dethi> listDeThi = new ArrayList<Dethi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Dethi dt JOIN Chude cd "
					+ "ON dt.MSCD=cd.MSCD AND cd.cd_ten=:tenChuDe");
			listDeThi = query.setString("tenChuDe", tenChuDe).list();
		} catch(Exception e) {
			System.out.println("TimDeThiByChuDe: Loi khi lay danh sach de thi boi chu de");
		}
		return listDeThi;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Dethi> LayDeThiByMonHoc(String tenMonHoc) {
		List<Dethi> listDeThi = new ArrayList<Dethi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Dethi dt JOIN Monhoc mh "
					+ "ON dt.MSMH=mh.MSMH AND mh.mh_ten=:tenMonHoc");
			listDeThi = query.setString("tenMonHoc", tenMonHoc).list();
		} catch(Exception e) {
			System.out.println("TimDeThiByMonHoc: Loi khi lay danh sach de thi boi monhoc");
		}
		return listDeThi;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Dethi> LayDeThiByHocKy(Integer mshk) {
		List<Dethi> listDeThi = new ArrayList<Dethi>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Dethi WHERE mshk=:mshk");
			listDeThi = query.setInteger("mshk", mshk).list();
		} catch(Exception e) {
			System.out.println("TimDeThiByTen: Loi khi lay danh sach de thi");
		}
		return listDeThi;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Integer LayMaxDeThi(){
		int ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("select max(msdt) from Dethi");
			ketQua = (Integer) query.uniqueResult();
		} catch(Exception e) {
			System.out.println("getMaChuDeMax: Loi lay ma chu de");
		}
		return ketQua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Dethi LayDeThiByMa(Integer maDeThi) {
		Dethi DeThi = new Dethi();
		try {
			DeThi = (Dethi) sessionFactory.getCurrentSession().get(Dethi.class, maDeThi);
		} catch(Exception e) {
			System.out.println("LayDeThiByMa: Loi khi lay chude");
		}
		return DeThi;
	}

}
