package com.project.cabbooking.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Rating {
    @OneToOne
    @JsonIgnore
    private Booking booking;
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer driverId;
    private Float point;
    private String review;
    public Rating() {
    }



    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Integer getId() {
        return id;
    }

    public Rating(Booking booking, Integer userId, Integer driverId, Float point, String review) {
        this.booking = booking;
        this.userId = userId;
        this.driverId = driverId;
        this.point = point;
        this.review = review;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
