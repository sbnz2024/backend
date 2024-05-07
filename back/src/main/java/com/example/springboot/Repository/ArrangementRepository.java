package com.example.springboot.Repository;

import com.example.springboot.model.Arrangement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArrangementRepository extends JpaRepository<Arrangement, Integer>{
    Arrangement findByName(String name);
    Arrangement findByPrice(Double price);
    Arrangement findByType(Arrangement.ArrangementType type);
    Arrangement findByImage(String image);
    Arrangement findByDescription(String description);
    Arrangement findArrangementById(Integer id);
}
