package com.example.springboot.Service;

import com.example.springboot.DTO.TourDTO;
import com.example.springboot.Repository.TourRepository;
import com.example.springboot.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    public List<TourDTO> findToursByArrangementId(Integer arrangementId) {
        List<Tour> tours = tourRepository.findTourByArrangementId(arrangementId);

        return tours.stream()
                .map(TourDTO::new)
                .collect(Collectors.toList());
    }

}
