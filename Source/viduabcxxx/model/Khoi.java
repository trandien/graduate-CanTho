// default package
// Generated Mar 21, 2015 12:26:30 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Khoi generated by hbm2java
 */
@Entity
@Table(name = "khoi", catalog = "tracnghiem")
public class Khoi implements java.io.Serializable {

	private String msk;
	private Set<Lop> lops = new HashSet<Lop>(0);

	public Khoi() {
	}

	public Khoi(String msk) {
		this.msk = msk;
	}

	public Khoi(String msk, Set<Lop> lops) {
		this.msk = msk;
		this.lops = lops;
	}

	@Id
	@Column(name = "MSK", unique = true, nullable = false, length = 10)
	public String getMsk() {
		return this.msk;
	}

	public void setMsk(String msk) {
		this.msk = msk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khoi")
	public Set<Lop> getLops() {
		return this.lops;
	}

	public void setLops(Set<Lop> lops) {
		this.lops = lops;
	}

}