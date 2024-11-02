package com.techakademia.model;

public class Student {
    private int studentId;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private String email;
    private final String dob;
    private String date_enrolled;

    public String getDate_enrolled() {
        return date_enrolled;
    }

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

    public Student(int studentId, String firstName, String middleName, String lastName, String email, String dob, String date_enrolled) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.dob = dob;
        this.date_enrolled = date_enrolled;
    }


}
