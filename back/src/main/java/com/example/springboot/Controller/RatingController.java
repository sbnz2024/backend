package com.example.springboot.Controller;

import com.example.springboot.DTO.RatingDTO;
import com.example.springboot.Service.RatingService;
import com.example.springboot.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ratings")
@CrossOrigin(origins = "*")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping(value = "/add")
    public ResponseEntity<RatingDTO> addArrangement(@RequestBody RatingDTO ratingDTO) {
        RatingDTO savedRatingDTO = ratingService.addRating(ratingDTO);
        if (savedRatingDTO != null) {
            return new ResponseEntity<>(savedRatingDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{arrangementId}")
    public ResponseEntity<List<RatingDTO>> getRating(@PathVariable Integer arrangementId) {
        var ratings = ratingService.getRatings(arrangementId);
        return new ResponseEntity<>(ratings.stream().map(RatingDTO::new).toList(), HttpStatus.OK);

    }
}
