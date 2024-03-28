package com.project.cabbooking.booking;

import com.project.cabbooking.driver.DriverAccount;
import com.project.cabbooking.driver.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.cabbooking.driver.Car;
import com.project.cabbooking.driver.CarRepository;
import com.project.cabbooking.customer.CustomerAccount;
import com.project.cabbooking.customer.CustomerRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private DriverRepository driverRepository;


    @Override
    public List<Car> listOfCabs(String startLocation, String endLocation) {
        List<Car> allCarsList = new ArrayList<>();
        allCarsList = this.carRepository.findAll();
        List<Car> carsList = new ArrayList<>();
        for(Car car : allCarsList){
            if(car.getRoute().getStartLocation().equalsIgnoreCase(startLocation) && car.getRoute().getEndLocation().equalsIgnoreCase(endLocation)){
                carsList.add(car);
            }
        }
        return carsList;
    }

    @Override
    public PaymentDto selectCab(SelectionDto selectionDto) throws BookingExceptions {
        Optional<Car> carOpt = this.carRepository.findById(selectionDto.getCabId());
        if(carOpt.isEmpty()){
            throw new BookingExceptions("Cab does not exist");
        }
        Car car = carOpt.get();
        Double fare = car.getRoute().getFare();
        Integer cabId = car.getId();
        Integer userId = selectionDto.getUserId();
        PaymentDto paymentDto = new PaymentDto(userId, cabId, fare);
        return paymentDto;
    }

    @Override
    public Booking bookCab(BookingDto bookingDto) throws BookingExceptions {
        Optional<Payment> paymentOpt = paymentRepository.findById(bookingDto.getPaymentId());
        if(!bookingDto.getStatus().equals("Success") || paymentOpt.isEmpty()){
            throw new BookingExceptions("Booking unsuccessful due to failed payment");
        }
        Payment payment = paymentOpt.get();
        Optional<Car> carOpt = this.carRepository.findById(bookingDto.getCabId());
        if(carOpt.isEmpty()){
            throw new BookingExceptions("Cab does not exist");
        }
        Car car = carOpt.get();
        Optional<CustomerAccount> userOpt = customerRepository.findById(bookingDto.getCustomerId());
        CustomerAccount user = userOpt.get();
        if(car.getAvailableSeats() == 0){
            throw new BookingExceptions("Cab full!");
        }
        car.setAvailableSeats(car.getAvailableSeats()-1);
        this.carRepository.save(car);
        Booking booking = new Booking();

        String startLocation = car.getRoute().getStartLocation();
        String endLocation = car.getRoute().getEndLocation();
        LocalDate bookingDate = bookingDto.getDate();
        LocalTime bookingTime = LocalTime.now();
        String status = "Success";
        Double fare = bookingDto.getAmount();

        booking.setStartLocation(startLocation);
        booking.setEndLocation(endLocation);
        booking.setBookingDate(bookingDate);
        booking.setBookingTime(bookingTime);
        booking.setStatus(status);
        booking.setFare(fare);
        booking.setCar(car);
        booking.setPayment(payment);

        user.getBookings().add(booking);

        this.bookingRepository.save(booking);
        this.customerRepository.save(user);

        return booking;
    }

    @Override
    public Booking cancelBooking(Integer bookingId,Integer customerId) throws BookingExceptions {
        boolean found = false;
        Optional<Booking> bookingOpt = this.bookingRepository.findById(bookingId);
        Optional<CustomerAccount> customerOpt = this.customerRepository.findById(customerId);
        if (bookingOpt.isEmpty()) {
            throw new BookingExceptions("Bookings not found!");
        }
        if(customerOpt.isEmpty()){
            throw new BookingExceptions("Customer not found");
        }

        CustomerAccount customer = customerOpt.get();
        List<Booking> bookingList = customer.getBookings();
        for(Booking bookingItr: bookingList){
            if(bookingItr.getId() == bookingId){
                found = true;
            }
        }
        if(!found){
            throw new BookingExceptions("Booking not found for user");
        }

        Booking booking = bookingOpt.get();
        Car car = booking.getCar();

        if (car == null) {
            throw new BookingExceptions("Cab does not exist");
        }
        car.setAvailableSeats(car.getAvailableSeats() + 1);
        booking.setStatus("Cancelled");

        customer.setBookings(bookingList);
        this.bookingRepository.save(booking);
        this.customerRepository.save(customer);
        this.carRepository.save(car);

        return booking;
    }

    @Override
    public List<Booking> findAllBookingsById(Integer customerId) throws BookingExceptions {

        Optional<CustomerAccount> customerAccountOpt = this.customerRepository.findById(customerId);
        if(customerAccountOpt.isPresent()){
            CustomerAccount user = customerAccountOpt.get();
            List<Booking> bookingsList = user.getBookings();
            return bookingsList;
        }
        else{
            throw new BookingExceptions("Account does not exist");
        }
    }
    //

    @Override
    public Rating createRating(RatingDto ratingDto) throws BookingExceptions{
        Integer bookingId=ratingDto.getBookingId();
        Rating rating=ratingDto.getRating();
        Optional<Booking> bookingOpt = this.bookingRepository.findById(bookingId);
        if (bookingOpt.isEmpty()) {
            throw new BookingExceptions("Bookings not found!");
        }
        Booking booking = bookingOpt.get();
        booking.setRating(rating);
        rating.setBooking(booking);
        //this.bookingRepository.save(booking);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatingsForUser(Integer userId) {
        List<Rating> rating= ratingRepository.findAllByUserId(userId);
        return rating;
        //rating.stream().sorted(Comparator.comparing(Rating::getBooking().)
    }

    @Override
    public Rating deleteRating(Integer ratingId,Integer customerId) throws BookingExceptions{
        Optional<Rating> ratingOpt = this.ratingRepository.findById(ratingId);
        Optional<CustomerAccount> customerOpt = this.customerRepository.findById(customerId);
        if (ratingOpt.isPresent()) {
            ratingOpt.get().getBooking().setRating(null);
            this.ratingRepository.deleteById(ratingId);
        } else {
            throw new BookingExceptions("Exception occured.There is no such rating exists!");
        }
        return ratingOpt.get();
    }

    @Override
    public Rating updateRating(Rating rating) throws BookingExceptions{
        Optional<Rating> ratingOpt = this.ratingRepository.findById(rating.getId());
        if (ratingOpt.isPresent()) {
            Rating updatedRating = ratingOpt.get();
            updatedRating.setPoint(rating.getPoint());
            updatedRating.setReview(rating.getReview());
            Booking booking = ratingOpt.get().getBooking();
            booking.setRating(ratingOpt.get());
            updatedRating.setBooking(booking);
            return this.ratingRepository.save(updatedRating);
        } else {
            throw new BookingExceptions("Exception occured.There is no such rating exists!");
        }
    }

    @Override
    public DriverAccount getDriverName(Integer ratingId) throws BookingExceptions {
        Optional<Rating> ratingOpt = this.ratingRepository.findById(ratingId);
        if (ratingOpt.isPresent()) {
            Integer driverId = ratingOpt.get().getDriverId();
            Optional<DriverAccount> driverOpt = this.driverRepository.findById(driverId);
            if(driverOpt.isPresent()){
                return driverOpt.get();
            }
            else{
                throw new BookingExceptions("Driver does not exist");
            }
        } else {
            throw new BookingExceptions("Exception occured.There is no such rating exists!");
        }
    }

    @Override
    public String getUserName(Integer userId) throws BookingExceptions {
        return this.customerRepository.findById(userId).get().getName();
    }

    //payment
    @Override
    public BookingDto makePayment(PaymentDto paymentDto) throws BookingExceptions{
        Payment payment = new Payment();
        payment.setCustomerId(paymentDto.getCustomerId());
        payment.setCabId(paymentDto.getCabId());
        payment.setAmount(paymentDto.getFare());
        payment.setDate(LocalDate.now());
        payment.setStatus("Success");
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setId(payment.getId());


        Payment savedPayment = paymentRepository.save(payment);

        BookingDto result = new BookingDto();
        result.setCustomerId(savedPayment.getCustomerId());
        result.setCabId(savedPayment.getCabId());
        result.setAmount(savedPayment.getAmount());
        result.setDate(savedPayment.getDate());
        result.setStatus(savedPayment.getStatus());
        result.setPaymentMethod(savedPayment.getPaymentMethod());
        result.setPaymentId(savedPayment.getId());

        return result;
    }

}
