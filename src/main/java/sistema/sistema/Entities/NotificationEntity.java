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
@Table(name = "notification")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int not_id; 
    @Column
    private String not_message; 
    @Column
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "usr_id")
    private UserEntity users;        

    public NotificationEntity(String not_message, String status, UserEntity users) {
        this.not_message = not_message;
        this.status = status;
        this.users = users;
    }
    public NotificationEntity() {
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
    public UserEntity getUsers() {
        return users;
    }
    public void setUsers(UserEntity users) {
        this.users = users;
    }    
}
