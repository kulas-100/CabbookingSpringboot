package com.project.cabbooking.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class AdminAccount {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 20, message = "Name should be between 3 and 20 characters")
    private String name;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Password should contain atleast one digit, one lowercase, one uppercase and one special character")
    private String password;
    @NotBlank(message = "CDS ID is mandatory")
    private String cdsId;
    @NotBlank(message = "Secret Key is mandatory")
    private String secretKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdminAccount(String cdsId, String name, String password,String secretKey) {
        this.cdsId = cdsId;
        this.name = name;
        this.password = password;
        this.secretKey=secretKey;
    }

    public AdminAccount() {

    }

    public String getCdsId() {
        return cdsId;
    }

    public void setCdsId(String cdsId) {
        this.cdsId = cdsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecretKey() {
        return secretKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

}
