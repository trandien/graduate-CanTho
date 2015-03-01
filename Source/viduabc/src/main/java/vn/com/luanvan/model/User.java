package vn.com.luanvan.model;

// default package
// Generated Jan 31, 2015 7:09:10 PM by Hibernate Tools 4.3.1

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "tracnghiem")
public class User implements java.io.Serializable {

	private String email;
	private String matKhau;
	private String hoTen;
	private String avatar;

	public User() {
	}

	public User(String email, String matKhau, String hoTen, String avatar) {
		this.email = email;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.avatar = avatar;
	}

	@Id
	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "MATKHAU", nullable = false, length = 100)
	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
/*
	@Column(name = "ENABLED", nullable = false, precision = 1, scale = 0)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
*/
	
	@Column(name = "HOTEN", nullable = true, length=100)
	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	@Column(name = "AVATAR", nullable = true)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	
}
