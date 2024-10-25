package com.techakademia.service;

import com.techakademia.data_access_object.StudentDAO;
import com.techakademia.model.Student;

public class StudentService {
    public static void addStudent(Student student){
        // check if email exists in the database

        StudentDAO.addStudent(student);
    }
}
