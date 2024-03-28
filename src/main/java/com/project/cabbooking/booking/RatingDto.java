package com.project.cabbooking.booking;

public class RatingDto {
    private Integer bookingId;
    private Rating rating;

    public RatingDto(Integer bookingId, Rating rating) {
        this.bookingId = bookingId;
        this.rating = rating;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}