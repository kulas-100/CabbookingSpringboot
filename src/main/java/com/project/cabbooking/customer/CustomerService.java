package com.project.cabbooking.customer;

public interface CustomerService {
    CustomerAccount login(String cdsId, String password) throws CustomerExceptions;
}
