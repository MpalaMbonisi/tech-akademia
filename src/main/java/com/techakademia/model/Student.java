package com.techakademia.model;

import com.techakademia.util.ValidationUtil;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private LocalDate dob;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public Student(String firstName, String middleName,
                   String lastName, String address, LocalDate dob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName =  middleName;
        this.address = address;
        this.dob = dob;
        this.email = ValidationUtil.generateEmail(firstName, lastName);
    }

}
