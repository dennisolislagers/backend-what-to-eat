package nl.novi.backendwhattoeat.dtos;

public class MenuDto {
    private Long id;
    private String title;
    private Integer portions;
    private Integer calories;
    private Boolean peanutAllergy;
    private Boolean cowmilkAllergy;
    private Boolean glutenAllergy;

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

    public void setCuisineTypeDto(CuisineTypeDto transferToDto) {
    }
}