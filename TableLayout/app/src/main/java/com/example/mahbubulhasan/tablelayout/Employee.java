package com.example.mahbubulhasan.tablelayout;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    private String name, age, phone, email, gender, city, dob;
    private List<String>languages;

    public Employee(String name, String age, String phone, String email, String gender, String city, List<String> languages, String dob) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.city = city;
        this.languages = languages;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
