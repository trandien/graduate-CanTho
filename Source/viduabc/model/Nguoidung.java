// default package
// Generated Mar 10, 2015 9:46:01 PM by Hibernate Tools 4.3.1


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
 * Nguoidung generated by hbm2java
 */
@Entity
@Table(name="nguoidung"
    ,catalog="thitracnghiem"
)
public class Nguoidung  implements java.io.Serializable {


     private String ndTaikhoan;
     private Lop lop;
     private Vaitro vaitro;
     private String ndMatkhau;
     private String ndHoten;
     private String ndEmail;
     private String ndAvatar;
     private Set<Thi> this = new HashSet<Thi>(0);
     private Set<Traloi> tralois = new HashSet<Traloi>(0);
     private Set<Traloi> tralois_1 = new HashSet<Traloi>(0);
     private Set<Phancongvaitro> phancongvaitros = new HashSet<Phancongvaitro>(0);

    public Nguoidung() {
    }

	
    public Nguoidung(String ndTaikhoan, Lop lop, Vaitro vaitro, String ndMatkhau, String ndHoten, String ndEmail) {
        this.ndTaikhoan = ndTaikhoan;
        this.lop = lop;
        this.vaitro = vaitro;
        this.ndMatkhau = ndMatkhau;
        this.ndHoten = ndHoten;
        this.ndEmail = ndEmail;
    }
    public Nguoidung(String ndTaikhoan, Lop lop, Vaitro vaitro, String ndMatkhau, String ndHoten, String ndEmail, String ndAvatar, Set<Thi> this, Set<Traloi> tralois, Set<Traloi> tralois_1, Set<Phancongvaitro> phancongvaitros) {
       this.ndTaikhoan = ndTaikhoan;
       this.lop = lop;
       this.vaitro = vaitro;
       this.ndMatkhau = ndMatkhau;
       this.ndHoten = ndHoten;
       this.ndEmail = ndEmail;
       this.ndAvatar = ndAvatar;
       this.this = this;
       this.tralois = tralois;
       this.tralois_1 = tralois_1;
       this.phancongvaitros = phancongvaitros;
    }
   
     @Id 

    
    @Column(name="ND_TAIKHOAN", unique=true, nullable=false, length=10)
    public String getNdTaikhoan() {
        return this.ndTaikhoan;
    }
    
    public void setNdTaikhoan(String ndTaikhoan) {
        this.ndTaikhoan = ndTaikhoan;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MSL", nullable=false)
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

    
    @Column(name="ND_AVATAR")
    public String getNdAvatar() {
        return this.ndAvatar;
    }
    
    public void setNdAvatar(String ndAvatar) {
        this.ndAvatar = ndAvatar;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="nguoidung")
    public Set<Thi> getThis() {
        return this.this;
    }
    
    public void setThis(Set<Thi> this) {
        this.this = this;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="nguoidung")
    public Set<Traloi> getTralois() {
        return this.tralois;
    }
    
    public void setTralois(Set<Traloi> tralois) {
        this.tralois = tralois;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="nguoidung")
    public Set<Traloi> getTralois_1() {
        return this.tralois_1;
    }
    
    public void setTralois_1(Set<Traloi> tralois_1) {
        this.tralois_1 = tralois_1;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="nguoidung")
    public Set<Phancongvaitro> getPhancongvaitros() {
        return this.phancongvaitros;
    }
    
    public void setPhancongvaitros(Set<Phancongvaitro> phancongvaitros) {
        this.phancongvaitros = phancongvaitros;
    }




}


