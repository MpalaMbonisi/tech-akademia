package com.techakademia.dao;

import com.techakademia.model.Instructor;
import com.techakademia.util.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructorDAOTest {

    @Test
    void testGetAllInstructorsSize() {
        List<Instructor> instructorList = InstructorDAO.getAllInstructors();
        assert instructorList != null;
        assertEquals(10, instructorList.size());
    }

    @Test
    void testGetAllInstructorFirstInstructor(){
        List<Instructor> instructorList = InstructorDAO.getAllInstructors();
        assert instructorList != null;
        Instructor instructor = instructorList.get(0);
        assertEquals(1000, instructor.instructorId());
        assertEquals("Andrzej", instructor.firstName());
        assertEquals("Piotr", instructor.middleName());
        assertEquals("Kowalski", instructor.lastName());
        assertEquals("akowalski02@stu.techakademia.edu.pl", instructor.email());
        assertEquals("PhD", instructor.title());
    }

    @Test
    void testGetAllInstructorLastInstructor(){
        List<Instructor> instructorList = InstructorDAO.getAllInstructors();
        assert instructorList != null;
        Instructor instructor = instructorList.get(9);
        assertEquals(1045, instructor.instructorId());
        assertEquals("Magdalena", instructor.firstName());
        assertEquals("Agnieszka", instructor.middleName());
        assertEquals("Szymańska", instructor.lastName());
        assertEquals("mszymanska47@stu.techakademia.edu.pl", instructor.email());
        assertEquals("PhD", instructor.title());
    }

    @Test
    void testGetInstructorById(){
        Instructor instructor = InstructorDAO.getInstructorById(1020);
        assert instructor != null;
        assertEquals("Tomasz", instructor.firstName());
        assertEquals("Krzysztof", instructor.middleName());
        assertEquals("Lewandowski", instructor.lastName());
        assertEquals("tlewandowski34@stu.techakademia.edu.pl", instructor.email());
        assertEquals("MSc", instructor.title());
    }
}