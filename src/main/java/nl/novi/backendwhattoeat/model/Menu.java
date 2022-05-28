package nl.novi.backendwhattoeat.model;

import javax.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue
    Long id;

    @Column
    private String title;
    private String cuisineType;
    private String healthLabel;
    private String dietLabel;
    private Boolean hasPhoto;
    private int rating;

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
