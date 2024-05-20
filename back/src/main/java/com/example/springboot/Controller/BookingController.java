package com.example.springboot.Controller;


import com.example.springboot.DTO.ArrangementDTO;
import com.example.springboot.DTO.BookingDTO;
import com.example.springboot.Service.ArragementService;
import com.example.springboot.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(value = "/add")
    public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO savedBookingDTO = bookingService.addBooking(bookingDTO);
        if (savedBookingDTO != null) {
            return new ResponseEntity<>(savedBookingDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
