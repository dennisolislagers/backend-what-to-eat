package nl.novi.backendwhattoeat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String sort;
    private String amount;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    List<MenuIngredient> menuIngredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTitle(String productName) {
        this.productName = productName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<MenuIngredient> getMenuIngredients() {
        return menuIngredients;
    }

    public void setMenuIngredients(List<MenuIngredient> menuIngredients) {
        this.menuIngredients = menuIngredients;
    }
}
