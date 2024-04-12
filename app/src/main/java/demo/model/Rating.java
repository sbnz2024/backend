package demo.model;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @Column(name = "rating_value", nullable = false)
    private Integer ratingValue;

    // Additional attribute for comment
    @Column(name = "comment")
    private String comment;

    // Rating date
    @Column(name = "rating_date", nullable = false)
    private LocalDate ratingDate;

    // Constructors, getters, and setters
    public Rating() {
    }

    public Rating(User user, Tour tour, Integer ratingValue, String comment, LocalDate ratingDate) {
        this.user = user;
        this.tour = tour;
        this.ratingValue = ratingValue;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
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
