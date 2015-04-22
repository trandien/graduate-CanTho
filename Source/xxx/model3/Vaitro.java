// default package
// Generated Apr 22, 2015 4:57:38 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vaitro generated by hbm2java
 */
@Entity
@Table(name = "vaitro", catalog = "tracnghiem")
public class Vaitro implements java.io.Serializable {

	private int msvt;
	private String vtTen;
	private Set<Phancongvaitro> phancongvaitros = new HashSet<Phancongvaitro>(0);
	private Set<User> users = new HashSet<User>(0);

	public Vaitro() {
	}

	public Vaitro(int msvt, String vtTen) {
		this.msvt = msvt;
		this.vtTen = vtTen;
	}

	public Vaitro(int msvt, String vtTen, Set<Phancongvaitro> phancongvaitros,
			Set<User> users) {
		this.msvt = msvt;
		this.vtTen = vtTen;
		this.phancongvaitros = phancongvaitros;
		this.users = users;
	}

	@Id
	@Column(name = "MSVT", unique = true, nullable = false)
	public int getMsvt() {
		return this.msvt;
	}

	public void setMsvt(int msvt) {
		this.msvt = msvt;
	}

	@Column(name = "VT_TEN", nullable = false, length = 20)
	public String getVtTen() {
		return this.vtTen;
	}

	public void setVtTen(String vtTen) {
		this.vtTen = vtTen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vaitro")
	public Set<Phancongvaitro> getPhancongvaitros() {
		return this.phancongvaitros;
	}

	public void setPhancongvaitros(Set<Phancongvaitro> phancongvaitros) {
		this.phancongvaitros = phancongvaitros;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vaitro")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
