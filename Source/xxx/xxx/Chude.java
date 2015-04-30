// default package
// Generated Apr 30, 2015 9:49:25 AM by Hibernate Tools 4.3.1

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
 * Chude generated by hbm2java
 */
@Entity
@Table(name = "chude", catalog = "tracnghiem")
public class Chude implements java.io.Serializable {

	private Integer mscd;
	private String ndTaikhoan;
	private String cdTen;
	private Set<Dethi> dethis = new HashSet<Dethi>(0);

	public Chude() {
	}

	public Chude(String cdTen) {
		this.cdTen = cdTen;
	}

	public Chude(String ndTaikhoan, String cdTen, Set<Dethi> dethis) {
		this.ndTaikhoan = ndTaikhoan;
		this.cdTen = cdTen;
		this.dethis = dethis;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MSCD", unique = true, nullable = false)
	public Integer getMscd() {
		return this.mscd;
	}

	public void setMscd(Integer mscd) {
		this.mscd = mscd;
	}

	@Column(name = "ND_TAIKHOAN", length = 100)
	public String getNdTaikhoan() {
		return this.ndTaikhoan;
	}

	public void setNdTaikhoan(String ndTaikhoan) {
		this.ndTaikhoan = ndTaikhoan;
	}

	@Column(name = "CD_TEN", nullable = false, length = 100)
	public String getCdTen() {
		return this.cdTen;
	}

	public void setCdTen(String cdTen) {
		this.cdTen = cdTen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chude")
	public Set<Dethi> getDethis() {
		return this.dethis;
	}

	public void setDethis(Set<Dethi> dethis) {
		this.dethis = dethis;
	}

}
