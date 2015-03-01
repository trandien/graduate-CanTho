// default package
// Generated Jan 31, 2015 7:09:10 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bmt generated by hbm2java
 */
@Entity
@Table(name = "bmt", catalog = "luanvan")
public class Bmt implements java.io.Serializable {

	private Integer bmtid;
	private String ten;
	private Integer trongso;
	private Integer hesobmt;
	private String motabmt;
	private Set usecases = new HashSet(0);

	public Bmt() {
	}

	public Bmt(String ten, Integer trongso, Integer hesobmt, String motabmt,
			Set usecases) {
		this.ten = ten;
		this.trongso = trongso;
		this.hesobmt = hesobmt;
		this.motabmt = motabmt;
		this.usecases = usecases;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BMTID", unique = true, nullable = false)
	public Integer getBmtid() {
		return this.bmtid;
	}

	public void setBmtid(Integer bmtid) {
		this.bmtid = bmtid;
	}

	@Column(name = "TEN", length = 100)
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Column(name = "TRONGSO")
	public Integer getTrongso() {
		return this.trongso;
	}

	public void setTrongso(Integer trongso) {
		this.trongso = trongso;
	}

	@Column(name = "HESOBMT")
	public Integer getHesobmt() {
		return this.hesobmt;
	}

	public void setHesobmt(Integer hesobmt) {
		this.hesobmt = hesobmt;
	}

	@Column(name = "MOTABMT")
	public String getMotabmt() {
		return this.motabmt;
	}

	public void setMotabmt(String motabmt) {
		this.motabmt = motabmt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bmt")
	public Set getUsecases() {
		return this.usecases;
	}

	public void setUsecases(Set usecases) {
		this.usecases = usecases;
	}

}