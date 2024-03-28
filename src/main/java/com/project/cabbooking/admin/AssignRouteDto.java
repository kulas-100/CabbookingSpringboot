package com.project.cabbooking.admin;

public class AssignRouteDto {
    private Integer carId;
    private Integer routeId;

    public AssignRouteDto(Integer carId, Integer routeId) {
        this.carId = carId;
        this.routeId = routeId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
}
