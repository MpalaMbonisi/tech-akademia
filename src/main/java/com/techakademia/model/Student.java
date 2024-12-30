package com.techakademia.model;

public class Student {
    private int studentId;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private String email;
    private final String dob; // FORMAT yyyy-mm-dd eg. 2022-10-10


    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }



    public Student(String firstName, String middleName, String lastName, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dob = dob;
    }

    public Student(int studentId, String firstName, String middleName, String lastName, String email, String dob) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return  "studentId = " + studentId +
                ", firstName = '" + firstName + '\'' +
                ", middleName = '" + middleName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", email = '" + email + '\'' +
                ", dob = '" + dob + '\'' ;
    }

    public String displayAllInfo() {
        return  "Student Id = " + studentId +
                "\nFirst Name = '" + firstName +
                "\nMiddle Name = '" + middleName +
                "\nLast Name = '" + lastName +
                "\nEmail = '" + email +
                "\nDate of Birth = '" + dob;
    }
}
