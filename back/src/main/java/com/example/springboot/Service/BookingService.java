package com.example.springboot.Service;


import com.example.springboot.DTO.ArrangementDTO;
import com.example.springboot.DTO.BookingDTO;
import com.example.springboot.DTO.TourDTO;
import com.example.springboot.Repository.ArrangementRepository;
import com.example.springboot.Repository.BookingRepository;
import com.example.springboot.Repository.TourRepository;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.model.Arrangement;
import com.example.springboot.model.Booking;
import com.example.springboot.model.Tour;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ArrangementRepository arrangementRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TourRepository tourRepository;

    public BookingDTO addBooking(BookingDTO bookingDTO) {
        User foundUser=new User();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            if (user.getId().equals(bookingDTO.getUserId())) {
                foundUser=user;
            }
        }
        // You need to implement this method
        Arrangement arrangement = arrangementRepository.findArrangementById(bookingDTO.getArrangementId()); // You need to implement this method

        if (foundUser == null || arrangement == null) {
            // Handle case where user or arrangement is not found
            return null; // or throw an exception
        }

        Booking booking = new Booking();
        List<Tour> tours=new ArrayList<>();

        for(Integer t: bookingDTO.getSelectedTours())
        {
           Tour ft= tourRepository.findTourByidTour(t);
           tours.add(ft);
        }

        Double totalP=0.0;
        for(Tour t:  tours)
        {
            totalP+=bookingDTO.getNumberOfParticipants()*t.getPrice();
        }

        booking.setTotalPrice(totalP);
        booking.setSelectedTours(tours);
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setNumberOfParticipants(bookingDTO.getNumberOfParticipants());
        booking.setTotalPrice(booking.getTotalPrice());
        booking.setArrangement(arrangement);
        booking.setUser(foundUser);
        // Assuming other properties are set as needed

        // Save the booking entity
        Booking savedBooking = bookingRepository.save(booking);

        // Return the saved booking DTO
        return new BookingDTO(
                savedBooking.getId(),
                savedBooking.getUser().getId(), // Assuming you want to return user id
                savedBooking.getArrangement().getId(), // Assuming you want to return arrangement id
                savedBooking.getBookingDate(),
                savedBooking.getSelectedToursId(), // Assuming this is populated elsewhere
                savedBooking.getNumberOfParticipants(),
                savedBooking.getTotalPrice()
        );
    }

}
