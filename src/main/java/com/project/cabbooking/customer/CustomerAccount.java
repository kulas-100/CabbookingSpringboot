package com.project.cabbooking.customer;

import com.project.cabbooking.booking.Booking;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerAccount {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String cdsId;
    private String password;
    private Double phoneNumber;
    private String address;

    @OneToMany
    private List<Booking> bookings = new ArrayList<>();

    public CustomerAccount() {
    }

    public CustomerAccount(String name, String cdsId, String password, Double phoneNumber, String address) {
        this.name = name;
        this.cdsId = cdsId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public CustomerAccount(String name, String cdsId, String password, Double phoneNumber, String address, List<Booking> bookings) {
        this.name = name;
        this.cdsId = cdsId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCdsId() {
        return cdsId;
    }

    public void setCdsId(String cdsId) {
        this.cdsId = cdsId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
