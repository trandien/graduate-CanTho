package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Dangthi;
import vn.com.luanvan.model.Monhoc;

public interface DangThiDao {
	List<Dangthi> DSDangThi();
	
	Dangthi TimDangThiByMa(int maDangThi);
}
