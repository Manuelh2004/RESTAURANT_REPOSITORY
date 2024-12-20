package sistema.sistema.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance_record")
public class AttendanceRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int atre_id;
    @Column
    private double atre_hours_done; 
    @Column
    private String atre_schedule; 
    @Column
    private String atre_hour_entry; 

    @ManyToOne
    @JoinColumn(name = "attend_id")
    @JsonIgnore
    private AttendanceEntity attendance;
    @ManyToOne
    @JoinColumn(name = "usr_id")
    private UserEntity users;    

    public AttendanceRecordEntity(double atre_hours_done, String atre_schedule, String atre_hour_entry,
            AttendanceEntity attendance, UserEntity users) {
        this.atre_hours_done = atre_hours_done;
        this.atre_schedule = atre_schedule;
        this.atre_hour_entry = atre_hour_entry;
        this.attendance = attendance;
        this.users = users;
    }
    public AttendanceRecordEntity() {
    }
    
    public int getAtre_id() {
        return atre_id;
    }
    public void setAtre_id(int atre_id) {
        this.atre_id = atre_id;
    }
    public double getAtre_hours_done() {
        return atre_hours_done;
    }
    public void setAtre_hours_done(double atre_hours_done) {
        this.atre_hours_done = atre_hours_done;
    }
    public String getAtre_schedule() {
        return atre_schedule;
    }
    public void setAtre_schedule(String atre_schedule) {
        this.atre_schedule = atre_schedule;
    }
    public String getAtre_hour_entry() {
        return atre_hour_entry;
    }
    public void setAtre_hour_entry(String atre_hour_entry) {
        this.atre_hour_entry = atre_hour_entry;
    }
    public AttendanceEntity getAttendance() {
        return attendance;
    }
    public void setAttendance(AttendanceEntity attendance) {
        this.attendance = attendance;
    }
    public UserEntity getUsers() {
        return users;
    }
    public void setUsers(UserEntity users) {
        this.users = users;
    }         
}
