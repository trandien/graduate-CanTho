package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Cautraloi;

public interface CauTraLoiService {
	void ThemCauTraLoi(Cautraloi CauTraLoi);

	void SuaCauTraLoi(Cautraloi CauTraLoi);

	void XoaCauTraLoi(Cautraloi CauTraLoi);

	List<Cautraloi> LayDSCauTraLoi(Integer maCauHoi);

	Cautraloi LayCauTraLoiByMa(Integer maCauTraLoi);
	
	Integer LayMaxCauTraLoi(Integer maCauHoi);
}
