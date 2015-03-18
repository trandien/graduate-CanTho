package vn.com.luanvan.model;
// Generated Mar 11, 2015 5:37:47 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cautraloi generated by hbm2java
 */
@Entity
@Table(name = "cautraloi", catalog = "tracnghiem")
public class Cautraloi implements java.io.Serializable {

	private CautraloiId id;
	private Cauhoi cauhoi;
	private String ctlNoidung;
	private Set<Hinhanh> hinhanhs = new HashSet<Hinhanh>(0);

	public Cautraloi() {
	}

	public Cautraloi(CautraloiId id, Cauhoi cauhoi, String ctlNoidung) {
		this.id = id;
		this.cauhoi = cauhoi;
		this.ctlNoidung = ctlNoidung;
	}

	public Cautraloi(CautraloiId id, Cauhoi cauhoi, String ctlNoidung,
			Set<Hinhanh> hinhanhs) {
		this.id = id;
		this.cauhoi = cauhoi;
		this.ctlNoidung = ctlNoidung;
		this.hinhanhs = hinhanhs;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "msdt", column = @Column(name = "MSDT", nullable = false, length = 5)),
			@AttributeOverride(name = "msch", column = @Column(name = "MSCH", nullable = false)),
			@AttributeOverride(name = "msctl", column = @Column(name = "MSCTL", nullable = false)) })
	public CautraloiId getId() {
		return this.id;
	}

	public void setId(CautraloiId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "MSDT", referencedColumnName = "MSDT", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "MSCH", referencedColumnName = "MSCH", nullable = false, insertable = false, updatable = false) })
	public Cauhoi getCauhoi() {
		return this.cauhoi;
	}

	public void setCauhoi(Cauhoi cauhoi) {
		this.cauhoi = cauhoi;
	}

	@Column(name = "CTL_NOIDUNG", nullable = false, length = 1000)
	public String getCtlNoidung() {
		return this.ctlNoidung;
	}

	public void setCtlNoidung(String ctlNoidung) {
		this.ctlNoidung = ctlNoidung;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cautraloi")
	public Set<Hinhanh> getHinhanhs() {
		return this.hinhanhs;
	}

	public void setHinhanhs(Set<Hinhanh> hinhanhs) {
		this.hinhanhs = hinhanhs;
	}

}
