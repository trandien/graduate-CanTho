package vn.com.luanvan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.luanvan.model.Cauhoi;
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
			System.out.println("Them phan cong vai tro thanh cong");
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
			Query query = sessionFactory.getCurrentSession().createQuery("from Phancongvaitro pcvt WHERE pcvt.dethi.msdt=:msdt"
					+ " AND pcvt.user.nd_taikhoan=:taikhoan AND pcvt.vaitro.msvt=:msvt AND mscda=:mscda");
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

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer getMaxIdByMaDeThi(Integer msdt) {
		int ketQua = 0;
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(
							"select max(mspcvt) from Phancongvaitro WHERE msdt=:msdt");
			query.setParameter("msdt", msdt);
			ketQua = (Integer) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("getMaxIdByMaDeThi: xay ra loi");
		}
		return ketQua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Phancongvaitro LayPhanCongVaiTroByMa(Integer mspcvt) {
		Phancongvaitro PhanCongVaiTro = new Phancongvaitro();
		try {
			PhanCongVaiTro = (Phancongvaitro) sessionFactory.getCurrentSession().get(
					Phancongvaitro.class, mspcvt);
			
		} catch (Exception e) {
			System.out.println("LayPhanCongVaiTroByMa: Loi");
		}
		return PhanCongVaiTro;
	}

}
