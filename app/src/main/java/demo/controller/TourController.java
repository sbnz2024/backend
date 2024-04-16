package demo.controller;


import demo.dto.TourDTO;
import demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/tours")
public class TourController {


    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/byArrangement/{arrangementId}")
    public ResponseEntity<List<TourDTO>> findToursByArrangementId(@PathVariable Integer arrangementId) {
        if (arrangementId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<TourDTO> tourDTOs = tourService.findToursByArrangementId(arrangementId)
                .stream()
                .map(TourDTO::new)//OBRATI PAZNJU NA KONSTRUKTOR
                .collect(Collectors.toList());

        return new ResponseEntity<>(tourDTOs, HttpStatus.OK);
    }




}
