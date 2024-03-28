package com.project.cabbooking.booking;

import com.project.cabbooking.driver.Car;
import com.project.cabbooking.driver.DriverAccount;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    List<Car> listOfCabs(String startLocation, String endLocation);

    PaymentDto selectCab(SelectionDto selectionDto) throws BookingExceptions;

    Booking bookCab(BookingDto bookingDto) throws BookingExceptions;

    Rating createRating(RatingDto ratingDto) throws BookingExceptions;

    List<Rating> getAllRatingsForUser(Integer userId)  throws BookingExceptions;

    Rating deleteRating(Integer ratingId,Integer customerId) throws BookingExceptions;

    BookingDto makePayment(PaymentDto paymentDto) throws BookingExceptions;

    List<Booking> findAllBookingsById(Integer customerId) throws BookingExceptions;

    Booking cancelBooking(Integer bookingId, Integer customerId) throws BookingExceptions;

    Rating updateRating(Rating rating)throws BookingExceptions;

    DriverAccount getDriverName(Integer ratingId) throws BookingExceptions;

    String getUserName(Integer userId) throws BookingExceptions;
}
