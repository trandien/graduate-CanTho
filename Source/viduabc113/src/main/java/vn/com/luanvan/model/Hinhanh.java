package vn.com.luanvan.model;
// Generated Mar 11, 2015 5:37:47 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Hinhanh generated by hbm2java
 */
@Entity
@Table(name = "hinhanh", catalog = "tracnghiem")
public class Hinhanh implements java.io.Serializable {

	private int msha;
	private Cauhoi cauhoi;
	private Cautraloi cautraloi;
	private byte[] haNoidung;

	public Hinhanh() {
	}

	public Hinhanh(int msha, Cauhoi cauhoi, Cautraloi cautraloi,
			byte[] haNoidung) {
		this.msha = msha;
		this.cauhoi = cauhoi;
		this.cautraloi = cautraloi;
		this.haNoidung = haNoidung;
	}

	@Id
	@Column(name = "MSHA", unique = true, nullable = false)
	public int getMsha() {
		return this.msha;
	}

	public void setMsha(int msha) {
		this.msha = msha;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "MSDT", referencedColumnName = "MSDT", nullable = false),
			@JoinColumn(name = "MSCH", referencedColumnName = "MSCH", nullable = false) })
	public Cauhoi getCauhoi() {
		return this.cauhoi;
	}

	public void setCauhoi(Cauhoi cauhoi) {
		this.cauhoi = cauhoi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "MSDT", referencedColumnName = "MSDT", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "MSCH", referencedColumnName = "MSCH", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "MSCTL", referencedColumnName = "MSCTL", nullable = false, insertable = false, updatable = false) })
	public Cautraloi getCautraloi() {
		return this.cautraloi;
	}

	public void setCautraloi(Cautraloi cautraloi) {
		this.cautraloi = cautraloi;
	}

	@Column(name = "HA_NOIDUNG", nullable = false)
	public byte[] getHaNoidung() {
		return this.haNoidung;
	}

	public void setHaNoidung(byte[] haNoidung) {
		this.haNoidung = haNoidung;
	}

}