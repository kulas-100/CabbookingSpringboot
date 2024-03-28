package com.project.cabbooking.driver;

import com.project.cabbooking.booking.Booking;
import com.project.cabbooking.booking.BookingRepository;
import com.project.cabbooking.booking.Rating;
import com.project.cabbooking.booking.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Leave applyForLeave(Leave leave) throws DriverExceptions{
        leave.setStatus("applied");
        Leave newLeave = leave;
        return leaveRepository.save(newLeave);
    }
    @Override
    public List<Leave> getLeavesByDriverId(Integer driverId) throws DriverExceptions{
        return leaveRepository.findByDriverId(driverId);
    }
    @Override
    public DriverAccount login(String userEmailId, String userPassword) throws DriverExceptions {
        Optional<DriverAccount> driverOpt = this.driverRepository.findByEmailId(userEmailId);
        if(driverOpt.isEmpty()){
            throw new DriverExceptions("Account does not exist");
        }
        DriverAccount foundAccount = driverOpt.get();
        if(!foundAccount.getPassword().equals(userPassword)){
            throw new DriverExceptions("Password Incorrect");
        }
        return foundAccount;
    }

    @Override
    public List<Booking> getBookings(Integer driverId) throws DriverExceptions {

        Optional<DriverAccount> driverOpt = this.driverRepository.findById(driverId);
        if(driverOpt.isEmpty()){
            throw new DriverExceptions("Account does not exist");
        }
        DriverAccount foundAccount = driverOpt.get();
        List<Booking> bookingList = this.bookingRepository.findAll().stream().filter((b)->b.getCar().getDriver().getId() == driverId).toList();
        return bookingList;
    }

    @Override
    public String getDriverName(Integer driverId) throws DriverExceptions {

        Optional<DriverAccount> driverOpt = this.driverRepository.findById(driverId);
        if(driverOpt.isEmpty()){
            throw new DriverExceptions("Account does not exist");
        }
        return driverOpt.get().getName();
    }

    @Override
    public List<Rating> getDriverRatings(Integer driverId) throws DriverExceptions {
        Optional<DriverAccount> driverOpt = this.driverRepository.findById(driverId);
        if(driverOpt.isEmpty()){
            throw new DriverExceptions("Account does not exist");
        }
        List<Rating> ratingList = this.ratingRepository.findAllByDriverId(driverId);
        return ratingList;
    }
}