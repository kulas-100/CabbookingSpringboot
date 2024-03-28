package com.project.cabbooking.booking;

public class SelectionDto {
    private Integer userId;
    private Integer cabId;

    public SelectionDto() {
    }

    public SelectionDto(Integer userId, Integer cabId) {
        this.userId = userId;
        this.cabId = cabId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }
}
