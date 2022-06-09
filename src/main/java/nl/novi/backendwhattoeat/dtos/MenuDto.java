package nl.novi.backendwhattoeat.dtos;

public class MenuDto {
    private Long id;
    private String title;
    private String cuisineType;
    private String healthLabel;
    private String dietLabel;
    private Boolean hasPhoto;
    private Integer rating;

    private CommentDto commentDto;
    private RatingDto ratingDto;

    public MenuDto(){
    }

    public MenuDto(Long id, String title, String cuisineType, String healthLabel, String dietLabel, Boolean hasPhoto, Integer rating){
        this.id = id;
        this.title = title;
        this.cuisineType = cuisineType;
        this.healthLabel = healthLabel;
        this.dietLabel = dietLabel;
        this.hasPhoto = hasPhoto;
        this.rating = rating;
    }

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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public CommentDto getCommentDto() {
        return commentDto;
    }

    public void setCommentDto(CommentDto commentDto) {
        this.commentDto = commentDto;
    }

    public RatingDto getRatingDto() {
        return ratingDto;
    }

    public void setRatingDto(RatingDto ratingDto) {
        this.ratingDto = ratingDto;
    }

    public void setCalories(Integer calories) {
    }

    public void setPortions(Integer portions) {
    }
}