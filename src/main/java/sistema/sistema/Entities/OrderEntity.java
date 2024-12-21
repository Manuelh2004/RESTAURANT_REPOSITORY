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
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id; 
    @Column
    private String order_status; 
    @Column
    private double order_total; 
    @Column
    private String order_date_time;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private UserEntity users;
    @ManyToOne
    @JoinColumn(name = "cli_id")
    private ClientEntity client;          
    @ManyToOne
    @JoinColumn(name = "table_id")
    private TableEntity table;
    @ManyToOne
    @JoinColumn(name = "shod_id")
    private ShippingMethodEntity shipping_method;
    
    public OrderEntity(String order_status, double order_total, String order_date_time, UserEntity users,
            ClientEntity client, TableEntity table, ShippingMethodEntity shipping_method) {
        this.order_status = order_status;
        this.order_total = order_total;
        this.order_date_time = order_date_time;
        this.users = users;
        this.client = client;
        this.table = table;
        this.shipping_method = shipping_method;
    }
    public OrderEntity() {
    }

    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public String getOrder_status() {
        return order_status;
    }
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
    public double getOrder_total() {
        return order_total;
    }
    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }
    public String getOrder_date_time() {
        return order_date_time;
    }
    public void setOrder_date_time(String order_date_time) {
        this.order_date_time = order_date_time;
    }
    public UserEntity getUsers() {
        return users;
    }
    public void setUsers(UserEntity users) {
        this.users = users;
    }
    public ClientEntity getClient() {
        return client;
    }
    public void setClient(ClientEntity client) {
        this.client = client;
    }
    public TableEntity getTable() {
        return table;
    }
    public void setTable(TableEntity table) {
        this.table = table;
    }
    public ShippingMethodEntity getShipping_method() {
        return shipping_method;
    }
    public void setShipping_method(ShippingMethodEntity shipping_method) {
        this.shipping_method = shipping_method;
    }                       
}
