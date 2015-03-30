package vn.com.luanvan.model;
// Generated Mar 30, 2015 9:02:58 AM by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Traloi generated by hbm2java
 */
@Entity
@Table(name = "traloi", catalog = "tracnghiem")
public class Traloi implements java.io.Serializable {

	private TraloiId id;
	private Cauhoi cauhoiByMsdt;
	private Cauhoi cauhoiByMsch;
	private User user;
	private float tlDiem;
	private String tlNoidung;

	public Traloi() {
	}

	public Traloi(TraloiId id, Cauhoi cauhoiByMsdt, Cauhoi cauhoiByMsch,
			User user, float tlDiem, String tlNoidung) {
		this.id = id;
		this.cauhoiByMsdt = cauhoiByMsdt;
		this.cauhoiByMsch = cauhoiByMsch;
		this.user = user;
		this.tlDiem = tlDiem;
		this.tlNoidung = tlNoidung;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "msdt", column = @Column(name = "MSDT", nullable = false)),
			@AttributeOverride(name = "msch", column = @Column(name = "MSCH", nullable = false)),
			@AttributeOverride(name = "ndTaikhoan", column = @Column(name = "ND_TAIKHOAN", nullable = false, length = 100)) })
	public TraloiId getId() {
		return this.id;
	}

	public void setId(TraloiId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSDT", nullable = false, insertable = false, updatable = false)
	public Cauhoi getCauhoiByMsdt() {
		return this.cauhoiByMsdt;
	}

	public void setCauhoiByMsdt(Cauhoi cauhoiByMsdt) {
		this.cauhoiByMsdt = cauhoiByMsdt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSCH", nullable = false, insertable = false, updatable = false)
	public Cauhoi getCauhoiByMsch() {
		return this.cauhoiByMsch;
	}

	public void setCauhoiByMsch(Cauhoi cauhoiByMsch) {
		this.cauhoiByMsch = cauhoiByMsch;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ND_TAIKHOAN", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "TL_DIEM", nullable = false, precision = 12, scale = 0)
	public float getTlDiem() {
		return this.tlDiem;
	}

	public void setTlDiem(float tlDiem) {
		this.tlDiem = tlDiem;
	}

	@Column(name = "TL_NOIDUNG", nullable = false)
	public String getTlNoidung() {
		return this.tlNoidung;
	}

	public void setTlNoidung(String tlNoidung) {
		this.tlNoidung = tlNoidung;
	}

}
