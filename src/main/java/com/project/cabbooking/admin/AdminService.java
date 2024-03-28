package com.project.cabbooking.admin;

import com.project.cabbooking.booking.Booking;
import com.project.cabbooking.customer.CustomerAccount;
import com.project.cabbooking.driver.Car;
import com.project.cabbooking.driver.DriverAccount;
import com.project.cabbooking.driver.Leave;
import com.project.cabbooking.ride.Ride;

import java.util.List;

public interface AdminService {
    CustomerAccount registerUser(CustomerAccount account) throws AdminExceptions;

    DriverAccount registerDriver(DriverAccount account) throws AdminExceptions;
    Car registerCar(Car account) throws AdminExceptions;
    Route creatRoute(Route route);

    AdminAccount registerAdmin(AdminAccount account) throws AdminExceptions;

    List<CustomerAccount> displayAllUsers();

    AdminAccount login(String cdsId, String password) throws AdminExceptions;

    List<Car> displayAllCabs() throws RouteException;

    List<DriverAccount> displayAllDrivers() throws RouteException;
    Route createRoute( Route route) throws RouteException;
    void deleteRoute(Integer routeId) throws RouteException;

    List<Route> displayAllLocations() throws RouteException;
    Route updateFare(Integer routeId, Double fare) throws RouteException;
    Double getFare(Integer routeId) throws RouteException;

    Route getRoute(Integer id) throws RouteException;

    Route updateRoute(Route route) throws RouteException;

    //List<Booking> getAllBookings();

    List<List<Booking>> getAllCustomerBookings();

    List<List<Ride>> getAllDriverTrips();

    Car assignRouteToCab(Integer carId, Integer routeId) throws AdminExceptions;

    Car assignDriverToCab(Integer carId, Integer driverId) throws AdminExceptions;

    Leave approveLeave(Integer leaveId) throws AdminExceptions;

    Leave disapproveLeave(Integer leaveId) throws AdminExceptions;

    List<Leave> getAllLeaves();

}
