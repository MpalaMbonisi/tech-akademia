package com.techakademia.dao;

import com.techakademia.model.Course;
import com.techakademia.model.Student;
import com.techakademia.util.Helpers;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    @BeforeEach
    void setUp() {
        // create a new student for testing purposes only
        assertEquals(1, Helpers.addTestStudent());
        assertEquals(1, Helpers.enrolTestStudent());
    }

    @AfterEach
    void tearDown() {
        // delete the student created for testing purposes
        assertEquals(1, StudentDAO.deleteStudentById(0));

    }

    @Test
    void testGetStudentById(){
        Student testStudent = StudentDAO.getStudentById(0);
        assert testStudent != null;
        assertEquals(0, testStudent.getStudentId());
        assertEquals("Mbonisi", testStudent.getFirstName());
        assertNull(testStudent.getMiddleName());
        assertEquals("Mpala", testStudent.getLastName());
        assertEquals("mmpala01@stu.techakademia.edu.pl", testStudent.getEmail());
        assertEquals("2001-12-16", testStudent.getDob());
        assertEquals("2022-10-01", testStudent.getDate_enrolled());
    }

    @Test
    void testGetAllStudents(){
        List<Student> studentList = StudentDAO.getAllStudents();
        assert studentList != null;
        Student student = studentList.get(0);
        assertEquals(0, student.getStudentId());
        assertEquals("Mbonisi", student.getFirstName());
        assertNull(student.getMiddleName());
        assertEquals("Mpala", student.getLastName());
        assertEquals("mmpala01@stu.techakademia.edu.pl", student.getEmail());
        assertEquals("2001-12-16", student.getDob());
        assertEquals("2022-10-01", student.getDate_enrolled());
    }

    @Test
    void testGetAllStudentCourses(){
        List<Course> coursesList = StudentDAO.getAllStudentCourses(0);
        assert coursesList != null;
        Course course = coursesList.get(0);
        assertEquals(1, coursesList.size());
        assertEquals("Web Development", course.getName());
        assertEquals("Introduction to web technologies including HTML, CSS, and JavaScript.", course.getDescription());
        assertEquals(4, course.getCredits());
        assertEquals("PhD", course.getInstructorTitle());
        assertEquals("Zofia", course.getInstructorFirstName());
        assertEquals("Wiśniewska", course.getInstructorLastName());
    }

    @Test
    void testUpdateFirstName(){
        assertEquals(1, StudentDAO.updateFirstName(0, "Alfred"));
        Student student = StudentDAO.getStudentById(0);
        assert student != null;
        assertEquals("Alfred", student.getFirstName());
        assertEquals(1, StudentDAO.updateFirstName(0,"Mbonisi"));
        student = StudentDAO.getStudentById(0);
        assertEquals("Mbonisi", student.getFirstName());
    }

    @Test
    void testUpdateMiddleName(){
        assertEquals(1, StudentDAO.updateMiddleName(0, "Alfred"));
        Student student = StudentDAO.getStudentById(0);
        assert student != null;
        assertEquals("Alfred", student.getMiddleName());
        assertEquals(1, StudentDAO.updateMiddleName(0,null));
        student = StudentDAO.getStudentById(0);
        assertNull(student.getMiddleName());
    }

    @Test
    void testUpdateLastName(){
        assertEquals(1, StudentDAO.updateLastName(0, "Smith"));
        Student student = StudentDAO.getStudentById(0);
        assert student != null;
        assertEquals("Smith", student.getLastName());
        assertNotEquals("mmpala01@stu.techakademia.edu.pl", student.getEmail());
        assertEquals(1, StudentDAO.updateLastName(0,"Mpala"));
        student = StudentDAO.getStudentById(0);
        assertEquals("Mpala", student.getLastName());
    }

    @Test
    void testUpdateDOB(){
        assertEquals(1, StudentDAO.updateDOB(0, "2002-01-31"));
        Student student = StudentDAO.getStudentById(0);
        assert student != null;
        assertEquals("2002-01-31", student.getDob());
        assertEquals(1, StudentDAO.updateDOB(0,"2001-12-16"));
        student = StudentDAO.getStudentById(0);
        assertEquals("2001-12-16", student.getDob());
    }

}