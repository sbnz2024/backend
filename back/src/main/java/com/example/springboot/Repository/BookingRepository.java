package com.example.springboot.Repository;

import com.example.springboot.model.Arrangement;
import com.example.springboot.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
