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
@Table(name = "detail_order")
public class DetailOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detor_id; 
    @Column 
    private double detor_amount; 
    @Column 
    private double detor_subtotal;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;    
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private DishEntity dish;    

    public DetailOrderEntity(double detor_amount, double detor_subtotal, OrderEntity order, DishEntity dish) {
        this.detor_amount = detor_amount;
        this.detor_subtotal = detor_subtotal;
        this.order = order;
        this.dish = dish;
    }
    public DetailOrderEntity() {
    }
    
    public int getDetor_id() {
        return detor_id;
    }
    public void setDetor_id(int detor_id) {
        this.detor_id = detor_id;
    }
    public double getDetor_amount() {
        return detor_amount;
    }
    public void setDetor_amount(double detor_amount) {
        this.detor_amount = detor_amount;
    }
    public double getDetor_subtotal() {
        return detor_subtotal;
    }
    public void setDetor_subtotal(double detor_subtotal) {
        this.detor_subtotal = detor_subtotal;
    }
    public OrderEntity getOrder() {
        return order;
    }
    public void setOrder(OrderEntity order) {
        this.order = order;
    }
    public DishEntity getDish() {
        return dish;
    }
    public void setDish(DishEntity dish) {
        this.dish = dish;
    }  
}
