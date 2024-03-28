package com.project.cabbooking.driver;


import com.project.cabbooking.admin.Route;
import com.project.cabbooking.booking.Booking;
import com.project.cabbooking.driver.DriverAccount;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String carNumber;
    private Integer capacity;
    private Integer availableSeats;

    @OneToOne
    private DriverAccount driver;

    @OneToMany
    private List<Booking> bookings = new ArrayList<>();

    @OneToOne
    private Route route;

    public Car() {
    }

    public Car(String type, String carNumber, Integer capacity, Integer availableSeats, DriverAccount driver, List<Booking> bookings, Route route) {
        this.type = type;
        this.carNumber = carNumber;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.driver = driver;
        this.bookings = bookings;
        this.route = route;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public DriverAccount getDriver() {
        return driver;
    }

    public void setDriver(DriverAccount driver) {
        this.driver = driver;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
