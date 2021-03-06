package vn.com.luanvan.model;

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
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="tracnghiem"
)
public class User implements java.io.Serializable {


	private String ndTaikhoan;
    private Lop lop;
    private Vaitro vaitro;
    private String ndMatkhau;
    private String ndHoten;
    private String ndEmail;
    private String ndAvatar;
    private String coderandom;
    private Set<Thi> thi = new HashSet<Thi>(0);
    private Set<Traloi> tralois = new HashSet<Traloi>(0);
    private Set<Dethi> dethis = new HashSet<Dethi>(0);
    private Set<Phancongvaitro> phancongvaitros = new HashSet<Phancongvaitro>(0);

   public User() {
   }

	
   public User(String ndTaikhoan, Vaitro vaitro, String ndMatkhau, String ndHoten, String ndEmail, String ndAvatar, String coderandom) {
       this.ndTaikhoan = ndTaikhoan;
       this.vaitro = vaitro;
       this.ndMatkhau = ndMatkhau;
       this.ndHoten = ndHoten;
       this.ndEmail = ndEmail;
       this.ndAvatar = ndAvatar;
       this.coderandom = coderandom;
   }
   public User(String ndTaikhoan, Lop lop, Vaitro vaitro, String ndMatkhau, String ndHoten, String ndEmail, String ndAvatar, String coderandom, Set<Thi> thi, Set<Traloi> tralois, Set<Dethi> dethis, Set<Phancongvaitro> phancongvaitros) {
      this.ndTaikhoan = ndTaikhoan;
      this.lop = lop;
      this.vaitro = vaitro;
      this.ndMatkhau = ndMatkhau;
      this.ndHoten = ndHoten;
      this.ndEmail = ndEmail;
      this.ndAvatar = ndAvatar;
      this.coderandom = coderandom;
      this.thi = thi;
      this.tralois = tralois;
      this.dethis = dethis;
      this.phancongvaitros = phancongvaitros;
   }
  
    @Id 

   
   @Column(name="ND_TAIKHOAN", unique=true, nullable=false, length=100)
   public String getNdTaikhoan() {
       return this.ndTaikhoan;
   }
   
   public void setNdTaikhoan(String ndTaikhoan) {
       this.ndTaikhoan = ndTaikhoan;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="MSL")
   public Lop getLop() {
       return this.lop;
   }
   
   public void setLop(Lop lop) {
       this.lop = lop;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="MSVT", nullable=false)
   public Vaitro getVaitro() {
       return this.vaitro;
   }
   
   public void setVaitro(Vaitro vaitro) {
       this.vaitro = vaitro;
   }

   
   @Column(name="ND_MATKHAU", nullable=false, length=100)
   public String getNdMatkhau() {
       return this.ndMatkhau;
   }
   
   public void setNdMatkhau(String ndMatkhau) {
       this.ndMatkhau = ndMatkhau;
   }

   
   @Column(name="ND_HOTEN", nullable=false, length=100)
   public String getNdHoten() {
       return this.ndHoten;
   }
   
   public void setNdHoten(String ndHoten) {
       this.ndHoten = ndHoten;
   }

   
   @Column(name="ND_EMAIL", nullable=false, length=100)
   public String getNdEmail() {
       return this.ndEmail;
   }
   
   public void setNdEmail(String ndEmail) {
       this.ndEmail = ndEmail;
   }

   
   @Column(name="ND_AVATAR", nullable=false)
   public String getNdAvatar() {
       return this.ndAvatar;
   }
   
   public void setNdAvatar(String ndAvatar) {
       this.ndAvatar = ndAvatar;
   }

   
   @Column(name="coderandom", nullable=false, length=10)
   public String getCoderandom() {
       return this.coderandom;
   }
   
   public void setCoderandom(String coderandom) {
       this.coderandom = coderandom;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
   public Set<Thi> getThis() {
       return this.thi;
   }
   
   public void setThis(Set<Thi> thi) {
       this.thi = thi;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
   public Set<Traloi> getTralois() {
       return this.tralois;
   }
   
   public void setTralois(Set<Traloi> tralois) {
       this.tralois = tralois;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
   public Set<Dethi> getDethis() {
       return this.dethis;
   }
   
   public void setDethis(Set<Dethi> dethis) {
       this.dethis = dethis;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
   public Set<Phancongvaitro> getPhancongvaitros() {
       return this.phancongvaitros;
   }
   
   public void setPhancongvaitros(Set<Phancongvaitro> phancongvaitros) {
       this.phancongvaitros = phancongvaitros;
   }


}


