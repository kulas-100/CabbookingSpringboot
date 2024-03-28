package com.project.cabbooking.ride;

import com.project.cabbooking.driver.DriverAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Ride {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate rideDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double fare;
    private String status;

    @OneToOne
    private DriverAccount driver;

    public Ride() {
    }

    public Ride(LocalDate rideDate, LocalTime startTime, LocalTime endTime, Double fare, String status, DriverAccount driver) {
        this.rideDate = rideDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fare = fare;
        this.status = status;
        this.driver = driver;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRideDate() {
        return rideDate;
    }

    public void setRideDate(LocalDate rideDate) {
        this.rideDate = rideDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DriverAccount getDriver() {
        return driver;
    }

    public void setDriver(DriverAccount driver) {
        this.driver = driver;
    }
    
}
