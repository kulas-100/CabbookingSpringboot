package com.project.cabbooking.driver;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface DriverRepository extends JpaRepository<DriverAccount, Integer> {
    Optional<DriverAccount> findByEmailId(String emailID);
}
