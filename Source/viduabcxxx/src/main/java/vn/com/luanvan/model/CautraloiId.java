package vn.com.luanvan.model;
// Generated Mar 19, 2015 8:01:06 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CautraloiId generated by hbm2java
 */
@Embeddable
public class CautraloiId implements java.io.Serializable {

	private int msdt;
	private int msch;
	private int msctl;

	public CautraloiId() {
	}

	public CautraloiId(int msdt, int msch, int msctl) {
		this.msdt = msdt;
		this.msch = msch;
		this.msctl = msctl;
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

	@Column(name = "MSCTL", nullable = false)
	public int getMsctl() {
		return this.msctl;
	}

	public void setMsctl(int msctl) {
		this.msctl = msctl;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CautraloiId))
			return false;
		CautraloiId castOther = (CautraloiId) other;

		return (this.getMsdt() == castOther.getMsdt())
				&& (this.getMsch() == castOther.getMsch())
				&& (this.getMsctl() == castOther.getMsctl());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMsdt();
		result = 37 * result + this.getMsch();
		result = 37 * result + this.getMsctl();
		return result;
	}

}