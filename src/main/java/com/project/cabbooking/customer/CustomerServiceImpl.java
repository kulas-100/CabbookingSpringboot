package com.project.cabbooking.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;


    public CustomerAccount login(String cdsId, String userPassword) throws CustomerExceptions {
        Optional<CustomerAccount> accountOpt = this.customerRepository.findByCdsId(cdsId);
        if(accountOpt.isEmpty()){
            throw new CustomerExceptions("Enter a valid CDS id");
        }
        CustomerAccount foundAccount = accountOpt.get();
        if(!foundAccount.getPassword().equals(userPassword)) {
            throw new CustomerExceptions("Enter correct password");
        }
        return foundAccount;
    }
}
