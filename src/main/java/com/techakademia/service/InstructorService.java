package com.techakademia.service;

import com.techakademia.dao.InstructorDAO;
import com.techakademia.model.Instructor;

import java.util.List;

public class InstructorService {

    public Instructor getInstructor(int instructorId){
        return InstructorDAO.getInstructorById(instructorId);
    }

    public List<Instructor> getAllInstructors(){
        return InstructorDAO.getAllInstructors();
    }
}
