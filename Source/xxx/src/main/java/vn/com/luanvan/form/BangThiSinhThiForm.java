package vn.com.luanvan.form;

public class BangThiSinhThiForm {
	private Integer msch;
	private String dapAnDaChon;
	private String dapAnDung;
	private float Diem;

	public BangThiSinhThiForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BangThiSinhThiForm(Integer msch, String dapAnDaChon,
			String dapAnDung, float diem) {
		super();
		this.msch = msch;
		this.dapAnDaChon = dapAnDaChon;
		this.dapAnDung = dapAnDung;
		Diem = diem;
	}

	public Integer getMsch() {
		return msch;
	}

	public void setMsch(Integer msch) {
		this.msch = msch;
	}

	public String getDapAnDaChon() {
		return dapAnDaChon;
	}

	public void setDapAnDaChon(String dapAnDaChon) {
		this.dapAnDaChon = dapAnDaChon;
	}

	public String getDapAnDung() {
		return dapAnDung;
	}

	public void setDapAnDung(String dapAnDung) {
		this.dapAnDung = dapAnDung;
	}

	public float getDiem() {
		return Diem;
	}

	public void setDiem(float diem) {
		Diem = diem;
	}

}
