package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cat_id; 
    @Column
    private String cat_name; 
    @Column
    private String cat_description;    
    @Column
    private String cat_status;       
   
    public CategoryEntity(String cat_name, String cat_description, String cat_status) {
        this.cat_name = cat_name;
        this.cat_description = cat_description;
        this.cat_status = cat_status;
    }
    public CategoryEntity() {
    }

    public int getCat_id() {
        return cat_id;
    }
    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }
    public String getCat_name() {
        return cat_name;
    }
    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
    public String getCat_description() {
        return cat_description;
    }
    public void setCat_description(String cat_description) {
        this.cat_description = cat_description;
    }
    public String getCat_status() {
        return cat_status;
    }
    public void setCat_status(String cat_status) {
        this.cat_status = cat_status;
    }     
}
