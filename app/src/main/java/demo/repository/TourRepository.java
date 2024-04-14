package demo.repository;

import demo.model.Tour;
import demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends  JpaRepository<Tour,Integer> {
}
