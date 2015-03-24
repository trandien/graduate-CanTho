package vn.com.luanvan.model;
// Generated Mar 19, 2015 8:01:06 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CauhoiId generated by hbm2java
 */
@Embeddable
public class CauhoiId implements java.io.Serializable {

	private int msdt;
	private int msch;

	public CauhoiId() {
	}

	public CauhoiId(int msdt, int msch) {
		this.msdt = msdt;
		this.msch = msch;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CauhoiId))
			return false;
		CauhoiId castOther = (CauhoiId) other;

		return (this.getMsdt() == castOther.getMsdt())
				&& (this.getMsch() == castOther.getMsch());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMsdt();
		result = 37 * result + this.getMsch();
		return result;
	}

}