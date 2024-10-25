package com.techakademia.model;

import java.util.Objects;

public class Student {
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String dob;

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Student(String firstName, String middleName,
                   String lastName, String address, String dob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = (middleName.isEmpty()) ? null : middleName;
        this.address = address;
        this.dob = dob;
    }

}
