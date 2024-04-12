package demo.dto;

import demo.model.Rating;

import java.time.LocalDate;

public class RatingDTO {

    private Integer userId;
    private Integer tourId;
    private Integer ratingValue;
    private String comment;
    private LocalDate ratingDate;

    public RatingDTO() {
    }

    public RatingDTO(Integer userId, Integer tourId, Integer ratingValue, String comment, LocalDate ratingDate) {
        this.userId = userId;
        this.tourId = tourId;
        this.ratingValue = ratingValue;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }

    public RatingDTO(Rating rating) {
        this.userId = rating.getUser().getId();
        this.tourId = rating.getTour().getIdTour();
        this.ratingValue = rating.getRatingValue();
        this.comment = rating.getComment();
        this.ratingDate = rating.getRatingDate();
    }

    // Getteri i setteri

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Integer ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDate ratingDate) {
        this.ratingDate = ratingDate;
    }
}
