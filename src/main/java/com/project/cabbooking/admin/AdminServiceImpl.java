package com.project.cabbooking.admin;
import com.project.cabbooking.booking.Booking;
import com.project.cabbooking.customer.CustomerAccount;
import com.project.cabbooking.customer.CustomerRepository;
import com.project.cabbooking.driver.*;
import com.project.cabbooking.ride.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private LeaveRepository leaveRepository;


    @Override
    public CustomerAccount registerUser(CustomerAccount account) throws AdminExceptions{
        Optional<CustomerAccount> customerOpt = customerRepository.findByCdsId(account.getCdsId());
        if (customerOpt.isPresent()) {
            throw new AdminExceptions("User already exists");
        }
        return this.customerRepository.save(account);
    }

    @Override
    public DriverAccount registerDriver(DriverAccount account) throws AdminExceptions{
        Optional<DriverAccount> driverOpt = driverRepository.findById(account.getId());
        if (driverOpt.isPresent()) {
            throw new AdminExceptions("Driver ID already exists");
        }
        return this.driverRepository.save(account);
    }

    @Override
    public Car registerCar(Car account) throws AdminExceptions{
        Optional<Car> carOpt = carRepository.findById(account.getId());
        if (carOpt.isPresent()) {
            throw new AdminExceptions("Car is already Registered");
        }
        return this.carRepository.save(account);
    }

    @Override
    public Route creatRoute(Route route)  {
        return this.routeRepository.save(route);
    }

    @Override
    public AdminAccount registerAdmin(AdminAccount account) throws AdminExceptions{
        Optional<AdminAccount> adminOpt=adminRepository.findByCdsId(account.getCdsId());
        if(adminOpt.isPresent()){
            throw new AdminExceptions("There is already admin");
        }
        return this.adminRepository.save(account);
    }

    @Override
    public List<CustomerAccount> displayAllUsers() {
        return this.customerRepository.findAll();
    }

    @Override
    public AdminAccount login(String cdsId, String password) throws AdminExceptions{
        Optional<AdminAccount> accountOpt=this.adminRepository.findByCdsId(cdsId);
        if(accountOpt.isEmpty()){
            throw new AdminExceptions("Account does not exist"+cdsId);
        }
        AdminAccount foundAccount =accountOpt.get();
        if(!foundAccount.getPassword().equals(password)){
            throw new AdminExceptions("Password is does not match");

        }
        return foundAccount;
    }

    @Override
    public List<Car> displayAllCabs() throws RouteException {
        if(carRepository.findAll().isEmpty()){
            throw new RouteException("There is no cab added");
        }
        return this.carRepository.findAll();
    }

    @Override
    public List<DriverAccount> displayAllDrivers() throws RouteException {
        if(driverRepository.findAll().isEmpty()){
            throw new RouteException("There is no driver added");
        }
        return this.driverRepository.findAll();
    }

    @Override
    public Route createRoute( Route route) throws RouteException {
//        Optional<Route> isRoutePresent=this.routeRepository.findById(route.getLocationId());
//
        boolean isRoutePresent=this.routeRepository.existsById(route.getLocationId());
        if(isRoutePresent){
            throw new RouteException("Route is already present");
        }
        return this.routeRepository.save(route);
    }

    @Override
    public Route deleteRoute(Integer routeId) throws RouteException {
        if(routeRepository.findById(routeId).isEmpty()){
            throw  new RouteException("The location does not exist");
        }
        this.routeRepository.delete(routeRepository.findById(routeId).get());

//        return Optional.empty();
        return null;
    }

    @Override
    public List<Route> displayAllLocations() throws RouteException {
        if(routeRepository.findAll().isEmpty()){
            throw new RouteException(("There is no route added to view"));
        }
        return this.routeRepository.findAll();
    }


    @Override
    public Route updateFare(Integer routeId, Double fare) throws RouteException {
        Optional<Route> routeOpt = this.routeRepository.findById(routeId);
        if(routeOpt.isEmpty()){
            throw new RouteException("Route is not present to update the fare");
        }
        Route route = routeOpt.get();
        route.setFare(fare);
        return this.routeRepository.save(route);
    }

    @Override
    public Double getFare(Integer routeId) throws RouteException {
        if(routeRepository.findById(routeId).isEmpty()){
            throw new RouteException("The Location does not exist ");
        }
        return this.routeRepository.findById(routeId).get().getFare();
    }

    @Override
    public Route getRoute(Integer id) throws RouteException{
        Optional<Route> routeOpt=this.routeRepository.findById(id);
        if(routeOpt.isPresent()){
            return routeOpt.get();
        }
        else {
            throw new RouteException("Route does not exist");
        }
    }

    @Override
    public Route updateRoute(Route route) throws RouteException{
        boolean isRoutePresent=this.routeRepository.existsById(route.getLocationId());
        if(isRoutePresent){
            return this.routeRepository.save(route);

        }
        else {
            throw new RouteException("Route is already present");
        }
    }


    @Override
    public List<List<Booking>> getAllCustomerBookings() {
        List<CustomerAccount> sortedList = customerRepository.findAll().stream().sorted(Comparator.comparing(CustomerAccount::getName)).collect(Collectors.toList());
        List<List<Booking>> bookingList = new ArrayList<>();
        for (CustomerAccount customerAccount : sortedList) {
            bookingList.add(customerAccount.getBookings());
        }
        return bookingList;
    }
    @Override
    public List<List<Ride>> getAllDriverTrips() {
        List<DriverAccount> sortedList = driverRepository.findAll().stream().sorted(Comparator.comparing(DriverAccount::getName)).collect(Collectors.toList());
        List<List<Ride>> rideList = new ArrayList<>();
        for (DriverAccount driverAccount : sortedList) {
            rideList.add(driverAccount.getRides());
        }
        return rideList;
    }

    @Override
    public Car assignRouteToCab(Integer carId, Integer routeId) throws AdminExceptions{
        Optional<Car> carOpt = this.carRepository.findById(carId);
        Optional<Route> routeOpt = this.routeRepository.findById(routeId);
        if(carOpt.isEmpty()){
            throw new AdminExceptions("Car does not exist");
        }
        if(routeOpt.isEmpty()){
            throw new AdminExceptions("Route does not exist");
        }
        Car car = carOpt.get();
        car.setRoute(routeOpt.get());
        this.carRepository.save(car);
        return car;
    }

    @Override
    public Car assignDriverToCab(Integer carId, Integer driverId) throws AdminExceptions {
        Optional<Car> carOpt = this.carRepository.findById(carId);
        Optional<DriverAccount> driverOpt = this.driverRepository.findById(driverId);
        if(carOpt.isEmpty()){
            throw new AdminExceptions("Car does not exist");
        }
        if(driverOpt.isEmpty()){
            throw new AdminExceptions("Route does not exist");
        }
        Car car = carOpt.get();
        car.setDriver(driverOpt.get());
        this.carRepository.save(car);
        DriverAccount driverAccount = driverOpt.get();
        driverAccount.setCar(car);
        this.driverRepository.save(driverAccount);
        return car;
    }

    @Override
    public Leave approveLeave(Integer leaveId) throws AdminExceptions {
        Optional<Leave> leaveOpt = leaveRepository.findById(leaveId);
        if (leaveOpt.isEmpty()) {
            throw new AdminExceptions("Leave request does not exist");
        }
        Leave leave = leaveOpt.get();
        leave.setStatus("approved");
        return leaveRepository.save(leave);
    }

    @Override
    public Leave disapproveLeave(Integer leaveId) throws AdminExceptions {
        Optional<Leave> leaveOpt = leaveRepository.findById(leaveId);
        if (leaveOpt.isEmpty()) {
            throw new AdminExceptions("Leave request does not exist");
        }
        Leave leave = leaveOpt.get();
        leave.setStatus("disapproved");
        return leaveRepository.save(leave);
    }
    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }


}
