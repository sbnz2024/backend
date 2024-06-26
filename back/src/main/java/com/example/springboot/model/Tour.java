package com.example.springboot.model;

import com.example.springboot.DTO.TourDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tour")
@AllArgsConstructor
public class Tour {
    public enum TourCategory {
        HISTORICAL, CULTURAL, ADVENTURE, NATURE, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTour;

    @Column(name = "tour_name", nullable = false)
    private String tourName;

    @Column(name = "tour_description", nullable = false)
    private String tourDescription;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "participants_count")
    private Integer participantsCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private TourCategory category;

    @ManyToOne
    @JoinColumn(name = "arrangement_id")
    private Arrangement arrangement;

    @ManyToMany(mappedBy = "selectedTours", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Tour() {
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Tour(TourDTO tourDTO) {
        this.tourName = tourDTO.getTourName();
        this.tourDescription = tourDTO.getTourDescription();
        this.price = tourDTO.getPrice();
        this.totalPrice = tourDTO.getTotalPrice();
        this.participantsCount = tourDTO.getParticipantsCount();
        this.category = tourDTO.getCategory();
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    // Getteri i setteri
    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    public TourCategory getCategory() {
        return category;
    }

    public void setCategory(TourCategory category) {
        this.category = category;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }

}
