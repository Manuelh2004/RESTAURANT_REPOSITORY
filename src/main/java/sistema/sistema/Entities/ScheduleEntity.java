package sistema.sistema.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="schedule")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shde_id;
    @Column
    private String shde_monday;
    @Column
    private String shde_tuesday;
    @Column 
    private String shde_wednesday;
    @Column 
    private String shde_thursday;
    @Column 
    private String shde_friday;
    @Column 
    private String shde_saturday;
    @Column 
    private String shde_sunday;
    @Column 
    private LocalDate shde_start_date;
    @Column 
    private String shde_status;
    @Column 
    private double shde_number_hours;

    @ManyToOne
    @JoinColumn(name = "usr_id")     
    private UserEntity usuario;    

    public ScheduleEntity(String shde_monday, String shde_tuesday, String shde_wednesday, String shde_thursday,
            String shde_friday, String shde_saturday, String shde_sunday, LocalDate shde_start_date, String shde_status,
            double shde_number_hours, UserEntity usuario) {
        this.shde_monday = shde_monday;
        this.shde_tuesday = shde_tuesday;
        this.shde_wednesday = shde_wednesday;
        this.shde_thursday = shde_thursday;
        this.shde_friday = shde_friday;
        this.shde_saturday = shde_saturday;
        this.shde_sunday = shde_sunday;
        this.shde_start_date = shde_start_date;
        this.shde_status = shde_status;
        this.shde_number_hours = shde_number_hours;
        this.usuario = usuario;
    }
    public ScheduleEntity() {
    }

    public int getShde_id() {
        return shde_id;
    }
    public void setShde_id(int shde_id) {
        this.shde_id = shde_id;
    }
    public String getShde_monday() {
        return shde_monday;
    }
    public void setShde_monday(String shde_monday) {
        this.shde_monday = shde_monday;
    }
    public String getShde_tuesday() {
        return shde_tuesday;
    }
    public void setShde_tuesday(String shde_tuesday) {
        this.shde_tuesday = shde_tuesday;
    }
    public String getShde_wednesday() {
        return shde_wednesday;
    }
    public void setShde_wednesday(String shde_wednesday) {
        this.shde_wednesday = shde_wednesday;
    }
    public String getShde_thursday() {
        return shde_thursday;
    }
    public void setShde_thursday(String shde_thursday) {
        this.shde_thursday = shde_thursday;
    }
    public String getShde_friday() {
        return shde_friday;
    }
    public void setShde_friday(String shde_friday) {
        this.shde_friday = shde_friday;
    }
    public String getShde_saturday() {
        return shde_saturday;
    }
    public void setShde_saturday(String shde_saturday) {
        this.shde_saturday = shde_saturday;
    }
    public String getShde_sunday() {
        return shde_sunday;
    }
    public void setShde_sunday(String shde_sunday) {
        this.shde_sunday = shde_sunday;
    }
    public LocalDate getShde_start_date() {
        return shde_start_date;
    }
    public void setShde_start_date(LocalDate shde_start_date) {
        this.shde_start_date = shde_start_date;
    }
    public String getShde_status() {
        return shde_status;
    }
    public void setShde_status(String shde_status) {
        this.shde_status = shde_status;
    }
    public double getShde_number_hours() {
        return shde_number_hours;
    }
    public void setShde_number_hours(double shde_number_hours) {
        this.shde_number_hours = shde_number_hours;
    }
    public UserEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }   
}
