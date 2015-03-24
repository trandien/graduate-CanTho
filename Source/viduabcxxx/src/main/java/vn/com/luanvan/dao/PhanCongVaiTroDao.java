package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Phancongvaitro;

public interface PhanCongVaiTroDao {
	void ThemPhanCongVaiTro(Phancongvaitro phancongvaitro);

	void SuaPhanCongVaiTro(Phancongvaitro phancongvaitro);

	void XoaPhanCongVaiTro(Phancongvaitro phancongvaitro);

	List<Phancongvaitro> ListPhanCongVaiTro(Integer msdt);
	
	Boolean KiemTraTonTaiPhanCongVaiTro(Integer msdt, String taiKhoan, Integer msvt, Integer mscd);
}
