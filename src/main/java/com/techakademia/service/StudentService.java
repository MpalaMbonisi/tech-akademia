package com.techakademia.service;

import com.techakademia.dao.StudentDAO;
import com.techakademia.model.Student;

import java.util.List;

public class StudentService {

    public void addStudent(Student student){
        StudentDAO.addStudent(student);
    }

    public Student getStudent(int id){
        return StudentDAO.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return StudentDAO.getAllStudents();
    }

    public void updateFirstName(int studentId, String firstName){
        StudentDAO.updateFirstName(studentId, firstName);
    }

    public void updateMiddleName(int studentId, String  middleName){
        StudentDAO.updateMiddleName(studentId, middleName);
    }

    public void updateLastName(int studentId, String lastName){
        StudentDAO.updateLastName(studentId, lastName);
    }

    public void deleteStudent(int id) {
        StudentDAO.deleteStudentById(id);
    }
}
