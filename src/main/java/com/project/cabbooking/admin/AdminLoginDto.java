package com.project.cabbooking.admin;

public class AdminLoginDto {
    String cdsId;
    String password;

    public AdminLoginDto(String cdsId, String password) {
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
