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
@Table(name="district")
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int dist_id;
    @Column
    private String dist_name; 

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private ProvinceEntity province;
    
    public DistrictEntity(String dist_name, ProvinceEntity province) {
        this.dist_name = dist_name;
        this.province = province;
    }
    public DistrictEntity() {
    }
    
    public int getDist_id() {
        return dist_id;
    }
    public void setDist_id(int dist_id) {
        this.dist_id = dist_id;
    }
    public String getDist_name() {
        return dist_name;
    }
    public void setDist_name(String dist_name) {
        this.dist_name = dist_name;
    }
    public ProvinceEntity getProvince() {
        return province;
    }
    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }    
}
