// default package
// Generated Apr 22, 2015 4:57:38 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Lop generated by hbm2java
 */
@Entity
@Table(name = "lop", catalog = "tracnghiem")
public class Lop implements java.io.Serializable {

	private String msl;
	private Khoi khoi;
	private Set<DethiLop> dethiLops = new HashSet<DethiLop>(0);
	private Set<User> users = new HashSet<User>(0);

	public Lop() {
	}

	public Lop(String msl, Khoi khoi) {
		this.msl = msl;
		this.khoi = khoi;
	}

	public Lop(String msl, Khoi khoi, Set<DethiLop> dethiLops, Set<User> users) {
		this.msl = msl;
		this.khoi = khoi;
		this.dethiLops = dethiLops;
		this.users = users;
	}

	@Id
	@Column(name = "MSL", unique = true, nullable = false, length = 10)
	public String getMsl() {
		return this.msl;
	}

	public void setMsl(String msl) {
		this.msl = msl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSK", nullable = false)
	public Khoi getKhoi() {
		return this.khoi;
	}

	public void setKhoi(Khoi khoi) {
		this.khoi = khoi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lop")
	public Set<DethiLop> getDethiLops() {
		return this.dethiLops;
	}

	public void setDethiLops(Set<DethiLop> dethiLops) {
		this.dethiLops = dethiLops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lop")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
