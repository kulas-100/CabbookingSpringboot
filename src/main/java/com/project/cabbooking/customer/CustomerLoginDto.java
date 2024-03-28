package com.project.cabbooking.customer;

public class CustomerLoginDto {
    private String cdsId;
    private String password;
    public CustomerLoginDto() {
    }

    public CustomerLoginDto(String cdsId, String password) {
        this.cdsId = cdsId;
        this.password = password;
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

}
