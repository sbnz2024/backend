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
    private List<TourDTO> selectedTours;
    private Integer numberOfParticipants;
    private Double totalPrice;

    public BookingDTO() {
    }





    public BookingDTO(Integer id, Integer id1, Integer id2, Date bookingDate, List<Tour> selectedTours, Integer numberOfParticipants, Double totalPrice) {

        this.id = id;
        this.userId = userId;
        this.arrangementId = arrangementId;
        this.bookingDate = bookingDate;
        // Assuming you have a conversion method from Tour to TourDTO
        this.selectedTours = selectedTours.stream().map(TourDTO::new).collect(Collectors.toList());
        this.numberOfParticipants = numberOfParticipants;
        this.totalPrice = totalPrice;




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

    public List<TourDTO> getSelectedTours() {
        return selectedTours;
    }

    public void setSelectedTours(List<TourDTO> selectedTours) {
        this.selectedTours = selectedTours;
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
