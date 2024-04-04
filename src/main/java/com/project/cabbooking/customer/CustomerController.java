package com.project.cabbooking.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin({"http://localhost:4200/","http://localhost:3000"})
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("account/login")
    public CustomerAccount userLogin(@RequestBody CustomerLoginDto loginDto) throws CustomerExceptions{
        try{
            return this.customerService.login(loginDto.getCdsId(), loginDto.getPassword());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
