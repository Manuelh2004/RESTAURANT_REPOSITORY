package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance_history")
public class AttendanceHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int athi_id; 

    @Column
    private double athi_absence_counter; 
    @Column
    private double athi_tardy_counter; 
    @Column
    private double athi_attendance_counter;
    @Column
    private double athi_accumulated_hours;
    @Column
    private String athi_start_date;
    @Column
    private String athi_end_date;    
   
    public AttendanceHistoryEntity(double athi_absence_counter, double athi_tardy_counter,
            double athi_attendance_counter, double athi_accumulated_hours, String athi_start_date,
            String athi_end_date) {
        this.athi_absence_counter = athi_absence_counter;
        this.athi_tardy_counter = athi_tardy_counter;
        this.athi_attendance_counter = athi_attendance_counter;
        this.athi_accumulated_hours = athi_accumulated_hours;
        this.athi_start_date = athi_start_date;
        this.athi_end_date = athi_end_date;
    }
    public AttendanceHistoryEntity() {
    }
    
    public int getAthi_id() {
        return athi_id;
    }
    public void setAthi_id(int athi_id) {
        this.athi_id = athi_id;
    }
    public double getAthi_absence_counter() {
        return athi_absence_counter;
    }
    public void setAthi_absence_counter(double athi_absence_counter) {
        this.athi_absence_counter = athi_absence_counter;
    }
    public double getAthi_tardy_counter() {
        return athi_tardy_counter;
    }
    public void setAthi_tardy_counter(double athi_tardy_counter) {
        this.athi_tardy_counter = athi_tardy_counter;
    }
    public double getAthi_attendance_counter() {
        return athi_attendance_counter;
    }
    public void setAthi_attendance_counter(double athi_attendance_counter) {
        this.athi_attendance_counter = athi_attendance_counter;
    }
    public double getAthi_accumulated_hours() {
        return athi_accumulated_hours;
    }
    public void setAthi_accumulated_hours(double athi_accumulated_hours) {
        this.athi_accumulated_hours = athi_accumulated_hours;
    }
    public String getAthi_start_date() {
        return athi_start_date;
    }
    public void setAthi_start_date(String athi_start_date) {
        this.athi_start_date = athi_start_date;
    }
    public String getAthi_end_date() {
        return athi_end_date;
    }
    public void setAthi_end_date(String athi_end_date) {
        this.athi_end_date = athi_end_date;
    }       
}
