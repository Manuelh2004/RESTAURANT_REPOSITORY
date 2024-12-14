package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rol_id;
    @Column
    private String rol_name;
    
    public RoleEntity(String rol_name) {
        this.rol_name = rol_name;
    }
    public RoleEntity() {
    }
    
    public int getRol_id() {
        return rol_id;
    }
    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }
    public String getRol_name() {
        return rol_name;
    }
    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }    
}
