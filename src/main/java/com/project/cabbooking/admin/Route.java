package com.project.cabbooking.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalTime;

@Entity
public class Route{
    @NotBlank(message = "Start location cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Start location should contain only alphabets")
    String startLocation;
    @NotBlank(message = "End location cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "End location should contain only alphabets")
    String endLocation;
    @NotBlank(message = "Fare cannot be empty")
    @Pattern(regexp = "^[0-9]*$", message = "Fare should contain only numbers")
    @Min(value = 30,message = "Fare should be greater than 30")
    Double fare;

    @Id
    @GeneratedValue
    Integer locationId;
    String StartTime;
    String EndTime;

    public Route() {
    }

    public Route(String startLocation, String endLocation, Double fare, String startTime, String endTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.fare = fare;
        StartTime = startTime;
        EndTime = endTime;
    }

    //    public Route(Integer locationId,String startlocation,String endLocation,Double fare){
//        this.locationId=locationId;
//        this.startlocation=startlocation;
//        this.endLocation=endLocation;
//        this.fare=fare;
//    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startlocation) {
        this.startLocation = startlocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }
}
