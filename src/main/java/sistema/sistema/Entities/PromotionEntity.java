package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prom_id; 
    @Column
    private String prom_name; 
    @Column
    private double prom_discount;    
    @Column
    private String prom_status;    
    
    public PromotionEntity(String prom_name, double prom_discount, String prom_status) {
        this.prom_name = prom_name;
        this.prom_discount = prom_discount;
        this.prom_status = prom_status;
    }
    public PromotionEntity() {
    }

    public int getProm_id() {
        return prom_id;
    }
    public void setProm_id(int prom_id) {
        this.prom_id = prom_id;
    }
    public String getProm_name() {
        return prom_name;
    }
    public void setProm_name(String prom_name) {
        this.prom_name = prom_name;
    }
    public double getProm_discount() {
        return prom_discount;
    }
    public void setProm_discount(double prom_discount) {
        this.prom_discount = prom_discount;
    }
    public String getProm_status() {
        return prom_status;
    }
    public void setProm_status(String prom_status) {
        this.prom_status = prom_status;
    }     
}
