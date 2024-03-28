package com.project.cabbooking.driver;


import com.project.cabbooking.booking.Booking;
import com.project.cabbooking.booking.Rating;

import java.util.List;

public interface DriverService {
    Leave applyForLeave(Leave leave) throws DriverExceptions;

    List<Leave> getLeavesByDriverId(Integer driverId) throws DriverExceptions;
    DriverAccount login(String userEmailId, String userPassword) throws DriverExceptions;

    List<Booking> getBookings(Integer driverId) throws DriverExceptions;

    String getDriverName(Integer driverId) throws DriverExceptions;

    List<Rating> getDriverRatings(Integer driverId) throws DriverExceptions;
}