package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Dangthi;

public interface DangThiService {
	List<Dangthi> DSDangThi();
	
	Dangthi TimDangThiByMa(int maDangThi);
}
