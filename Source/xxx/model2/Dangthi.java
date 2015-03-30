package vn.com.luanvan.model;
// Generated Mar 19, 2015 8:01:06 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Dangthi generated by hbm2java
 */
@Entity
@Table(name = "dangthi", catalog = "tracnghiem")
public class Dangthi implements java.io.Serializable {

	private int msdangthi;
	private String dtTen;
	private int dtHeso;
	private Set<Dethi> dethis = new HashSet<Dethi>(0);

	public Dangthi() {
	}

	public Dangthi(int msdangthi, String dtTen, int dtHeso) {
		this.msdangthi = msdangthi;
		this.dtTen = dtTen;
		this.dtHeso = dtHeso;
	}

	public Dangthi(int msdangthi, String dtTen, int dtHeso, Set<Dethi> dethis) {
		this.msdangthi = msdangthi;
		this.dtTen = dtTen;
		this.dtHeso = dtHeso;
		this.dethis = dethis;
	}

	@Id
	@Column(name = "MSDANGTHI", unique = true, nullable = false)
	public int getMsdangthi() {
		return this.msdangthi;
	}

	public void setMsdangthi(int msdangthi) {
		this.msdangthi = msdangthi;
	}

	@Column(name = "DT_TEN", nullable = false, length = 20)
	public String getDtTen() {
		return this.dtTen;
	}

	public void setDtTen(String dtTen) {
		this.dtTen = dtTen;
	}

	@Column(name = "DT_HESO", nullable = false)
	public int getDtHeso() {
		return this.dtHeso;
	}

	public void setDtHeso(int dtHeso) {
		this.dtHeso = dtHeso;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dangthi")
	public Set<Dethi> getDethis() {
		return this.dethis;
	}

	public void setDethis(Set<Dethi> dethis) {
		this.dethis = dethis;
	}

}
