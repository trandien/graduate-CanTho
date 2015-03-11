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

	private String taiKhoan;
	private String email;
	private String matKhau;
	private Integer msvt;
	private String msl;
	private String hoTen;
	private String avatar;
	private String codeRandom;
	public User() {
	}

	public User(String taiKhoan, String email, String matKhau, Integer msvt, String msl, String hoTen, String avatar, String codeRandom) {
		this.taiKhoan = taiKhoan;
		this.email = email;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.avatar = avatar;
		this.codeRandom = codeRandom;
		this.msvt = msvt;
		this.msl = msl;
	}

	
	@Column(name = "ND_EMAIL", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ND_MATKHAU", nullable = false, length = 100)
	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	@Column(name = "MSVT", nullable = false, length = 100)
	public Integer getMSVT() {
		return this.msvt;
	}

	public void setMSVT(Integer msvt) {
		this.msvt = msvt;
	}
	
	@Column(name = "MSL", nullable = true, length = 100)
	public String getMSL() {
		return this.msl;
	}

	public void setMSL(String msl) {
		this.msl = msl;
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
	@Id
	@Column(name = "ND_TAIKHOAN", nullable = true, length=100)
	public String getTaiKhoan() {
		return this.taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	@Column(name = "ND_HOTEN", nullable = true, length=100)
	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	@Column(name = "ND_AVATAR", nullable = true)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@Column(name = "CODECHANGEPASSWORD", nullable = true, length=10)
	public String getCodeRandom() {
		return this.codeRandom;
	}

	public void setCodeRandom(String codeRandom) {
		this.codeRandom = codeRandom;
	}

	
}