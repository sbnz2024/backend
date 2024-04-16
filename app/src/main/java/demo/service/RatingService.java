package demo.service;

import demo.dto.RatingDTO;
import demo.model.Arrangement;
import demo.model.Rating;
import demo.model.User;
import demo.repository.ArrangementRepository;
import demo.repository.RatingRepository;
import demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ArrangementRepository arrangementRepository;

    @Autowired
    private UserRepository userRepository;

    public RatingDTO addRating(RatingDTO ratingDTO) {
        // Kreirajte objekat Rating iz DTO
        Rating rating = new Rating();
        rating.setRatingValue(ratingDTO.getRatingValue());
        rating.setComment(ratingDTO.getComment());
        rating.setRatingDate(ratingDTO.getRatingDate());

        // Pronađite korisnika i aranžman po ID-ju
        User user = userRepository.findById(ratingDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Arrangement arrangement = arrangementRepository.findById(ratingDTO.getArrangementId()).orElseThrow(() -> new RuntimeException("Arrangement not found"));

        // Postavite korisnika i aranžman za ovu ocenu
        rating.setUser(user);
        rating.setArrangement(arrangement);

        // Sačuvajte ocenu
        Rating savedRating = ratingRepository.save(rating);

        // Dodajte ocenu u liste ocena korisnika i aranžmana
        user.getRatings().add(savedRating);
        arrangement.getRatings().add(savedRating);

        // Ažurirajte korisnika i aranžman
        userRepository.save(user);
        arrangementRepository.save(arrangement);

        return new RatingDTO(savedRating);
    }
}
