package com.techakademia.dao;

import com.techakademia.model.Course;
import com.techakademia.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    private static Course getInfo(ResultSet courseInfo) {
        try {
            String courseName = courseInfo.getString("course_name");
            String description = courseInfo.getString("description");
            int credits = courseInfo.getInt("credits");
            String instructorName = courseInfo.getString("first_name");
            String instructorSurname = courseInfo.getString("last_name");
            String instructorTitle = courseInfo.getString("education_title");

            return new Course(courseName, description, credits, instructorTitle,instructorName, instructorSurname);

        } catch (SQLException e){
            System.out.println("Error when getting course info : " + e.getMessage());
            return null;
        }
    }

    public static List<Course> getAllCourses(){
        Connection con = DatabaseConnection.getConnection();
        String sql = "select c.course_name, c.description, c.credits, i.first_name, i.last_name, i.education_title " +
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
}