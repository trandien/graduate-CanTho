package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Cautraloi;

public interface CauTraLoiDao {
	void ThemCauTraLoi(Cautraloi CauTraLoi);

	void SuaCauTraLoi(Cautraloi CauTraLoi);

	void XoaCauTraLoi(Cautraloi CauTraLoi);

	List<Cautraloi> LayDSCauTraLoi(Integer maCauHoi);

	Cautraloi LayCauTraLoiByMa(Integer maCauTraLoi);
	
	Integer LayMaxCauTraLoi(Integer maCauHoi);
	
	List<Integer> ListIdCauTraLoi(Integer maCauHoi);
	
	void ResetMaxIdCTL(Integer maCauHoi);
}
