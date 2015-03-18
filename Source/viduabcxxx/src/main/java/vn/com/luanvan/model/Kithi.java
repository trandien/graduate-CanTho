package vn.com.luanvan.model;
// Generated Mar 11, 2015 5:37:47 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Kithi generated by hbm2java
 */
@Entity
@Table(name = "kithi", catalog = "tracnghiem")
public class Kithi implements java.io.Serializable {

	private int mskt;
	private Dethi dethi;
	private String ktTen;
	private String ktSolanchophep;

	public Kithi() {
	}

	public Kithi(int mskt, Dethi dethi, String ktTen) {
		this.mskt = mskt;
		this.dethi = dethi;
		this.ktTen = ktTen;
	}

	public Kithi(int mskt, Dethi dethi, String ktTen, String ktSolanchophep) {
		this.mskt = mskt;
		this.dethi = dethi;
		this.ktTen = ktTen;
		this.ktSolanchophep = ktSolanchophep;
	}

	@Id
	@Column(name = "MSKT", unique = true, nullable = false)
	public int getMskt() {
		return this.mskt;
	}

	public void setMskt(int mskt) {
		this.mskt = mskt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSDT", nullable = false)
	public Dethi getDethi() {
		return this.dethi;
	}

	public void setDethi(Dethi dethi) {
		this.dethi = dethi;
	}

	@Column(name = "KT_TEN", nullable = false, length = 20)
	public String getKtTen() {
		return this.ktTen;
	}

	public void setKtTen(String ktTen) {
		this.ktTen = ktTen;
	}

	@Column(name = "KT_SOLANCHOPHEP", length = 10)
	public String getKtSolanchophep() {
		return this.ktSolanchophep;
	}

	public void setKtSolanchophep(String ktSolanchophep) {
		this.ktSolanchophep = ktSolanchophep;
	}

}
