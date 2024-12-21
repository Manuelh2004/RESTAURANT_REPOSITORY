package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "local_table")
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int table_id;
    @Column
    private int table_number; 
    @Column
    private int table_capacity; 
    @Column
    private String table_status;

    public TableEntity(int table_number, int table_capacity, String table_status) {
        this.table_number = table_number;
        this.table_capacity = table_capacity;
        this.table_status = table_status;
    }
    public TableEntity() {
    }

    public int getTable_id() {
        return table_id;
    }
    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }
    public int getTable_number() {
        return table_number;
    }
    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }
    public int getTable_capacity() {
        return table_capacity;
    }
    public void setTable_capacity(int table_capacity) {
        this.table_capacity = table_capacity;
    }
    public String getTable_status() {
        return table_status;
    }
    public void setTable_status(String table_status) {
        this.table_status = table_status;
    }     
}
