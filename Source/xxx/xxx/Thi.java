// default package
// Generated Apr 30, 2015 9:49:25 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Thi generated by hbm2java
 */
@Entity
@Table(name = "thi", catalog = "tracnghiem")
public class Thi implements java.io.Serializable {

	private Integer mst;
	private Dethi dethi;
	private User user;
	private Integer solanthi;
	private Integer TSocaudung;
	private Integer TTongsocau;
	private Boolean TKhoabailam;
	private Date TNgaylam;
	private float TDiem;

	public Thi() {
	}

	public Thi(Dethi dethi, User user, float TDiem) {
		this.dethi = dethi;
		this.user = user;
		this.TDiem = TDiem;
	}

	public Thi(Dethi dethi, User user, Integer solanthi, Integer TSocaudung,
			Integer TTongsocau, Boolean TKhoabailam, Date TNgaylam, float TDiem) {
		this.dethi = dethi;
		this.user = user;
		this.solanthi = solanthi;
		this.TSocaudung = TSocaudung;
		this.TTongsocau = TTongsocau;
		this.TKhoabailam = TKhoabailam;
		this.TNgaylam = TNgaylam;
		this.TDiem = TDiem;
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

	@Column(name = "T_TONGSOCAU")
	public Integer getTTongsocau() {
		return this.TTongsocau;
	}

	public void setTTongsocau(Integer TTongsocau) {
		this.TTongsocau = TTongsocau;
	}

	@Column(name = "T_KHOABAILAM")
	public Boolean getTKhoabailam() {
		return this.TKhoabailam;
	}

	public void setTKhoabailam(Boolean TKhoabailam) {
		this.TKhoabailam = TKhoabailam;
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
