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
 * Kithi generated by hbm2java
 */
@Entity
@Table(name = "kithi", catalog = "thitracnghiem")
public class Kithi implements java.io.Serializable {

	private int mskt;
	private String ktTen;
	private Integer ktSolanchophep;
	private Set<Dethi> dethis = new HashSet<Dethi>(0);

	public Kithi() {
	}

	public Kithi(int mskt, String ktTen) {
		this.mskt = mskt;
		this.ktTen = ktTen;
	}

	public Kithi(int mskt, String ktTen, Integer ktSolanchophep,
			Set<Dethi> dethis) {
		this.mskt = mskt;
		this.ktTen = ktTen;
		this.ktSolanchophep = ktSolanchophep;
		this.dethis = dethis;
	}

	@Id
	@Column(name = "MSKT", unique = true, nullable = false)
	public int getMskt() {
		return this.mskt;
	}

	public void setMskt(int mskt) {
		this.mskt = mskt;
	}

	@Column(name = "KT_TEN", nullable = false, length = 20)
	public String getKtTen() {
		return this.ktTen;
	}

	public void setKtTen(String ktTen) {
		this.ktTen = ktTen;
	}

	@Column(name = "KT_SOLANCHOPHEP")
	public Integer getKtSolanchophep() {
		return this.ktSolanchophep;
	}

	public void setKtSolanchophep(Integer ktSolanchophep) {
		this.ktSolanchophep = ktSolanchophep;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kithi")
	public Set<Dethi> getDethis() {
		return this.dethis;
	}

	public void setDethis(Set<Dethi> dethis) {
		this.dethis = dethis;
	}

}
