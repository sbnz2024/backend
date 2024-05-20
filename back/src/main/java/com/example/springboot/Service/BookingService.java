package com.example.springboot.Service;


import com.example.springboot.DTO.ArrangementDTO;
import com.example.springboot.DTO.BookingDTO;
import com.example.springboot.DTO.TourDTO;
import com.example.springboot.Repository.ArrangementRepository;
import com.example.springboot.Repository.BookingRepository;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.model.Arrangement;
import com.example.springboot.model.Booking;
import com.example.springboot.model.Tour;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



        booking.setUser(foundUser);
        booking.setArrangement(arrangement);


        List<TourDTO> tourDTOList = bookingDTO.getSelectedTours().stream()
                .map(tour -> new TourDTO(
                        tour.getTourName(),
                        tour.getTourDescription(),
                        tour.getPrice(),
                        tour.getTotalPrice(),
                        tour.getParticipantsCount(), // Add this line to include participantsCount
                        tour.getCategory() // Add this line to include category
                ))
                .collect(Collectors.toList());

        List<Tour> tourList = tourDTOList.stream()
                .map(Tour::new) // Convert TourDTO to Tour using the constructor
                .collect(Collectors.toList());

// Set the converted list of TourDTO objects
        booking.setSelectedTours(tourList);


        Double pay=0.;
        for(Tour t: booking.getSelectedTours())
        {
            t.setTotalPrice(t.getPrice()*t.getParticipantsCount());
            pay+=t.getPrice()*t.getParticipantsCount();
        }




        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setNumberOfParticipants(bookingDTO.getNumberOfParticipants());
        booking.setTotalPrice(pay);
        // Assuming other properties are set as needed

        // Save the booking entity
        Booking savedBooking = bookingRepository.save(booking);

        // Return the saved booking DTO
        return new BookingDTO(
                savedBooking.getId(),
                savedBooking.getUser().getId(), // Assuming you want to return user id
                savedBooking.getArrangement().getId(), // Assuming you want to return arrangement id
                savedBooking.getBookingDate(),
                savedBooking.getSelectedTours(), // Assuming this is populated elsewhere
                savedBooking.getNumberOfParticipants(),
                savedBooking.getTotalPrice()
        );
    }

}
