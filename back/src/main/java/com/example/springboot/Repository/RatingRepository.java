package com.example.springboot.Repository;

import com.example.springboot.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer>{
    List<Rating> findRatingByArrangementId(Integer arrangementId);
}
