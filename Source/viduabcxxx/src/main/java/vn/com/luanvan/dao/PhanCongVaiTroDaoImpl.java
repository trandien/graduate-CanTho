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
import vn.com.luanvan.model.Phancongvaitro;

@Repository("phanCongVaiTroDao")
public class PhanCongVaiTroDaoImpl implements PhanCongVaiTroDao{
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
	public void ThemPhanCongVaiTro(Phancongvaitro phancongvaitro) {
		try{
			sessionFactory.getCurrentSession().save(phancongvaitro);
			System.out.println("Them phancongvaitro thanh cong");
		} catch (Exception e) {
			System.out.println("Them phancongvaitro that bai" +e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaPhanCongVaiTro(Phancongvaitro phancongvaitro) {
		try {
			sessionFactory.getCurrentSession().update(phancongvaitro);
			System.out.println("Sua phancongvaitro thanh cong");
		} catch(Exception e) {
			System.out.println("Sua phancongvaitro that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaPhanCongVaiTro(Phancongvaitro phancongvaitro) {
		try {
			sessionFactory.getCurrentSession().delete(phancongvaitro);
			System.out.println("Xoa phancongvaitro thanh cong");
		} catch(Exception e) {
			System.out.println("Xoa phancongvaitro that bai");
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Phancongvaitro> ListPhanCongVaiTro(Integer msdt) {
		List<Phancongvaitro> listPhanCongVaiTro = new ArrayList<Phancongvaitro>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Phancongvaitro WHERE msdt=:msdt");
			listPhanCongVaiTro = query.setInteger("msdt", msdt).list();
		} catch(Exception e) {
			System.out.println("Phancongvaitro: Loi khi lay Phancongvaitro");
		}
		return listPhanCongVaiTro;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Boolean KiemTraTonTaiPhanCongVaiTro(Integer msdt, String taiKhoan, Integer msvt, Integer mscd) {
		boolean ketqua = false;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Phancongvaitro WHERE msdt=:msdt"
					+ " AND nd_taikhoan=:taikhoan AND msvt=:msvt AND mscda=:mscda");
			query.setInteger("msdt", msdt);
			query.setInteger("msvt", msvt);
			query.setInteger("mscda", mscd);
			query.setString("taikhoan", taiKhoan);
			if(query.list().size() > 0) {
				ketqua = true;
			}
		} catch(Exception e) {
			System.out.println("Phancongvaitro: Loi khi lay Phancongvaitro");
		}
		return ketqua;
	}

}
