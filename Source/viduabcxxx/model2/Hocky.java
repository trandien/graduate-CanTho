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
 * Hocky generated by hbm2java
 */
@Entity
@Table(name = "hocky", catalog = "tracnghiem")
public class Hocky implements java.io.Serializable {

	private int mshk;
	private Set<Dethi> dethis = new HashSet<Dethi>(0);

	public Hocky() {
	}

	public Hocky(int mshk) {
		this.mshk = mshk;
	}

	public Hocky(int mshk, Set<Dethi> dethis) {
		this.mshk = mshk;
		this.dethis = dethis;
	}

	@Id
	@Column(name = "MSHK", unique = true, nullable = false)
	public int getMshk() {
		return this.mshk;
	}

	public void setMshk(int mshk) {
		this.mshk = mshk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hocky")
	public Set<Dethi> getDethis() {
		return this.dethis;
	}

	public void setDethis(Set<Dethi> dethis) {
		this.dethis = dethis;
	}

}
