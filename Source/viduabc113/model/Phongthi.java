// default package
// Generated Mar 11, 2015 6:02:34 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Phongthi generated by hbm2java
 */
@Entity
@Table(name="phongthi"
    ,catalog="tracnghiem"
)
public class Phongthi  implements java.io.Serializable {


     private int mspt;
     private String ptTen;
     private Set<Thi> this = new HashSet<Thi>(0);

    public Phongthi() {
    }

	
    public Phongthi(int mspt, String ptTen) {
        this.mspt = mspt;
        this.ptTen = ptTen;
    }
    public Phongthi(int mspt, String ptTen, Set<Thi> this) {
       this.mspt = mspt;
       this.ptTen = ptTen;
       this.this = this;
    }
   
     @Id 

    
    @Column(name="MSPT", unique=true, nullable=false)
    public int getMspt() {
        return this.mspt;
    }
    
    public void setMspt(int mspt) {
        this.mspt = mspt;
    }

    
    @Column(name="PT_TEN", nullable=false, length=10)
    public String getPtTen() {
        return this.ptTen;
    }
    
    public void setPtTen(String ptTen) {
        this.ptTen = ptTen;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="phongthi")
    public Set<Thi> getThis() {
        return this.this;
    }
    
    public void setThis(Set<Thi> this) {
        this.this = this;
    }




}


