package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int not_id; 
    @Column
    private String not_message; 
    @Column
    private String status;
    
    public Notification(String not_message, String status) {
        this.not_message = not_message;
        this.status = status;
    }
    public Notification() {
    }
    
    public int getNot_id() {
        return not_id;
    }
    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }
    public String getNot_message() {
        return not_message;
    }
    public void setNot_message(String not_message) {
        this.not_message = not_message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }    
}
