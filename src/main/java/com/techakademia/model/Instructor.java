package com.techakademia.model;

public record Instructor(int instructorId, String firstName, String middleName, String lastName, String email,
                         String title) {

    @Override
    public String toString() {
        return " [ instructor Id = " + instructorId +
                " | title = " + title +
                " | firstName = " + firstName +
                " | middleName = " + middleName +
                " | lastName = " + lastName +
                " | email = " + email +
                " ]";
    }

    public String displayAllInfo() {
        return "Instructor Id = " + instructorId +
                "\nTitle = " + title +
                "\nFirst Name = " + firstName +
                "\nMiddle Name = " + middleName +
                "\nLast Name = " + lastName +
                "\nEmail = " + email;
    }
}
