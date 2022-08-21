package nl.novi.backendwhattoeat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Menu {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    private String title;
    private Integer portions;
    private Integer calories;
    private Boolean peanutAllergy;
    private Boolean cowmilkAllergy;
    private Boolean glutenAllergy;

    @OneToOne
    CuisineType cuisineType;

    @OneToMany(mappedBy = "menu")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    Collection<Ingredient> ingredients;

    @OneToMany(mappedBy = "menu")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    Collection<Label> labels;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Boolean getPeanutAllergy() {
        return peanutAllergy;
    }

    public void setPeanutAllergy(Boolean peanutAllergy) {
        this.peanutAllergy = peanutAllergy;
    }

    public Boolean getCowmilkAllergy() {
        return cowmilkAllergy;
    }

    public void setCowmilkAllergy(Boolean cowmilkAllergy) {
        this.cowmilkAllergy = cowmilkAllergy;
    }

    public Boolean getGlutenAllergy() {
        return glutenAllergy;
    }

    public void setGlutenAllergy(Boolean glutenAllergy) {
        this.glutenAllergy = glutenAllergy;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Collection<Label> getLabels() {
        return labels;
    }

    public void setLabels(Collection<Label> labels) {
        this.labels = labels;
    }
}


