package com.techakademia.model;

public class Course {
    private final String name;
    private final String description;
    private final int credits;
    private final String instructorFirstName;

    private final String instructorLastName;
    private final String instructorTitle;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCredits() {
        return credits;
    }

    public String getInstructorFirstName() {
        return instructorFirstName;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public String getInstructorTitle() {
        return instructorTitle;
    }

    public Course(String name, String description, int credits, String instructorTitle, String instructorFirstName, String instructorLastName) {
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.instructorFirstName = instructorFirstName;
        this.instructorLastName = instructorLastName;
        this.instructorTitle = instructorTitle;
    }
}
