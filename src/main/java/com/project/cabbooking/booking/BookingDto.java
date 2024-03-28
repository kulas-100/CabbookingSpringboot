package com.project.cabbooking.booking;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class BookingDto {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer customerId;
    private Integer cabId;
    private Integer paymentId;
    private LocalDate date;
    private String status;
    private Double amount;
    private String PaymentMethod;

    public BookingDto() {
    }

    public BookingDto(Integer id, Integer customerId, Integer cabId, Integer paymentId, LocalDate date, String status, Double amount, String paymentMethod) {
        this.id = id;
        this.customerId = customerId;
        this.cabId = cabId;
        this.paymentId = paymentId;
        this.date = date;
        this.status = status;
        this.amount = amount;
        PaymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

}
