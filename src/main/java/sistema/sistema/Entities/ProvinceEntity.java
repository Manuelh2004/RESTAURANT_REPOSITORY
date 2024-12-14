package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="province")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int province_id;
    @Column
    private String pro_name;
    
    @ManyToOne
    @JoinColumn(name = "dep_id")
    private DepartamentEntity departament;    

    public ProvinceEntity(String pro_name, DepartamentEntity departament) {
        this.pro_name = pro_name;
        this.departament = departament;
    }
    public ProvinceEntity() {
    }
    
    public int getProvince_id() {
        return province_id;
    }
    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }
    public String getPro_name() {
        return pro_name;
    }
    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }
    public DepartamentEntity getDepartament() {
        return departament;
    }
    public void setDepartament(DepartamentEntity departament) {
        this.departament = departament;
    }       
}
