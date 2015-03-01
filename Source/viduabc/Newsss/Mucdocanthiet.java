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
 * Mucdocanthiet generated by hbm2java
 */
@Entity
@Table(name = "mucdocanthiet", catalog = "luanvan")
public class Mucdocanthiet implements java.io.Serializable {

	private Integer mucdocanthietid;
	private String tenmucdo;
	private Set usecases = new HashSet(0);

	public Mucdocanthiet() {
	}

	public Mucdocanthiet(String tenmucdo) {
		this.tenmucdo = tenmucdo;
	}

	public Mucdocanthiet(String tenmucdo, Set usecases) {
		this.tenmucdo = tenmucdo;
		this.usecases = usecases;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MUCDOCANTHIETID", unique = true, nullable = false)
	public Integer getMucdocanthietid() {
		return this.mucdocanthietid;
	}

	public void setMucdocanthietid(Integer mucdocanthietid) {
		this.mucdocanthietid = mucdocanthietid;
	}

	@Column(name = "TENMUCDO", nullable = false)
	public String getTenmucdo() {
		return this.tenmucdo;
	}

	public void setTenmucdo(String tenmucdo) {
		this.tenmucdo = tenmucdo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mucdocanthiet")
	public Set getUsecases() {
		return this.usecases;
	}

	public void setUsecases(Set usecases) {
		this.usecases = usecases;
	}

}
