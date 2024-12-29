package com.techakademia.dao;

import com.techakademia.model.Course;
import com.techakademia.model.Student;
import com.techakademia.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    private static Course getInfo(ResultSet courseInfo) {
        try {
            int courseId = courseInfo.getInt("course_id");
            String courseName = courseInfo.getString("course_name");
            String description = courseInfo.getString("description");
            int credits = courseInfo.getInt("credits");
            String instructorName = courseInfo.getString("first_name");
            String instructorSurname = courseInfo.getString("last_name");
            String instructorTitle = courseInfo.getString("education_title");

            return new Course(courseId, courseName, description, credits, instructorTitle,instructorName, instructorSurname);

        } catch (SQLException e){
            System.out.println("Error when getting course info : " + e.getMessage());
            return null;
        }
    }

    public static List<Course> getAllCourses(){
        Connection con = DatabaseConnection.getConnection();
        String sql = "select c.course_id, c.course_name, c.description, c.credits, i.first_name, i.last_name, i.education_title " +
                " from courses as c " +
                "join instructors as i on c.instructor_id = i.instructor_id";
        List<Course> coursesList = new ArrayList<>();
        try {

            assert con != null;
            Statement statement = con.createStatement();
            ResultSet courses =  statement.executeQuery(sql);

            while (courses.next()) {
                coursesList.add(getInfo(courses));
            }
            return coursesList;

        } catch (SQLException e){

            System.out.println("Failed to retrieve all courses : " + e.getMessage());

        }finally {
            DatabaseConnection.closeConnection(con);
        }
        return null;
    }

    public static Course getCourseById(int courseId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "select c.course_name, c.description, c.credits, i.first_name, i.last_name, i.education_title " +
                " from courses as c " +
                "join instructors as i on c.instructor_id = i.instructor_id \n" +
                "where c.course_id = " + courseId;

        try {
            assert con != null;
            Statement statement = con.createStatement();
            ResultSet courseInfo =  statement.executeQuery(sql);
            courseInfo.next();
            return getInfo(courseInfo);

        } catch (SQLException e){

            System.out.println("Failed to retrieve course by id : " + e.getMessage());

        }finally {
            DatabaseConnection.closeConnection(con);
        }
        return null;
    }

    public static List<String> viewStudentsEnrolled(int courseId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "select s.first_name, s.middle_name, s.last_name, s.email, e.date_enrolled " +
                " from students as s " +
                "join enrollments as e on e.student_id = s.student_id " +
                "where e.course_id = " + courseId;
        List<String> studentList = new ArrayList<>();
        try {

            assert con != null;
            Statement statement = con.createStatement();
            ResultSet students =  statement.executeQuery(sql);

            while (students.next()) {
                studentList.add(getStudentInfo(students));
            }
            return studentList;

        } catch (SQLException e){

            System.out.println("Failed to retrieve all students enrolled to the course : " + e.getMessage());

        }finally {
            DatabaseConnection.closeConnection(con);
        }
        return null;
    }

    private static String getStudentInfo(ResultSet studentInfo){
        try{
            String firstName = studentInfo.getString("first_name");
            String middleName = studentInfo.getString("middle_name");
            String lastName = studentInfo.getString("last_name");
            String email = studentInfo.getString("email");
            String dateEnrolled = studentInfo.getString("date_enrolled");
            return "first name : " + firstName + " | middle name : " +  middleName
                    + " | last name : " + lastName  + " | email : " + email + " | date_enrolled : " + dateEnrolled;


        } catch(SQLException e){
            System.out.println("Error when getting student's info : " + e.getMessage());
            return null;
        }

    }
}