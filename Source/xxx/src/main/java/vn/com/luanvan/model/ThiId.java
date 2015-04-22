package vn.com.luanvan.model;
// Generated Mar 30, 2015 9:02:58 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ThiId generated by hbm2java
 */
@Embeddable
public class ThiId implements java.io.Serializable {

	private String ndTaikhoan;
	private int msdt;
	private int lanthi;

	public ThiId() {
	}

	public ThiId(String ndTaikhoan, int msdt, int lanthi) {
		this.ndTaikhoan = ndTaikhoan;
		this.msdt = msdt;
		this.lanthi = lanthi;
	}

	@Column(name = "ND_TAIKHOAN", nullable = false, length = 100)
	public String getNdTaikhoan() {
		return this.ndTaikhoan;
	}

	public void setNdTaikhoan(String ndTaikhoan) {
		this.ndTaikhoan = ndTaikhoan;
	}

	@Column(name = "MSDT", nullable = false)
	public int getMsdt() {
		return this.msdt;
	}

	public void setMsdt(int msdt) {
		this.msdt = msdt;
	}

	@Column(name = "lanthi", nullable = false)
	public int getLanthi() {
		return this.lanthi;
	}

	public void setLanthi(int lanthi) {
		this.lanthi = lanthi;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ThiId))
			return false;
		ThiId castOther = (ThiId) other;

		return ((this.getNdTaikhoan() == castOther.getNdTaikhoan()) || (this
				.getNdTaikhoan() != null && castOther.getNdTaikhoan() != null && this
				.getNdTaikhoan().equals(castOther.getNdTaikhoan())))
				&& (this.getMsdt() == castOther.getMsdt())
				&& (this.getLanthi() == castOther.getLanthi());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNdTaikhoan() == null ? 0 : this.getNdTaikhoan()
						.hashCode());
		result = 37 * result + this.getMsdt();
		result = 37 * result + this.getLanthi();
		return result;
	}

}
