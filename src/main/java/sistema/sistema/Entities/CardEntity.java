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
@Table(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int card_id; 
    @Column
    private String card_name; 
    @Column
    private String card_description; 
    @Column
    private String card_status; 
    @Column
    private String card_start_date; 
    @Column
    private String card_end_date; 

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private CategoryEntity category;    

    public CardEntity(String card_name, String card_description, String card_status, String card_start_date,
            String card_end_date, CategoryEntity category) {
        this.card_name = card_name;
        this.card_description = card_description;
        this.card_status = card_status;
        this.card_start_date = card_start_date;
        this.card_end_date = card_end_date;
        this.category = category;
    }
    public CardEntity() {
    }
    
    public int getCard_id() {
        return card_id;
    }
    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }
    public String getCard_name() {
        return card_name;
    }
    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }
    public String getCard_description() {
        return card_description;
    }
    public void setCard_description(String card_description) {
        this.card_description = card_description;
    }
    public String getCard_status() {
        return card_status;
    }
    public void setCard_status(String card_status) {
        this.card_status = card_status;
    }
    public String getCard_start_date() {
        return card_start_date;
    }
    public void setCard_start_date(String card_start_date) {
        this.card_start_date = card_start_date;
    }
    public String getCard_end_date() {
        return card_end_date;
    }
    public void setCard_end_date(String card_end_date) {
        this.card_end_date = card_end_date;
    }
    public CategoryEntity getCategory() {
        return category;
    }
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }     
}
