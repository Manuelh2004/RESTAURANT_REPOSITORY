package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_client")
public class TypeClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tpe_cli_id; 
    @Column
    private String tpe_cli_name; 
    @Column
    private String tpe_cli_abbreviation; 
    @Column
    private double tpe_cli_discount;
    
    public TypeClientEntity(String tpe_cli_name, String tpe_cli_abbreviation, double tpe_cli_discount) {
        this.tpe_cli_name = tpe_cli_name;
        this.tpe_cli_abbreviation = tpe_cli_abbreviation;
        this.tpe_cli_discount = tpe_cli_discount;
    }
    public TypeClientEntity() {
    }
    
    public int getTpe_cli_id() {
        return tpe_cli_id;
    }
    public void setTpe_cli_id(int tpe_cli_id) {
        this.tpe_cli_id = tpe_cli_id;
    }
    public String getTpe_cli_name() {
        return tpe_cli_name;
    }
    public void setTpe_cli_name(String tpe_cli_name) {
        this.tpe_cli_name = tpe_cli_name;
    }
    public String getTpe_cli_abbreviation() {
        return tpe_cli_abbreviation;
    }
    public void setTpe_cli_abbreviation(String tpe_cli_abbreviation) {
        this.tpe_cli_abbreviation = tpe_cli_abbreviation;
    }
    public double getTpe_cli_discount() {
        return tpe_cli_discount;
    }
    public void setTpe_cli_discount(double tpe_cli_discount) {
        this.tpe_cli_discount = tpe_cli_discount;
    }        
}
