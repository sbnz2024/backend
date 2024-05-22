package com.example.springboot.DTO;

import com.example.springboot.model.Tour;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookingDTO {

    private Integer id;
    private Integer userId;
    private Integer arrangementId;
    private Date bookingDate;
    private List<Integer> selectedTours;
    private Integer numberOfParticipants;
    private Double totalPrice;

    public BookingDTO() {
    }


    public BookingDTO(Integer id, Integer userId, Integer arrangementId, Date bookingDate, List<Integer> selectedTours, Integer numberOfParticipants, Double totalPrice) {
        this.id = id;
        this.userId = userId;
        this.arrangementId = arrangementId;
        this.bookingDate = bookingDate;
        this.selectedTours = selectedTours;
        this.numberOfParticipants = numberOfParticipants;
        this.totalPrice = totalPrice;
    }

    public List<Integer> getSelectedTours() {
        return selectedTours;
    }

    public void setSelectedTours(List<Integer> selectedTours) {
        this.selectedTours = selectedTours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArrangementId() {
        return arrangementId;
    }

    public void setArrangementId(Integer arrangementId) {
        this.arrangementId = arrangementId;
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
