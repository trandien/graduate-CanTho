// default package
// Generated Apr 23, 2015 5:07:01 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Cautraloi generated by hbm2java
 */
@Entity
@Table(name = "cautraloi", catalog = "tracnghiem")
public class Cautraloi implements java.io.Serializable {

	private Integer msctl;
	private Cauhoi cauhoi;
	private String ctlNoidung;

	public Cautraloi() {
	}

	public Cautraloi(Cauhoi cauhoi, String ctlNoidung) {
		this.cauhoi = cauhoi;
		this.ctlNoidung = ctlNoidung;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MSCTL", unique = true, nullable = false)
	public Integer getMsctl() {
		return this.msctl;
	}

	public void setMsctl(Integer msctl) {
		this.msctl = msctl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSCH", nullable = false)
	public Cauhoi getCauhoi() {
		return this.cauhoi;
	}

	public void setCauhoi(Cauhoi cauhoi) {
		this.cauhoi = cauhoi;
	}

	@Column(name = "CTL_NOIDUNG", nullable = false)
	public String getCtlNoidung() {
		return this.ctlNoidung;
	}

	public void setCtlNoidung(String ctlNoidung) {
		this.ctlNoidung = ctlNoidung;
	}

}
