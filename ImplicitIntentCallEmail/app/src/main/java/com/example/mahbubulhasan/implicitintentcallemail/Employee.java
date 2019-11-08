package com.example.mahbubulhasan.implicitintentcallemail;

import java.io.Serializable;

public class Employee implements Serializable {
    private String phone, email;

    public Employee(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
