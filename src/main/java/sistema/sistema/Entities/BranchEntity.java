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
@Table(name="branch")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int brh_id; 
    @Column
    private String brh_ruc; 
    @Column
    private String brh_direction; 
    @Column
    private String brh_start_date; 
    @Column
    private String brh_end_date; 
    @Column
    private String brh_phone; 
    @Column
    private String brh_status; 
    @Column
    private int brh_capacity;

    @ManyToOne
    @JoinColumn(name = "dist_id")
    private DistrictEntity district;    
    
    public BranchEntity(String brh_ruc, String brh_direction, String brh_start_date, String brh_end_date,
            String brh_phone, String brh_status, int brh_capacity, DistrictEntity district) {
        this.brh_ruc = brh_ruc;
        this.brh_direction = brh_direction;
        this.brh_start_date = brh_start_date;
        this.brh_end_date = brh_end_date;
        this.brh_phone = brh_phone;
        this.brh_status = brh_status;
        this.brh_capacity = brh_capacity;
        this.district = district;
    }
    public BranchEntity() {
    }
    
    public int getBrh_id() {
        return brh_id;
    }
    public void setBrh_id(int brh_id) {
        this.brh_id = brh_id;
    }
    public String getBrh_ruc() {
        return brh_ruc;
    }
    public void setBrh_ruc(String brh_ruc) {
        this.brh_ruc = brh_ruc;
    }
    public String getBrh_direction() {
        return brh_direction;
    }
    public void setBrh_direction(String brh_direction) {
        this.brh_direction = brh_direction;
    }
    public String getBrh_start_date() {
        return brh_start_date;
    }
    public void setBrh_start_date(String brh_start_date) {
        this.brh_start_date = brh_start_date;
    }
    public String getBrh_end_date() {
        return brh_end_date;
    }
    public void setBrh_end_date(String brh_end_date) {
        this.brh_end_date = brh_end_date;
    }
    public String getBrh_phone() {
        return brh_phone;
    }
    public void setBrh_phone(String brh_phone) {
        this.brh_phone = brh_phone;
    }
    public String getBrh_status() {
        return brh_status;
    }
    public void setBrh_status(String brh_status) {
        this.brh_status = brh_status;
    }
    public int getBrh_capacity() {
        return brh_capacity;
    }
    public void setBrh_capacity(int brh_capacity) {
        this.brh_capacity = brh_capacity;
    }
    public DistrictEntity getDistrict() {
        return district;
    }
    public void setDistrict(DistrictEntity district) {
        this.district = district;
    }     
}
