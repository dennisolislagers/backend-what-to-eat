package nl.novi.backendwhattoeat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodId;
    private Integer quantity;
    private String measure;
    private String foodCategory;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    List<MenuIngredient> menuIngredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public List<MenuIngredient> getMenuIngredients() {
        return menuIngredients;
    }

    public void setMenuIngredients(List<MenuIngredient> menuIngredients) {
        this.menuIngredients = menuIngredients;
    }
}
