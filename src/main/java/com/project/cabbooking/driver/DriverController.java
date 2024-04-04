package com.project.cabbooking.driver;

import com.project.cabbooking.booking.Booking;
import com.project.cabbooking.booking.Rating;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"http://localhost:4200","http://localhost:3000"})
public class DriverController {
    @Autowired
    private DriverService driverService;
    @PostMapping("leave")
    public Leave applyForLeave(@RequestBody Leave leave) throws DriverExceptions {
        return this.driverService.applyForLeave(leave);
    }
    @GetMapping("leaveHistory/{driverId}")
    public List<Leave> getLeavesByDriverId(@PathVariable Integer driverId) throws DriverExceptions {
        return this.driverService.getLeavesByDriverId(driverId);
    }
    @PostMapping("driver/login")
    public DriverAccount userLogin(@RequestBody DriverLoginDto driverDto) throws DriverExceptions{
        return this.driverService.login(driverDto.getEmailId(), driverDto.getPassword());
    }

    @GetMapping("bookings/{driverId}")
    public List<Booking> driverBooking(@PathVariable Integer driverId) throws DriverExceptions{
        return this.driverService.getBookings(driverId);
    }

    @GetMapping("driver/{driverId}")
    public String driverName(@PathVariable Integer driverId) throws DriverExceptions{
        return this.driverService.getDriverName(driverId);
    }

    @GetMapping("ratings/{driverId}")
    public List<Rating> driverRatings(@PathVariable Integer driverId) throws DriverExceptions{
        return this.driverService.getDriverRatings(driverId);
    }

}