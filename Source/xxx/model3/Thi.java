// default package
// Generated Apr 22, 2015 4:57:38 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	private ThiId id;
	private Dethi dethi;
	private Phongthi phongthi;
	private User user;
	private boolean TDanhdau;
	private boolean TKhoabailam;
	private Date TNgaylam;
	private Date TThoigianbatdau;
	private Date TThoigianketthuc;
	private float TDiem;

	public Thi() {
	}

	public Thi(ThiId id, Dethi dethi, Phongthi phongthi, User user,
			boolean TDanhdau, boolean TKhoabailam, Date TNgaylam,
			Date TThoigianbatdau, Date TThoigianketthuc, float TDiem) {
		this.id = id;
		this.dethi = dethi;
		this.phongthi = phongthi;
		this.user = user;
		this.TDanhdau = TDanhdau;
		this.TKhoabailam = TKhoabailam;
		this.TNgaylam = TNgaylam;
		this.TThoigianbatdau = TThoigianbatdau;
		this.TThoigianketthuc = TThoigianketthuc;
		this.TDiem = TDiem;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "ndTaikhoan", column = @Column(name = "ND_TAIKHOAN", nullable = false, length = 100)),
			@AttributeOverride(name = "msdt", column = @Column(name = "MSDT", nullable = false)),
			@AttributeOverride(name = "lanthi", column = @Column(name = "lanthi", nullable = false)) })
	public ThiId getId() {
		return this.id;
	}

	public void setId(ThiId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSDT", nullable = false, insertable = false, updatable = false)
	public Dethi getDethi() {
		return this.dethi;
	}

	public void setDethi(Dethi dethi) {
		this.dethi = dethi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSPT", nullable = false)
	public Phongthi getPhongthi() {
		return this.phongthi;
	}

	public void setPhongthi(Phongthi phongthi) {
		this.phongthi = phongthi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ND_TAIKHOAN", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "T_DANHDAU", nullable = false)
	public boolean isTDanhdau() {
		return this.TDanhdau;
	}

	public void setTDanhdau(boolean TDanhdau) {
		this.TDanhdau = TDanhdau;
	}

	@Column(name = "T_KHOABAILAM", nullable = false)
	public boolean isTKhoabailam() {
		return this.TKhoabailam;
	}

	public void setTKhoabailam(boolean TKhoabailam) {
		this.TKhoabailam = TKhoabailam;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "T_NGAYLAM", nullable = false, length = 0)
	public Date getTNgaylam() {
		return this.TNgaylam;
	}

	public void setTNgaylam(Date TNgaylam) {
		this.TNgaylam = TNgaylam;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "T_THOIGIANBATDAU", nullable = false, length = 0)
	public Date getTThoigianbatdau() {
		return this.TThoigianbatdau;
	}

	public void setTThoigianbatdau(Date TThoigianbatdau) {
		this.TThoigianbatdau = TThoigianbatdau;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "T_THOIGIANKETTHUC", nullable = false, length = 0)
	public Date getTThoigianketthuc() {
		return this.TThoigianketthuc;
	}

	public void setTThoigianketthuc(Date TThoigianketthuc) {
		this.TThoigianketthuc = TThoigianketthuc;
	}

	@Column(name = "T_DIEM", nullable = false, precision = 12, scale = 0)
	public float getTDiem() {
		return this.TDiem;
	}

	public void setTDiem(float TDiem) {
		this.TDiem = TDiem;
	}

}
