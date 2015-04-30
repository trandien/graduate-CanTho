// default package
// Generated Apr 30, 2015 9:49:25 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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


     private Integer msdt;
     private Chude chude;
     private Dangthi dangthi;
     private Hocky hocky;
     private Monhoc monhoc;
     private Nienkhoa nienkhoa;
     private User user;
     private String dtTende;
     private int dtThoigianlambai;
     private int dtTrangthai;
     private String dtMatkhau;
     private Date dtNgaytaode;
     private Date dtNgaycapnhat;
     private String dtDando;
     private int dtSolanchophep;
     private Integer lancapnhat;
     private Set<Kithi> kithis = new HashSet<Kithi>(0);
     private Set<Cauhoi> cauhois = new HashSet<Cauhoi>(0);
     private Set<Phancongvaitro> phancongvaitros = new HashSet<Phancongvaitro>(0);
     private Set<DethiLop> dethiLops = new HashSet<DethiLop>(0);
     private Set<Thi> this = new HashSet<Thi>(0);

    public Dethi() {
    }

	
    public Dethi(Chude chude, Dangthi dangthi, Hocky hocky, Monhoc monhoc, Nienkhoa nienkhoa, User user, String dtTende, int dtThoigianlambai, int dtTrangthai, String dtMatkhau, Date dtNgaytaode, int dtSolanchophep) {
        this.chude = chude;
        this.dangthi = dangthi;
        this.hocky = hocky;
        this.monhoc = monhoc;
        this.nienkhoa = nienkhoa;
        this.user = user;
        this.dtTende = dtTende;
        this.dtThoigianlambai = dtThoigianlambai;
        this.dtTrangthai = dtTrangthai;
        this.dtMatkhau = dtMatkhau;
        this.dtNgaytaode = dtNgaytaode;
        this.dtSolanchophep = dtSolanchophep;
    }
    public Dethi(Chude chude, Dangthi dangthi, Hocky hocky, Monhoc monhoc, Nienkhoa nienkhoa, User user, String dtTende, int dtThoigianlambai, int dtTrangthai, String dtMatkhau, Date dtNgaytaode, Date dtNgaycapnhat, String dtDando, int dtSolanchophep, Integer lancapnhat, Set<Kithi> kithis, Set<Cauhoi> cauhois, Set<Phancongvaitro> phancongvaitros, Set<DethiLop> dethiLops, Set<Thi> this) {
       this.chude = chude;
       this.dangthi = dangthi;
       this.hocky = hocky;
       this.monhoc = monhoc;
       this.nienkhoa = nienkhoa;
       this.user = user;
       this.dtTende = dtTende;
       this.dtThoigianlambai = dtThoigianlambai;
       this.dtTrangthai = dtTrangthai;
       this.dtMatkhau = dtMatkhau;
       this.dtNgaytaode = dtNgaytaode;
       this.dtNgaycapnhat = dtNgaycapnhat;
       this.dtDando = dtDando;
       this.dtSolanchophep = dtSolanchophep;
       this.lancapnhat = lancapnhat;
       this.kithis = kithis;
       this.cauhois = cauhois;
       this.phancongvaitros = phancongvaitros;
       this.dethiLops = dethiLops;
       this.this = this;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="MSDT", unique=true, nullable=false)
    public Integer getMsdt() {
        return this.msdt;
    }
    
    public void setMsdt(Integer msdt) {
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

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DT_NGUOIRADE", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
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
    public int getDtTrangthai() {
        return this.dtTrangthai;
    }
    
    public void setDtTrangthai(int dtTrangthai) {
        this.dtTrangthai = dtTrangthai;
    }

    
    @Column(name="DT_MATKHAU", nullable=false, length=20)
    public String getDtMatkhau() {
        return this.dtMatkhau;
    }
    
    public void setDtMatkhau(String dtMatkhau) {
        this.dtMatkhau = dtMatkhau;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DT_NGAYTAODE", nullable=false, length=0)
    public Date getDtNgaytaode() {
        return this.dtNgaytaode;
    }
    
    public void setDtNgaytaode(Date dtNgaytaode) {
        this.dtNgaytaode = dtNgaytaode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DT_NGAYCAPNHAT", length=0)
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

    
    @Column(name="LANCAPNHAT")
    public Integer getLancapnhat() {
        return this.lancapnhat;
    }
    
    public void setLancapnhat(Integer lancapnhat) {
        this.lancapnhat = lancapnhat;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Kithi> getKithis() {
        return this.kithis;
    }
    
    public void setKithis(Set<Kithi> kithis) {
        this.kithis = kithis;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Cauhoi> getCauhois() {
        return this.cauhois;
    }
    
    public void setCauhois(Set<Cauhoi> cauhois) {
        this.cauhois = cauhois;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Phancongvaitro> getPhancongvaitros() {
        return this.phancongvaitros;
    }
    
    public void setPhancongvaitros(Set<Phancongvaitro> phancongvaitros) {
        this.phancongvaitros = phancongvaitros;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<DethiLop> getDethiLops() {
        return this.dethiLops;
    }
    
    public void setDethiLops(Set<DethiLop> dethiLops) {
        this.dethiLops = dethiLops;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Thi> getThis() {
        return this.this;
    }
    
    public void setThis(Set<Thi> this) {
        this.this = this;
    }




}


