package com.project.cabbooking.admin;
import com.project.cabbooking.booking.Booking;
import com.project.cabbooking.customer.CustomerAccount;
import com.project.cabbooking.driver.*;
import com.project.cabbooking.ride.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
public class AdminController {

    private DriverRepository driverRepository;
    private CarRepository carRepository;
    @Autowired
    AdminService adminService;



    @PostMapping("user")
    public CustomerAccount registerUser(@RequestBody CustomerAccount account) throws AdminExceptions{
        return this.adminService.registerUser(account);
    }

    @PostMapping("admin")
    public AdminAccount registerAdmin(@RequestBody AdminAccount account)throws AdminExceptions{
        return this.adminService.registerAdmin(account);
    }

    @PostMapping("adminlogin")
    public AdminAccount loginAccount(@RequestBody AdminLoginDto logindto) throws AdminExceptions {
        return this.adminService.login(logindto.getCdsId(),logindto.getPassword());
    }

    @GetMapping("showUsers")
    public List<CustomerAccount> displayAllUsers() throws RouteException {
        return this.adminService.displayAllUsers();
    }

    @GetMapping("showDrivers")
    public List<DriverAccount> getAllDriverAccount() throws RouteException{
        return this.adminService.displayAllDrivers();
    }

    @GetMapping("showCabs")
    public List<Car> displayAllCabs() throws RouteException {
        return this.adminService.displayAllCabs();
    }

    @PostMapping("driver")
    public DriverAccount registerDriver(@RequestBody DriverAccount account) throws AdminExceptions{
        return this.adminService.registerDriver(account);
    }

    @PostMapping("cab")
    public Car registerCar(@RequestBody Car account) throws AdminExceptions{
        return this.adminService.registerCar(account);
    }

    @PostMapping("locations")
    public Route createRoute(@RequestBody Route route){
        return this.adminService.creatRoute(route);
    }

    @GetMapping("location")
    public List<Route> displayAllLocations() throws RouteException {
        return this.adminService.displayAllLocations();
    }

    @PutMapping("updatefare/{locationId}/{fare}")
    public Route updateFare(@PathVariable Integer locationId, @PathVariable Double fare) throws RouteException {
        return this.adminService.updateFare(locationId, fare);
    }

    @PutMapping("updateRoute")
    public Route updateRoute(@RequestBody Route route)throws RouteException{
        return this.adminService.updateRoute(route);
    }

    @GetMapping("location/{id}")
    public Route getRoute(@PathVariable Integer id)throws RouteException{
        return this.adminService.getRoute(id);
    }
    @GetMapping("getfare/{locationId}")
    public Double getFare(@PathVariable Integer locationId) throws RouteException {
        return this.adminService.getFare(locationId);
    }

    @GetMapping("customerbookings")
    public List<List<Booking>> CustomerBookings(){
        return this.adminService.getAllCustomerBookings();
    }

    @GetMapping("drivertrips")
    public List<List<Ride>> driverTrips(){
        return this.adminService.getAllDriverTrips();
    }

    @PutMapping("assignRoute")
    public Car assignRouteToCab(@RequestBody AssignRouteDto assignRouteDto) throws AdminExceptions{
        return this.adminService.assignRouteToCab(assignRouteDto.getCarId(), assignRouteDto.getRouteId());
    }

    @PutMapping("assignDriver")
    public Car assignDriverToCar(@RequestBody AssignDriverDto assignDriverDto)throws AdminExceptions{
        return this.adminService.assignDriverToCab(assignDriverDto.getCarId(), assignDriverDto.getDriverId());
    }

    @PutMapping("approveLeave/{leaveId}")
    public Leave approveLeave(@PathVariable Integer leaveId) throws AdminExceptions {
        return this.adminService.approveLeave(leaveId);
    }

    @PutMapping("disapproveLeave/{leaveId}")
    public Leave disapproveLeave(@PathVariable Integer leaveId) throws AdminExceptions {
        return this.adminService.disapproveLeave(leaveId);
    }
    @GetMapping("allLeaves")
    public List<Leave> getAllLeaves() throws AdminExceptions {
        return this.adminService.getAllLeaves();
    }


}
