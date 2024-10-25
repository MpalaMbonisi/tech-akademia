package com.techakademia.model;

public class Enrolment {
    private int studentId;
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Enrolment(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}
