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
}
