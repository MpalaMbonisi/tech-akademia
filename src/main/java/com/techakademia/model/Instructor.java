package com.techakademia.model;

public class Instructor{
    private final int instructorId;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String email;
    private final String title;

    public Instructor(int instructorId, String firstName, String middleName, String lastName, String email, String title) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return " [ instructor Id = " + instructorId +
                " | title = " + title +
                " | firstName = " + firstName  +
                " | middleName = " + middleName  +
                " | lastName = " + lastName  +
                " | email = " + email  +
                " ]";
    }

    public String displayAllInfo() {
        return  "Instructor Id = " + instructorId +
                "\nTitle = " + title +
                "\nFirst Name = " + firstName +
                "\nMiddle Name = " + middleName +
                "\nLast Name = " + lastName +
                "\nEmail = " + email;
    }
}
