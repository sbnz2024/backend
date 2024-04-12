package demo.service;

import demo.dto.ArrangementDTO;
import demo.model.Arrangement;
import demo.model.Tour;
import demo.repository.ArrangementRepository;
import demo.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArrangementService {

    @Autowired
    private ArrangementRepository arrangementRepository;

    @Autowired
    private TourRepository tourRepository;

    public List<Arrangement> findAll(){
        return arrangementRepository.findAll();
    }

    public ArrangementDTO addArrangement(ArrangementDTO arrangementDTO) {
        Arrangement arrangement = new Arrangement();
        arrangement.setName(arrangementDTO.getName());
        arrangement.setDescription(arrangementDTO.getDescription());
        arrangement.setPrice(arrangementDTO.getPrice());
        arrangement.setImage(arrangementDTO.getImage());
        arrangement.setType(arrangementDTO.getType());

        // Čuvanje tura u bazi
        List<Tour> tours = arrangementDTO.getTours().stream()
                .map(tourDTO -> {
                    Tour tour = new Tour();
                    tour.setTourName(tourDTO.getTourName());
                    tour.setTourDescription(tourDTO.getTourDescription());
                    tour.setPrice(tourDTO.getPrice());
                    tour.setTotalPrice(tourDTO.getTotalPrice());
                    tour.setParticipantsCount(tourDTO.getParticipantsCount());
                    tour.setCategory(tourDTO.getCategory());
                    tour.setArrangement(arrangement); // Postavljanje referenca na aranžman
                    return tour;
                })
                .collect(Collectors.toList());

        List<Tour> savedTours = tourRepository.saveAll(tours);

        // Povezivanje tura sa aranžmanom
        arrangement.setTours(savedTours);

        Arrangement savedArrangement = arrangementRepository.save(arrangement);

        return new ArrangementDTO(savedArrangement);
    }
}



