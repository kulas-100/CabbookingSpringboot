package com.project.cabbooking.booking;

public class LocationDto {
    private String startLocation;
    private String endLocation;

    public LocationDto() {
    }

    public LocationDto(String startLocation, String endLocation) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
}

