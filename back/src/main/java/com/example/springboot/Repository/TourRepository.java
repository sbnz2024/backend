package com.example.springboot.Repository;

import com.example.springboot.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {
    List<Tour> findTourByArrangementId(int arrangementId);
    Tour findTourByidTour(int id);
}
