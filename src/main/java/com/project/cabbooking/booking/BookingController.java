package com.project.cabbooking.booking;

import com.project.cabbooking.driver.Car;
import com.project.cabbooking.driver.DriverAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"http://localhost:4200/","http://localhost:3000"})
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("cabs")
    public List<Car> listOfCabs(@RequestBody LocationDto locationDto){
        return this.bookingService.listOfCabs(locationDto.getStartLocation(), locationDto.getEndLocation());
    }

    @PostMapping("selectCab")
    public PaymentDto selectCab(@RequestBody SelectionDto selectionDto)throws BookingExceptions{
        return this.bookingService.selectCab(selectionDto);
    }

    @PostMapping("bookCab")
    public Booking bookCab(@RequestBody BookingDto bookingDto) throws BookingExceptions{
        return this.bookingService.bookCab(bookingDto);
    }

    @DeleteMapping("bookings/{bookingId}/{customerId}")
    public Booking cancelBooking(@PathVariable Integer bookingId, @PathVariable Integer customerId) throws BookingExceptions{
        return this.bookingService.cancelBooking(bookingId, customerId);
    }

    @GetMapping("bookings/id/{id}")
    public List<Booking> findAllAccountByName(@PathVariable("id") Integer customerId)throws BookingExceptions{
        return this.bookingService.findAllBookingsById(customerId);
    }

    //ratings
    @PostMapping("rating")
    public Rating createRating(@RequestBody RatingDto ratingDto) throws BookingExceptions{
        return bookingService.createRating(ratingDto);
    }

    @GetMapping("rating/user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable Integer userId) throws BookingExceptions{
        return bookingService.getAllRatingsForUser(userId);
    }

    @DeleteMapping("rating/{ratingId}/{customerId}")
    public void deleteRating(@PathVariable Integer ratingId,@PathVariable Integer customerId) throws BookingExceptions{
        bookingService.deleteRating(ratingId,customerId);
    }

    @PutMapping("updaterating")
    public Rating updateRating(@RequestBody Rating rating) throws BookingExceptions{
        return this.bookingService.updateRating(rating);
    }
    //payment
    @PostMapping("payment/makePayment")
    public BookingDto makePayment(@RequestBody PaymentDto paymentDto) throws BookingExceptions {
        return bookingService.makePayment(paymentDto);

    }

    @GetMapping("drivername/{ratingId}")
    public DriverAccount getDriverName(@PathVariable Integer ratingId) throws BookingExceptions{
        return bookingService.getDriverName(ratingId);
    }

    @GetMapping("userName/{userId}")
    public String getUserName(@PathVariable Integer userId) throws BookingExceptions{
        return bookingService.getUserName(userId);
    }
}
