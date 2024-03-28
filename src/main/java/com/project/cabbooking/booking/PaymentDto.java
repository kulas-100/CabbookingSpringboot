package com.project.cabbooking.booking;

public class PaymentDto {
    private Integer customerId;
    private Integer cabId;
    private Double fare;

    private String paymentMethod;
    public PaymentDto() {
    }

    public PaymentDto(Integer customerId, Integer cabId, Double fare,String paymentMethod) {
        this.customerId = customerId;
        this.cabId = cabId;
        this.fare = fare;
        this.paymentMethod=paymentMethod;
    }

    public PaymentDto(Integer customerId, Integer cabId, Double fare) {
        this.customerId = customerId;
        this.cabId = cabId;
        this.fare = fare;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}