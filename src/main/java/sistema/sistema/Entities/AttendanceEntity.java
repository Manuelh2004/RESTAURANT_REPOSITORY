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
@Table(name = "attendance")
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attend_id; 
    @Column
    private String attend_last_entry; 
    @Column
    private double attend_accumulated_hours; 
    @Column
    private double attend_attendance_counter;
    @Column
    private double attend_absence_counter;  
    @Column
    private double attend_tardy_counter; 
    
    @ManyToOne
    @JoinColumn(name = "athi_id")
    private AttendanceHistoryEntity attendance_history;    

    public AttendanceEntity(String attend_last_entry, double attend_accumulated_hours, double attend_attendance_counter,
            double attend_absence_counter, double attend_tardy_counter, AttendanceHistoryEntity attendance_history) {
        this.attend_last_entry = attend_last_entry;
        this.attend_accumulated_hours = attend_accumulated_hours;
        this.attend_attendance_counter = attend_attendance_counter;
        this.attend_absence_counter = attend_absence_counter;
        this.attend_tardy_counter = attend_tardy_counter;
        this.attendance_history = attendance_history;
    }
    public AttendanceEntity() {
    }

    public int getAttend_id() {
        return attend_id;
    }
    public void setAttend_id(int attend_id) {
        this.attend_id = attend_id;
    }
    public String getAttend_last_entry() {
        return attend_last_entry;
    }
    public void setAttend_last_entry(String attend_last_entry) {
        this.attend_last_entry = attend_last_entry;
    }
    public double getAttend_accumulated_hours() {
        return attend_accumulated_hours;
    }
    public void setAttend_accumulated_hours(double attend_accumulated_hours) {
        this.attend_accumulated_hours = attend_accumulated_hours;
    }
    public double getAttend_attendance_counter() {
        return attend_attendance_counter;
    }
    public void setAttend_attendance_counter(double attend_attendance_counter) {
        this.attend_attendance_counter = attend_attendance_counter;
    }
    public double getAttend_absence_counter() {
        return attend_absence_counter;
    }
    public void setAttend_absence_counter(double attend_absence_counter) {
        this.attend_absence_counter = attend_absence_counter;
    }
    public double getAttend_tardy_counter() {
        return attend_tardy_counter;
    }
    public void setAttend_tardy_counter(double attend_tardy_counter) {
        this.attend_tardy_counter = attend_tardy_counter;
    }
    public AttendanceHistoryEntity getAttendance_history() {
        return attendance_history;
    }
    public void setAttendance_history(AttendanceHistoryEntity attendance_history) {
        this.attendance_history = attendance_history;
    }   
}
