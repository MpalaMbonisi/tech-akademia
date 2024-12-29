package com.techakademia.service;

import com.techakademia.dao.StudentDAO;
import com.techakademia.model.Student;
import com.techakademia.model.Course;

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

    public List<Course> getCoursesEnrolled(int studentId){ return StudentDAO.getAllStudentCourses(studentId);}

    public void updateFirstName(int studentId, String firstName){
        StudentDAO.updateFirstName(studentId, firstName);
    }

    public void updateMiddleName(int studentId, String  middleName){
        StudentDAO.updateMiddleName(studentId, middleName);
    }

    public boolean isStudentInDatabase(int studentId){
        return StudentDAO.isStudentInDatabase(studentId);
    }

    public void updateLastName(int studentId, String lastName){
        StudentDAO.updateLastName(studentId, lastName);
    }

    public void erolStudent(int studentId, int courseId){
        StudentDAO.enrolStudentById(studentId, courseId);
    }
    public void deleteStudent(int id) {
        StudentDAO.deleteStudentById(id);
    }
}
