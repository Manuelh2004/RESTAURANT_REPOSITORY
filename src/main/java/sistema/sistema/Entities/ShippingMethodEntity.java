package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipping_method")
public class ShippingMethodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shod_id; 
    @Column
    private String shod_name; 
    @Column
    private String shod_abbreviation; 
    @Column
    private double shod_discount;    

    public ShippingMethodEntity(String shod_name, String shod_abbreviation, double shod_discount) {
        this.shod_name = shod_name;
        this.shod_abbreviation = shod_abbreviation;
        this.shod_discount = shod_discount;
    }
    public ShippingMethodEntity() {
    }
    
    public int getShod_id() {
        return shod_id;
    }
    public void setShod_id(int shod_id) {
        this.shod_id = shod_id;
    }
    public String getShod_name() {
        return shod_name;
    }
    public void setShod_name(String shod_name) {
        this.shod_name = shod_name;
    }
    public String getShod_abbreviation() {
        return shod_abbreviation;
    }
    public void setShod_abbreviation(String shod_abbreviation) {
        this.shod_abbreviation = shod_abbreviation;
    }
    public double getShod_discount() {
        return shod_discount;
    }
    public void setShod_discount(double shod_discount) {
        this.shod_discount = shod_discount;
    }       
}
