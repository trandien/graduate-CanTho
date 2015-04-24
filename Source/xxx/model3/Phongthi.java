// default package
// Generated Apr 23, 2015 10:00:35 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Phongthi generated by hbm2java
 */
@Entity
@Table(name = "phongthi", catalog = "tracnghiem")
public class Phongthi implements java.io.Serializable {

	private Integer mspt;
	private String ptTen;

	public Phongthi() {
	}

	public Phongthi(String ptTen) {
		this.ptTen = ptTen;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MSPT", unique = true, nullable = false)
	public Integer getMspt() {
		return this.mspt;
	}

	public void setMspt(Integer mspt) {
		this.mspt = mspt;
	}

	@Column(name = "PT_TEN", nullable = false, length = 100)
	public String getPtTen() {
		return this.ptTen;
	}

	public void setPtTen(String ptTen) {
		this.ptTen = ptTen;
	}

}
