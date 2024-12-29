package com.techakademia.service;

import com.techakademia.dao.CourseDAO;
import com.techakademia.model.Course;

import java.util.List;

public class CourseService {

    public Course getCourse(int courseId){
        return CourseDAO.getCourseById(courseId);
    }

    public List<Course> getAllCourses(){
        return CourseDAO.getAllCourses();
    }

    public List<String> getEnrolledStudentByCourseId(int courseId){return CourseDAO.viewStudentsEnrolled(courseId);}
}
