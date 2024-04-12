package demo.service;

import demo.dto.RatingDTO;
import demo.model.Rating;
import demo.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public RatingDTO addRating(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        rating.setRatingValue(ratingDTO.getRatingValue());
        rating.setComment(ratingDTO.getComment());
        // Ovdje možete postaviti ostale potrebne atribute ratinga ako postoje
       // rating.getRatingDate();

         //Odradi dobavljanje Usera na osnovu Id-a
        // Čuvanje ocjene (ratinga) u bazi
        Rating savedRating = ratingRepository.save(rating);

        return new RatingDTO(savedRating);
    }
}
