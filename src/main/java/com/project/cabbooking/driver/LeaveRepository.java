package com.project.cabbooking.driver;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    List<Leave> findByDriverId(Integer driverId);
}
