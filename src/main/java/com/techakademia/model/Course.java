package com.techakademia.model;

public class Course {
    private String courseName;
    private String description;
    private int credits;
    private int instructorID;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public Course(String courseName, String description, int credits, int instructorID) {
        this.courseName = courseName;
        this.description = description;
        this.credits = credits;
        this.instructorID = instructorID;
    }
}
