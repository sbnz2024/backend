package com.example.springboot.model;

import com.example.springboot.DTO.TourDTO;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrangement_id", nullable = false)
    private Arrangement arrangement;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "booking_tour",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_id")
    )
    private List<Tour> selectedTours;


    @Column(name = "number_of_participants", nullable = false)
    private Integer numberOfParticipants;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    public Booking() {
    }

    public Booking(Integer id, User user, Arrangement arrangement, Date bookingDate, Integer numberOfParticipants, Double totalPrice,List<Tour> selectedTours) {
        this.id = id;
        this.user = user;
        this.arrangement = arrangement;
        this.bookingDate = bookingDate;
        this.numberOfParticipants = numberOfParticipants;
        this.totalPrice = totalPrice;
        this.selectedTours=selectedTours;
    }

    // Getters and Setters


    public List<Tour> getSelectedTours() {
        return selectedTours;
    }

    public void setSelectedTours(List<Tour> selectedTours) {
        this.selectedTours = selectedTours;
    }

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

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
