package com.project.cabbooking.booking;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer customerId;
    private Integer cabId;
    private LocalDate date;
    private String status;
    private Double amount;
    private String PaymentMethod;

    public Payment() {
    }

    public Payment(Integer id, Integer customerId, Integer cabId, LocalDate date, String status, Double amount, String paymentMethod) {
        this.id = id;
        this.customerId = customerId;
        this.cabId = cabId;
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
}
