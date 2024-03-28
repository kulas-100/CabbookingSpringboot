package com.project.cabbooking.admin;

public class AssignDriverDto {
    private Integer carId;
    private Integer driverId;

    public AssignDriverDto(Integer carId, Integer driverId) {
        this.carId = carId;
        this.driverId = driverId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
