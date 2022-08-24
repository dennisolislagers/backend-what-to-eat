package nl.novi.backendwhattoeat.dtos;

public class MenuDto {
    private Long id;
    private String title;
    private Integer portions;
    private Integer calories;
    private String cuisineType;
    private String mealType;
    private String dishType;
    private Boolean vegan;
    private Boolean peanutAllergy;
    private Boolean cowmilkAllergy;
    private Boolean glutenAllergy;

    private PhotoDto photoDto;

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

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
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

    public PhotoDto getPhotoDto() {
        return photoDto;
    }

    public void setPhotoDto(PhotoDto photoDto) {
        this.photoDto = photoDto;
    }
}