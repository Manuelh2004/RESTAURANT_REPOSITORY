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
@Table(name = "dish")
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dish_id; 
    @Column
    private String dish_name; 
    @Column
    private String dish_status; 
    @Column
    private double dish_price;      
    
    @ManyToOne
    @JoinColumn(name = "prom_id")
    private PromotionEntity promotion; 
    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardEntity card; 
   
    public DishEntity(String dish_name, String dish_status, double dish_price,
            PromotionEntity promotion, CardEntity card) {
        this.dish_name = dish_name;
        this.dish_status = dish_status;
        this.dish_price = dish_price;     
        this.promotion = promotion;
        this.card = card;
    }
    public DishEntity() {
    }

    public int getDish_id() {
        return dish_id;
    }
    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }
    public String getDish_name() {
        return dish_name;
    }
    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }
    public String getDish_status() {
        return dish_status;
    }
    public void setDish_status(String dish_status) {
        this.dish_status = dish_status;
    }
    public double getDish_price() {
        return dish_price;
    }
    public void setDish_price(double dish_price) {
        this.dish_price = dish_price;
    }   
    public PromotionEntity getPromotion() {
        return promotion;
    }
    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }
    public CardEntity getCard() {
        return card;
    }
    public void setCard(CardEntity card) {
        this.card = card;
    }         
}
