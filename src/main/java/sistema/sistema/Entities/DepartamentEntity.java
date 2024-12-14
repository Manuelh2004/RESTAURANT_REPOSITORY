package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departament")
public class DepartamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int dep_id;
    @Column
    private String dep_name;
    
    public DepartamentEntity(String dep_name) {
        this.dep_name = dep_name;
    }
    public DepartamentEntity() {
    }
    
    public int getDep_id() {
        return dep_id;
    }
    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }
    public String getDep_name() {
        return dep_name;
    }
    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }     
}
