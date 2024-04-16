package demo.service;

import demo.dto.TourDTO;
import demo.model.Tour;
import demo.repository.ArrangementRepository;
import demo.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {



    @Autowired
    private TourRepository tourRepository;

    public List<TourDTO> findToursByArrangementId(Integer arrangementId) {
        List<Tour> tours = tourRepository.findAll();

        return tours.stream()
                .filter(tour -> tour.getArrangement().getId().equals(arrangementId))
                .map(TourDTO::new)
                .collect(Collectors.toList());
    }


}
