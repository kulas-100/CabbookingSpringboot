package com.project.cabbooking.driver;

import com.project.cabbooking.booking.Rating;
import com.project.cabbooking.driver.Car;
import com.project.cabbooking.ride.Ride;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DriverAccount {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String emailId;
    private String password;
    private Double phoneNumber;
    private Double licenseNumber;

    @OneToMany
    private List<Rating> ratings = new ArrayList<>();

    @OneToOne
    @JsonIgnore
    private Car car;

    @OneToMany
    private List<Ride> rides = new ArrayList<>();

    public DriverAccount() {
    }

    public DriverAccount(String name, String emailId, String password, Double phoneNumber, Double licenseNumber, List<Rating> ratings, Car car, List<Ride> rides) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.ratings = ratings;
        this.car = car;
        this.rides = rides;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Double licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
