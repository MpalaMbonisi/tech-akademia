package com.techakademia.dao;

import com.techakademia.model.Course;
import com.techakademia.util.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOTest {
    @Test
    void testGetAllCoursesSize() {
        List<Course> courseList = CourseDAO.getAllCourses();
        assert courseList != null;
        assertEquals(7, courseList.size()); // only seven courses are offered
    }

    @Test
    void testGetAllCoursesFirstCourse() {
        List<Course> courseList = CourseDAO.getAllCourses();
        assert courseList != null;
        Course course = courseList.get(0);
        assertEquals("Introduction to Programming", course.getName());
        assertEquals("Basic principles of programming using Python.", course.getDescription());
        assertEquals(4, course.getCredits());
        assertEquals("PhD" , course.getInstructorTitle());
        assertEquals("Andrzej", course.getInstructorFirstName());
        assertEquals("Kowalski", course.getInstructorLastName());
    }

    @Test
    void testGetAllCoursesLastCourse() {
        List<Course> courseList = CourseDAO.getAllCourses();
        assert courseList != null;
        Course course = courseList.get(6);
        assertEquals("Network Fundamentals", course.getName());
        assertEquals("Fundamentals of computer networks and internet technologies.", course.getDescription());
        assertEquals(3, course.getCredits());
        assertEquals("PhD" , course.getInstructorTitle());
        assertEquals("Piotr", course.getInstructorFirstName());
        assertEquals("Zieliński", course.getInstructorLastName());
    }

    @Test
    void testGetCourseById() {
        Course course = CourseDAO.getCourseById(160);
        assertEquals("Network Fundamentals", course.getName());
        assertEquals("Fundamentals of computer networks and internet technologies.", course.getDescription());
        assertEquals(3, course.getCredits());
        assertEquals("PhD" , course.getInstructorTitle());
        assertEquals("Piotr", course.getInstructorFirstName());
        assertEquals("Zieliński", course.getInstructorLastName());
    }
}