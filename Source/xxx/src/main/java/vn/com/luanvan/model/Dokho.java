package vn.com.luanvan.model;
// Generated Mar 30, 2015 9:02:58 AM by Hibernate Tools 4.3.1

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
 * Dokho generated by hbm2java
 */
@Entity
@Table(name = "dokho", catalog = "tracnghiem")
public class Dokho implements java.io.Serializable {

	private Integer msdk;
	private String dkTen;
	private Set<Cauhoi> cauhois = new HashSet<Cauhoi>(0);

	public Dokho() {
	}

	public Dokho(String dkTen) {
		this.dkTen = dkTen;
	}

	public Dokho(String dkTen, Set<Cauhoi> cauhois) {
		this.dkTen = dkTen;
		this.cauhois = cauhois;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MSDK", unique = true, nullable = false)
	public Integer getMsdk() {
		return this.msdk;
	}

	public void setMsdk(Integer msdk) {
		this.msdk = msdk;
	}

	@Column(name = "DK_TEN", nullable = false, length = 100)
	public String getDkTen() {
		return this.dkTen;
	}

	public void setDkTen(String dkTen) {
		this.dkTen = dkTen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dokho")
	public Set<Cauhoi> getCauhois() {
		return this.cauhois;
	}

	public void setCauhois(Set<Cauhoi> cauhois) {
		this.cauhois = cauhois;
	}

}
