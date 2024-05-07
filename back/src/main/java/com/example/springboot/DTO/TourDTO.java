package com.example.springboot.DTO;

import com.example.springboot.model.Tour;

public class TourDTO {
     private String tourName;
    private String tourDescription;
    private Double price;
    private Double totalPrice;
    private Integer participantsCount;
    private Tour.TourCategory category;

    public TourDTO() {
    }

    public TourDTO(String tourName, String tourDescription, Double price, Double totalPrice, Integer participantsCount, Tour.TourCategory category) {
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.price = price;
        this.totalPrice = totalPrice;
        this.participantsCount = participantsCount;
        this.category = category;
    }

    public TourDTO(Tour tour) {
        this.tourName = tour.getTourName();
        this.tourDescription = tour.getTourDescription();
        this.price = tour.getPrice();
        this.totalPrice = tour.getTotalPrice();
        this.participantsCount = tour.getParticipantsCount();
        this.category = tour.getCategory();
    }

    public TourDTO(TourDTO tourDTO) {
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

    public Tour.TourCategory getCategory() {
        return category;
    }

    public void setCategory(Tour.TourCategory category) {
        this.category = category;
    }
}
