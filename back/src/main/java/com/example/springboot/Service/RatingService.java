package com.example.springboot.Service;

import com.example.springboot.DTO.RatingDTO;
import com.example.springboot.Repository.ArrangementRepository;
import com.example.springboot.Repository.RatingRepository;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.model.Arrangement;
import com.example.springboot.model.Rating;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.Local;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ArrangementRepository arrangementRepository;
    @Autowired
    private UserRepository userRepository;

    public RatingDTO addRating(RatingDTO ratingDTO) {
        User user = userRepository.findById(ratingDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Arrangement arrangement = arrangementRepository.findById(ratingDTO.getArrangementId()).orElseThrow(() -> new RuntimeException("Arrangement not found"));

        Rating rating = new Rating();
        rating.setRatingValue(ratingDTO.getRatingValue());
        rating.setComment(ratingDTO.getComment());
        rating.setArrangement(arrangement);
        rating.setUser(user);
        rating.setRatingDate(LocalDate.now());
        ratingRepository.save(rating);

        user.getRatings().add(rating);
        arrangement.getRatings().add(rating);

        userRepository.save(user);
        arrangementRepository.save(arrangement);
        return new RatingDTO(rating);
    }


    public List<Rating> getRatings(Integer arrangementId) {
        return ratingRepository.findRatingByArrangementId(arrangementId);
    }
}
