package vn.com.luanvan.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "thi", catalog = "tracnghiem")
public class Thi implements java.io.Serializable {

	private Integer mst;
	private Dethi dethi;
	private User user;
	private Integer solanthi;
	private Integer TSocaudung;
	private Boolean TKhoabailam;
	private Date TNgaylam;
	private Integer TTongsocau;
	private float TDiem;

	public Thi() {
	}

	public Thi(Dethi dethi, User user, float TDiem) {
		this.dethi = dethi;
		this.user = user;
		this.TDiem = TDiem;
	}

	public Thi(Dethi dethi, User user, Integer solanthi, Integer TSocaudung,
			Boolean TKhoabailam, Date TNgaylam, float TDiem, Integer TTongsocau) {
		this.dethi = dethi;
		this.user = user;
		this.solanthi = solanthi;
		this.TSocaudung = TSocaudung;
		this.TKhoabailam = TKhoabailam;
		this.TNgaylam = TNgaylam;
		this.TDiem = TDiem;
		this.TTongsocau = TTongsocau;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MST", unique = true, nullable = false)
	public Integer getMst() {
		return this.mst;
	}

	public void setMst(Integer mst) {
		this.mst = mst;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSDT", nullable = false)
	public Dethi getDethi() {
		return this.dethi;
	}

	public void setDethi(Dethi dethi) {
		this.dethi = dethi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ND_TAIKHOAN", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "SOLANTHI")
	public Integer getSolanthi() {
		return this.solanthi;
	}

	public void setSolanthi(Integer solanthi) {
		this.solanthi = solanthi;
	}

	@Column(name = "T_SOCAUDUNG")
	public Integer getTSocaudung() {
		return this.TSocaudung;
	}

	public void setTSocaudung(Integer TSocaudung) {
		this.TSocaudung = TSocaudung;
	}

	@Column(name = "T_KHOABAILAM")
	public Boolean getTKhoabailam() {
		return this.TKhoabailam;
	}

	public void setTKhoabailam(Boolean TKhoabailam) {
		this.TKhoabailam = TKhoabailam;
	}
	
	@Column(name = "T_TONGSOCAU")
	public Integer getTTongsocau() {
		return this.TTongsocau;
	}

	public void setTTongsocau(Integer TTongsocau) {
		this.TTongsocau = TTongsocau;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "T_NGAYLAM", length = 0)
	public Date getTNgaylam() {
		return this.TNgaylam;
	}

	public void setTNgaylam(Date TNgaylam) {
		this.TNgaylam = TNgaylam;
	}


	@Column(name = "T_DIEM", nullable = false, precision = 12, scale = 0)
	public float getTDiem() {
		return this.TDiem;
	}

	public void setTDiem(float TDiem) {
		this.TDiem = TDiem;
	}

}
