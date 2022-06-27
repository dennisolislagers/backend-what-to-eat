package nl.novi.backendwhattoeat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
public class Menu {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    private String title;
    private String cuisineType;
    private String healthLabel;
    private String dietLabel;
    private Integer portions;
    private Integer calories;
    private Boolean hasPhoto;

    @OneToMany (mappedBy = "menu")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    Collection<MenuIngredient> menuIngredients;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;




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

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getHealthLabel() {
        return healthLabel;
    }

    public void setHealthLabel(String healthLabel) {
        this.healthLabel = healthLabel;
    }

    public String getDietLabel() {
        return dietLabel;
    }

    public void setDietLabel(String dietLabel) {
        this.dietLabel = dietLabel;
    }

    public Boolean getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(Boolean hasPhoto) {
        this.hasPhoto = hasPhoto;
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

}


