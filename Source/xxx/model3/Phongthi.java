// default package
// Generated Apr 22, 2015 4:57:38 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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


     private Integer mspt;
     private String ptTen;
     private Set<Thi> this = new HashSet<Thi>(0);

    public Phongthi() {
    }

	
    public Phongthi(String ptTen) {
        this.ptTen = ptTen;
    }
    public Phongthi(String ptTen, Set<Thi> this) {
       this.ptTen = ptTen;
       this.this = this;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="MSPT", unique=true, nullable=false)
    public Integer getMspt() {
        return this.mspt;
    }
    
    public void setMspt(Integer mspt) {
        this.mspt = mspt;
    }

    
    @Column(name="PT_TEN", nullable=false, length=100)
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


