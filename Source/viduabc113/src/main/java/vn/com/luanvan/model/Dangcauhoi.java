package vn.com.luanvan.model;
// Generated Mar 11, 2015 5:37:47 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Dangcauhoi generated by hbm2java
 */
@Entity
@Table(name = "dangcauhoi", catalog = "tracnghiem")
public class Dangcauhoi implements java.io.Serializable {

	private int msdch;
	private String dchTen;
	private Set<Cauhoi> cauhois = new HashSet<Cauhoi>(0);

	public Dangcauhoi() {
	}

	public Dangcauhoi(int msdch, String dchTen) {
		this.msdch = msdch;
		this.dchTen = dchTen;
	}

	public Dangcauhoi(int msdch, String dchTen, Set<Cauhoi> cauhois) {
		this.msdch = msdch;
		this.dchTen = dchTen;
		this.cauhois = cauhois;
	}

	@Id
	@Column(name = "MSDCH", unique = true, nullable = false)
	public int getMsdch() {
		return this.msdch;
	}

	public void setMsdch(int msdch) {
		this.msdch = msdch;
	}

	@Column(name = "DCH_TEN", nullable = false, length = 100)
	public String getDchTen() {
		return this.dchTen;
	}

	public void setDchTen(String dchTen) {
		this.dchTen = dchTen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dangcauhoi")
	public Set<Cauhoi> getCauhois() {
		return this.cauhois;
	}

	public void setCauhois(Set<Cauhoi> cauhois) {
		this.cauhois = cauhois;
	}

}
