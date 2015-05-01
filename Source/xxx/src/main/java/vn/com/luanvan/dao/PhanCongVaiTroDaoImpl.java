package vn.com.luanvan.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import vn.com.luanvan.model.User;

@Repository("phanCongVaiTroDao")
public class PhanCongVaiTroDaoImpl implements PhanCongVaiTroDao {
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
		try {
			sessionFactory.getCurrentSession().save(phancongvaitro);
			System.out.println("Them phan cong vai tro thanh cong");
		} catch (Exception e) {
			System.out.println("Them phancongvaitro that bai" + e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void SuaPhanCongVaiTro(Phancongvaitro phancongvaitro) {
		try {
			sessionFactory.getCurrentSession().update(phancongvaitro);
			System.out.println("Sua phancongvaitro thanh cong");
		} catch (Exception e) {
			System.out.println("Sua phancongvaitro that bai");
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void XoaPhanCongVaiTro(Phancongvaitro phancongvaitro) {
		try {
			sessionFactory.getCurrentSession().delete(phancongvaitro);
			System.out.println("Xoa phancongvaitro thanh cong");
		} catch (Exception e) {
			System.out.println("Xoa phancongvaitro that bai");
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Phancongvaitro> ListPhanCongVaiTro(Integer msdt) {
		List<Phancongvaitro> listPhanCongVaiTro = new ArrayList<Phancongvaitro>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from Phancongvaitro WHERE msdt=:msdt");
			listPhanCongVaiTro = query.setInteger("msdt", msdt).list();
		} catch (Exception e) {
			System.out.println("Phancongvaitro: Loi khi lay Phancongvaitro");
		}
		return listPhanCongVaiTro;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Boolean KiemTraTonTaiPhanCongVaiTro(Integer msdt, String taiKhoan,
			Integer msvt, Integer mscd) {
		boolean ketqua = false;
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Phancongvaitro pcvt WHERE pcvt.dethi.msdt=:msdt"
									+ " AND pcvt.user.nd_taikhoan=:taikhoan AND pcvt.vaitro.msvt=:msvt AND mscda=:mscda");
			query.setInteger("msdt", msdt);
			query.setInteger("msvt", msvt);
			query.setInteger("mscda", mscd);
			query.setString("taikhoan", taiKhoan);
			if (query.list().size() > 0) {
				ketqua = true;
			}
		} catch (Exception e) {
			System.out.println("Phancongvaitro: Loi khi lay Phancongvaitro");
		}
		return ketqua;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer getMaxIdByMaDeThi(Integer msdt) {
		int ketQua = 0;
		try {
			Query query = sessionFactory.getCurrentSession().createSQLQuery(
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
			PhanCongVaiTro = (Phancongvaitro) sessionFactory
					.getCurrentSession().get(Phancongvaitro.class, mspcvt);

		} catch (Exception e) {
			System.out.println("LayPhanCongVaiTroByMa: Loi");
		}
		return PhanCongVaiTro;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Phancongvaitro> LayDeThiHS(String taiKhoan) {
		List<Phancongvaitro> ListDeThiHS = new ArrayList<Phancongvaitro>();
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Phancongvaitro pcvt WHERE pcvt.user.ndTaikhoan=:taikhoan AND pcvt.vaitro.msvt=4");
			ListDeThiHS = query.setParameter("taikhoan", taiKhoan).list();
		} catch (Exception e) {
			System.out.println("LayDeThiHS: Loi " + e.getMessage());
		}
		return ListDeThiHS;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Phancongvaitro> LayDeThiGiamThi(String taiKhoan) {
		List<Phancongvaitro> ListDeThiGiamThi = new ArrayList<Phancongvaitro>();
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Phancongvaitro pcvt WHERE pcvt.user.ndTaikhoan=:taikhoan AND pcvt.vaitro.msvt=3");
			ListDeThiGiamThi = query.setParameter("taikhoan", taiKhoan).list();
		} catch (Exception e) {
			System.out.println("LayDeThiGiamthi: Loi ");
		}
		return ListDeThiGiamThi;
	}

	@Override
	public Integer SLPCVTGiamThi(int msdt) {
		Integer ketQua = 0;
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"select count(*) from Phancongvaitro pcvt WHERE pcvt.dethi.msdt=:msdt AND pcvt.vaitro.msvt=3");
			query.setParameter("msdt", msdt);
			return ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le SLPCVTGiamThi : "
					+ e.getMessage());
		}
		return ketQua;
	}

	@Override
	public Integer SLPCVTHS(int msdt) {
		Integer ketQua = 0;
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"select count(*) from Phancongvaitro pcvt WHERE pcvt.dethi.msdt=:msdt AND pcvt.vaitro.msvt=4");
			query.setParameter("msdt", msdt);
			return ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			System.out.println("Xay ra ngoai le SLPCVTHS : " + e.getMessage());
		}
		return ketQua;
	}

	@Override
	public List<Phancongvaitro> layDSHSByNgayVaPhong(int mspt, String ngay,
			String gioBatDau, String gioKetThuc) throws ParseException {
		List<Phancongvaitro> listPCVT = new ArrayList<Phancongvaitro>(); 
		SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("yyyy-MM-dd");
		Date layNgay = dinhDangThoiGian.parse(ngay);
		SimpleDateFormat time = new SimpleDateFormat("hh:mm");
		Date layGioBatDau = time.parse(gioBatDau);
		Date layGioKetThuc = time.parse(gioKetThuc);
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Phancongvaitro pcvt WHERE pcvt.phongthi.mspt=:mspt AND ngay=:ngay AND giobatdau=:giobatdau AND gioketthuc=:gioketthuc AND pcvt.vaitro.msvt=4");
			query.setParameter("mspt", mspt);
			query.setParameter("ngay", layNgay);
			query.setParameter("giobatdau", layGioBatDau);
			query.setParameter("gioketthuc", layGioKetThuc);
			listPCVT = query.list();
		} catch (Exception e) {
			System.out.println("layDSHSByNgayVaPhong: Loi ");
		}
		return listPCVT;
	}

	@Override
	public List<Phancongvaitro> ListHSByMSDT(int msdt) {
		List<Phancongvaitro> ListDeThiGiamThi = new ArrayList<Phancongvaitro>();
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Phancongvaitro pcvt WHERE pcvt.dethi.msdt=:msdt AND pcvt.vaitro.msvt=4");
			ListDeThiGiamThi = query.setParameter("msdt", msdt).list();
		} catch (Exception e) {
			System.out.println("ListHSByMSDT: Loi ");
		}
		return ListDeThiGiamThi;
	}

	@Override
	public List<Phancongvaitro> ListGTByMSDT(int msdt) {
		List<Phancongvaitro> ListDeThiGiamThi = new ArrayList<Phancongvaitro>();
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Phancongvaitro pcvt WHERE pcvt.dethi.msdt=:msdt AND pcvt.vaitro.msvt=3");
			ListDeThiGiamThi = query.setParameter("msdt", msdt).list();
		} catch (Exception e) {
			System.out.println("ListGTByMSDT: Loi ");
		}
		return ListDeThiGiamThi;
	}

}
