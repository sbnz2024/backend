package demo.controller;


import demo.dto.ArrangementDTO;
import demo.dto.RatingDTO;
import demo.service.ArrangementService;
import demo.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/ratings")
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


}
