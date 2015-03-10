// default package
// Generated Mar 10, 2015 9:46:01 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Dokho generated by hbm2java
 */
@Entity
@Table(name = "dokho", catalog = "thitracnghiem")
public class Dokho implements java.io.Serializable {

	private int msdk;
	private String dkTen;
	private Set<Cauhoi> cauhois = new HashSet<Cauhoi>(0);

	public Dokho() {
	}

	public Dokho(int msdk, String dkTen) {
		this.msdk = msdk;
		this.dkTen = dkTen;
	}

	public Dokho(int msdk, String dkTen, Set<Cauhoi> cauhois) {
		this.msdk = msdk;
		this.dkTen = dkTen;
		this.cauhois = cauhois;
	}

	@Id
	@Column(name = "MSDK", unique = true, nullable = false)
	public int getMsdk() {
		return this.msdk;
	}

	public void setMsdk(int msdk) {
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
