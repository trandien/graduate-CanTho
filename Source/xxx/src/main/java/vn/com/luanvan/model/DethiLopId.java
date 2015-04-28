package vn.com.luanvan.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DethiLopId generated by hbm2java
 */
@Embeddable
public class DethiLopId implements java.io.Serializable {

	private String msl;
	private int msdt;

	public DethiLopId() {
	}

	public DethiLopId(String msl, int msdt) {
		this.msl = msl;
		this.msdt = msdt;
	}

	@Column(name = "MSL", nullable = false, length = 10)
	public String getMsl() {
		return this.msl;
	}

	public void setMsl(String msl) {
		this.msl = msl;
	}

	@Column(name = "MSDT", nullable = false)
	public int getMsdt() {
		return this.msdt;
	}

	public void setMsdt(int msdt) {
		this.msdt = msdt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DethiLopId))
			return false;
		DethiLopId castOther = (DethiLopId) other;

		return ((this.getMsl() == castOther.getMsl()) || (this.getMsl() != null
				&& castOther.getMsl() != null && this.getMsl().equals(
				castOther.getMsl())))
				&& (this.getMsdt() == castOther.getMsdt());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMsl() == null ? 0 : this.getMsl().hashCode());
		result = 37 * result + this.getMsdt();
		return result;
	}

}

