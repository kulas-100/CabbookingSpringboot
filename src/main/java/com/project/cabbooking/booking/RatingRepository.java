package com.project.cabbooking.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findAllByDriverId(Integer driverId);
    List<Rating> findAllByUserId(Integer userId);
}