package vn.com.luanvan.dao;

import java.text.ParseException;
import java.util.List;

import vn.com.luanvan.model.Phancongvaitro;
import vn.com.luanvan.model.User;

public interface PhanCongVaiTroDao {
	void ThemPhanCongVaiTro(Phancongvaitro phancongvaitro);

	void SuaPhanCongVaiTro(Phancongvaitro phancongvaitro);

	void XoaPhanCongVaiTro(Phancongvaitro phancongvaitro);

	List<Phancongvaitro> ListPhanCongVaiTro(Integer msdt);
	
	List<Phancongvaitro> LayDeThiHS(String taiKhoan);
	
	List<Phancongvaitro> LayDeThiGiamThi(String taiKhoan);
	
	Boolean KiemTraTonTaiPhanCongVaiTro(Integer msdt, String taiKhoan, Integer msvt, Integer mscd);
	
	Integer getMaxIdByMaDeThi(Integer msdt);
	
	Phancongvaitro LayPhanCongVaiTroByMa(Integer mspcvt);
	
	Integer SLPCVTGiamThi(int msdt);
	
	Integer SLPCVTHS(int msdt);
	
	List<Phancongvaitro> layDSHSByNgayVaPhong(int mspt, String ngay, String gioBatDau, String gioKetThuc) throws ParseException ;
}
