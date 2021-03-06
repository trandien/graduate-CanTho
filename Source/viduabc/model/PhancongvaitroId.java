// default package
// Generated Mar 10, 2015 9:46:01 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PhancongvaitroId generated by hbm2java
 */
@Embeddable
public class PhancongvaitroId implements java.io.Serializable {

	private String msdt;
	private String ndTaikhoan;
	private int msvt;

	public PhancongvaitroId() {
	}

	public PhancongvaitroId(String msdt, String ndTaikhoan, int msvt) {
		this.msdt = msdt;
		this.ndTaikhoan = ndTaikhoan;
		this.msvt = msvt;
	}

	@Column(name = "MSDT", nullable = false, length = 5)
	public String getMsdt() {
		return this.msdt;
	}

	public void setMsdt(String msdt) {
		this.msdt = msdt;
	}

	@Column(name = "ND_TAIKHOAN", nullable = false, length = 10)
	public String getNdTaikhoan() {
		return this.ndTaikhoan;
	}

	public void setNdTaikhoan(String ndTaikhoan) {
		this.ndTaikhoan = ndTaikhoan;
	}

	@Column(name = "MSVT", nullable = false)
	public int getMsvt() {
		return this.msvt;
	}

	public void setMsvt(int msvt) {
		this.msvt = msvt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PhancongvaitroId))
			return false;
		PhancongvaitroId castOther = (PhancongvaitroId) other;

		return ((this.getMsdt() == castOther.getMsdt()) || (this.getMsdt() != null
				&& castOther.getMsdt() != null && this.getMsdt().equals(
				castOther.getMsdt())))
				&& ((this.getNdTaikhoan() == castOther.getNdTaikhoan()) || (this
						.getNdTaikhoan() != null
						&& castOther.getNdTaikhoan() != null && this
						.getNdTaikhoan().equals(castOther.getNdTaikhoan())))
				&& (this.getMsvt() == castOther.getMsvt());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMsdt() == null ? 0 : this.getMsdt().hashCode());
		result = 37
				* result
				+ (getNdTaikhoan() == null ? 0 : this.getNdTaikhoan()
						.hashCode());
		result = 37 * result + this.getMsvt();
		return result;
	}

}
