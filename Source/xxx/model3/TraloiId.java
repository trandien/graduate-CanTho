// default package
// Generated Apr 23, 2015 5:07:01 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TraloiId generated by hbm2java
 */
@Embeddable
public class TraloiId implements java.io.Serializable {

	private int msdt;
	private int msch;
	private String ndTaikhoan;

	public TraloiId() {
	}

	public TraloiId(int msdt, int msch, String ndTaikhoan) {
		this.msdt = msdt;
		this.msch = msch;
		this.ndTaikhoan = ndTaikhoan;
	}

	@Column(name = "MSDT", nullable = false)
	public int getMsdt() {
		return this.msdt;
	}

	public void setMsdt(int msdt) {
		this.msdt = msdt;
	}

	@Column(name = "MSCH", nullable = false)
	public int getMsch() {
		return this.msch;
	}

	public void setMsch(int msch) {
		this.msch = msch;
	}

	@Column(name = "ND_TAIKHOAN", nullable = false, length = 100)
	public String getNdTaikhoan() {
		return this.ndTaikhoan;
	}

	public void setNdTaikhoan(String ndTaikhoan) {
		this.ndTaikhoan = ndTaikhoan;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TraloiId))
			return false;
		TraloiId castOther = (TraloiId) other;

		return (this.getMsdt() == castOther.getMsdt())
				&& (this.getMsch() == castOther.getMsch())
				&& ((this.getNdTaikhoan() == castOther.getNdTaikhoan()) || (this
						.getNdTaikhoan() != null
						&& castOther.getNdTaikhoan() != null && this
						.getNdTaikhoan().equals(castOther.getNdTaikhoan())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMsdt();
		result = 37 * result + this.getMsch();
		result = 37
				* result
				+ (getNdTaikhoan() == null ? 0 : this.getNdTaikhoan()
						.hashCode());
		return result;
	}

}
