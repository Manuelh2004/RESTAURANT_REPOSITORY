package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_user")
public class TypeUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tpe_us_id;
    @Column
    private String tpe_us_name;
    @Column
    private double salary;
    
    public TypeUserEntity(String tpe_us_name, double salary) {
        this.tpe_us_name = tpe_us_name;
        this.salary = salary;
    }
    public TypeUserEntity() {
    }
    
    public int getTpe_us_id() {
        return tpe_us_id;
    }
    public void setTpe_us_id(int tpe_us_id) {
        this.tpe_us_id = tpe_us_id;
    }
    public String getTpe_us_name() {
        return tpe_us_name;
    }
    public void setTpe_us_name(String tpe_us_name) {
        this.tpe_us_name = tpe_us_name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }     
}
