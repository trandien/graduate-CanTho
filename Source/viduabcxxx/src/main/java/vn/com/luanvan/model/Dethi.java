package vn.com.luanvan.model;
// Generated Mar 19, 2015 8:01:06 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Dethi generated by hbm2java
 */
@Entity
@Table(name="dethi"
    ,catalog="tracnghiem"
)
public class Dethi  implements java.io.Serializable {


     private int msdt;
     private Chude chude;
     private Dangthi dangthi;
     private Hocky hocky;
     private Monhoc monhoc;
     private Nienkhoa nienkhoa;
     private String dtTende;
     private int dtThoigianlambai;
     private boolean dtTrangthai;
     private String dtMatkhau;
     private Date dtNgaytaode;
     private Date dtNgaycapnhat;
     private String dtDando;
     private int dtSolanchophep;
     private String dtNguoirade;
     private Set<Cauhoi> cauhois = new HashSet<Cauhoi>(0);
     private Set<Kithi> kithis = new HashSet<Kithi>(0);
     private Set<Phancongvaitro> phancongvaitros = new HashSet<Phancongvaitro>(0);
     private Set<Lop> lops = new HashSet<Lop>(0);
     private Set<Thi> thi = new HashSet<Thi>(0);

    public Dethi() {
    }

	
    public Dethi(int msdt, Chude chude, Dangthi dangthi, Hocky hocky, Monhoc monhoc, Nienkhoa nienkhoa, String dtTende, int dtThoigianlambai, boolean dtTrangthai, String dtMatkhau, Date dtNgaytaode, Date dtNgaycapnhat, int dtSolanchophep, String dtNguoirade) {
        this.msdt = msdt;
        this.chude = chude;
        this.dangthi = dangthi;
        this.hocky = hocky;
        this.monhoc = monhoc;
        this.nienkhoa = nienkhoa;
        this.dtTende = dtTende;
        this.dtThoigianlambai = dtThoigianlambai;
        this.dtTrangthai = dtTrangthai;
        this.dtMatkhau = dtMatkhau;
        this.dtNgaytaode = dtNgaytaode;
        this.dtNgaycapnhat = dtNgaycapnhat;
        this.dtSolanchophep = dtSolanchophep;
        this.dtNguoirade = dtNguoirade;
    }
    
    public Dethi(int msdt, Chude chude, Dangthi dangthi, Hocky hocky, Monhoc monhoc, Nienkhoa nienkhoa, String dtTende, int dtThoigianlambai, boolean dtTrangthai, String dtMatkhau, Date dtNgaytaode, Date dtNgaycapnhat, String dtDando, int dtSolanchophep, String dtNguoirade, Set<Cauhoi> cauhois, Set<Kithi> kithis, Set<Phancongvaitro> phancongvaitros) {
        this.msdt = msdt;
        this.chude = chude;
        this.dangthi = dangthi;
        this.hocky = hocky;
        this.monhoc = monhoc;
        this.nienkhoa = nienkhoa;
        this.dtTende = dtTende;
        this.dtThoigianlambai = dtThoigianlambai;
        this.dtTrangthai = dtTrangthai;
        this.dtMatkhau = dtMatkhau;
        this.dtNgaytaode = dtNgaytaode;
        this.dtNgaycapnhat = dtNgaycapnhat;
        this.dtDando = dtDando;
        this.dtSolanchophep = dtSolanchophep;
        this.dtNguoirade = dtNguoirade;
        this.cauhois = cauhois;
        this.kithis = kithis;
        this.phancongvaitros = phancongvaitros;
       
     }
    
    public Dethi(int msdt, Chude chude, Dangthi dangthi, Hocky hocky, Monhoc monhoc, Nienkhoa nienkhoa, String dtTende, int dtThoigianlambai, boolean dtTrangthai, String dtMatkhau, Date dtNgaytaode, Date dtNgaycapnhat, String dtDando, int dtSolanchophep, String dtNguoirade, Set<Cauhoi> cauhois, Set<Kithi> kithis, Set<Phancongvaitro> phancongvaitros, Set<Lop> lops, Set<Thi> thi) {
       this.msdt = msdt;
       this.chude = chude;
       this.dangthi = dangthi;
       this.hocky = hocky;
       this.monhoc = monhoc;
       this.nienkhoa = nienkhoa;
       this.dtTende = dtTende;
       this.dtThoigianlambai = dtThoigianlambai;
       this.dtTrangthai = dtTrangthai;
       this.dtMatkhau = dtMatkhau;
       this.dtNgaytaode = dtNgaytaode;
       this.dtNgaycapnhat = dtNgaycapnhat;
       this.dtDando = dtDando;
       this.dtSolanchophep = dtSolanchophep;
       this.dtNguoirade = dtNguoirade;
       this.cauhois = cauhois;
       this.kithis = kithis;
       this.phancongvaitros = phancongvaitros;
       this.lops = lops;
       this.thi = thi;
    }
   
     @Id 
    @Column(name="MSDT", unique=true, nullable=false)
    public int getMsdt() {
        return this.msdt;
    }
    
    public void setMsdt(int msdt) {
        this.msdt = msdt;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MSCD", nullable=false)
    public Chude getChude() {
        return this.chude;
    }
    
    public void setChude(Chude chude) {
        this.chude = chude;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MSDANGTHI", nullable=false)
    public Dangthi getDangthi() {
        return this.dangthi;
    }
    
    public void setDangthi(Dangthi dangthi) {
        this.dangthi = dangthi;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MSHK", nullable=false)
    public Hocky getHocky() {
        return this.hocky;
    }
    
    public void setHocky(Hocky hocky) {
        this.hocky = hocky;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MSMH", nullable=false)
    public Monhoc getMonhoc() {
        return this.monhoc;
    }
    
    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MSNK", nullable=false)
    public Nienkhoa getNienkhoa() {
        return this.nienkhoa;
    }
    
    public void setNienkhoa(Nienkhoa nienkhoa) {
        this.nienkhoa = nienkhoa;
    }

    
    @Column(name="DT_TENDE", nullable=false, length=100)
    public String getDtTende() {
        return this.dtTende;
    }
    
    public void setDtTende(String dtTende) {
        this.dtTende = dtTende;
    }

    
    @Column(name="DT_THOIGIANLAMBAI", nullable=false)
    public int getDtThoigianlambai() {
        return this.dtThoigianlambai;
    }
    
    public void setDtThoigianlambai(int dtThoigianlambai) {
        this.dtThoigianlambai = dtThoigianlambai;
    }

    
    @Column(name="DT_TRANGTHAI", nullable=false)
    public boolean isDtTrangthai() {
        return this.dtTrangthai;
    }
    
    public void setDtTrangthai(boolean dtTrangthai) {
        this.dtTrangthai = dtTrangthai;
    }

    
    @Column(name="DT_MATKHAU", nullable=false, length=20)
    public String getDtMatkhau() {
        return this.dtMatkhau;
    }
    
    public void setDtMatkhau(String dtMatkhau) {
        this.dtMatkhau = dtMatkhau;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_NGAYTAODE", nullable=true, length=0)
    public Date getDtNgaytaode() {
        return this.dtNgaytaode;
    }
    
    public void setDtNgaytaode(Date dtNgaytaode) {
        this.dtNgaytaode = dtNgaytaode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_NGAYCAPNHAT", nullable=true, length=0)
    public Date getDtNgaycapnhat() {
        return this.dtNgaycapnhat;
    }
    
    public void setDtNgaycapnhat(Date dtNgaycapnhat) {
        this.dtNgaycapnhat = dtNgaycapnhat;
    }

    
    @Column(name="DT_DANDO", length=65535)
    public String getDtDando() {
        return this.dtDando;
    }
    
    public void setDtDando(String dtDando) {
        this.dtDando = dtDando;
    }

    
    @Column(name="DT_solanchophep", nullable=false)
    public int getDtSolanchophep() {
        return this.dtSolanchophep;
    }
    
    public void setDtSolanchophep(int dtSolanchophep) {
        this.dtSolanchophep = dtSolanchophep;
    }
    
    @Column(name="DT_NGUOIRADE", nullable=true, length=100)
    public String getDtNguoiRaDe() {
        return this.dtNguoirade;
    }
    
    public void setDtNguoiRaDe(String dtNguoirade) {
        this.dtNguoirade = dtNguoirade;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Cauhoi> getCauhois() {
        return this.cauhois;
    }
    
    public void setCauhois(Set<Cauhoi> cauhois) {
        this.cauhois = cauhois;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Kithi> getKithis() {
        return this.kithis;
    }
    
    public void setKithis(Set<Kithi> kithis) {
        this.kithis = kithis;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Phancongvaitro> getPhancongvaitros() {
        return this.phancongvaitros;
    }
    
    public void setPhancongvaitros(Set<Phancongvaitro> phancongvaitros) {
        this.phancongvaitros = phancongvaitros;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="dethis")
    public Set<Lop> getLops() {
        return this.lops;
    }
    
    public void setLops(Set<Lop> lops) {
        this.lops = lops;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Thi> getThis() {
        return this.thi;
    }
    
    public void setThis(Set<Thi> thi) {
        this.thi = thi;
    }




}

