package com.techakademia.dao;

import com.techakademia.model.Course;
import com.techakademia.model.Student;
import com.techakademia.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static Student getInfo(ResultSet studentInfo){
        try{
            int studId = studentInfo.getInt("student_id");
            String firstName = studentInfo.getString("first_name");
            String middleName = studentInfo.getString("middle_name");
            String lastName = studentInfo.getString("last_name");
            String email = studentInfo.getString("email");
            String dob = studentInfo.getString("date_of_birth");
            return new Student(studId, firstName,  middleName, lastName, email, dob);


        } catch(SQLException e){
            System.out.println("Error when getting student's info : " + e.getMessage());
            return null;
        }
    }

    public static boolean isStudentInDatabase(int studentId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM students " +
                "WHERE student_id = " + studentId + ";";
        try{
            assert con != null;
            Statement statement = con.createStatement();
            ResultSet student =  statement.executeQuery(sql);
            if (student.next()) return true;

        }catch (SQLException e){
            System.out.println("\nSomething went wrong while searching for student in database : " + e.getMessage());
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
        return false;
    }

    public static Student getStudentById(int studentId){

        Connection con = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM students " +
                "WHERE student_id = " + studentId;
        try{
            assert con != null;
            Statement statement = con.createStatement();
            ResultSet studentInfo =  statement.executeQuery(sql);
            studentInfo.next();
            return getInfo(studentInfo);


        }catch (SQLException e){
            System.out.println("Failed to retrieve student: " + e.getMessage());
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
        return null;

    }

    public static List<Student> getAllStudents(){
        Connection con = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM students ORDER BY student_id ASC";
        List<Student> studentList = new ArrayList<>();
        try {

            assert con != null;
            Statement statement = con.createStatement();
            ResultSet students =  statement.executeQuery(sql);

            while (students.next()) {
                studentList.add(getInfo(students));
            }
            return studentList;

        } catch (SQLException e){

            System.out.println("Failed to retrieve all students : " + e.getMessage());

        }finally {
            DatabaseConnection.closeConnection(con);
        }
        return null;
    }

    public static List<Course> getAllStudentCourses(int studentId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "SELECT c.course_id, c.course_name, c.description, c.credits, i.education_title as title, i.first_name, i.last_name\n" +
                "FROM students s\n" +
                "JOIN enrollments e ON s.student_id = e.student_id\n" +
                "JOIN courses c ON c.course_id = e.course_id\n" +
                "JOIN instructors i on c.instructor_id = i.instructor_id\n" +
                "WHERE s.student_id = " + studentId;

        List<Course> coursesList = new ArrayList<>();
        try {

            assert con != null;
            Statement statement = con.createStatement();
            ResultSet courses =  statement.executeQuery(sql);

            while (courses.next()) {
                int courseId = courses.getInt("course_id");
                String courseName = courses.getString("course_name");
                String description = courses.getString("description");
                int credits = courses.getInt("credits");
                String instructorTitle = courses.getString("title");
                String instructorName = courses.getString("first_name");
                String instructorSurname = courses.getString("last_name");


                Course course = new Course(courseId, courseName, description, credits, instructorTitle, instructorName, instructorSurname);
                coursesList.add(course);
            }
            return coursesList;

        } catch (SQLException e){

            System.out.println("Failed to retrieve all courses done by student : " + e.getMessage());

        }finally {
            DatabaseConnection.closeConnection(con);
        }
        return null;
    }

    private static int updateStudentInfo(String sql){
        Connection con = DatabaseConnection.getConnection();
        try{
            assert con != null;
            Statement statement = con.createStatement();
            return statement.executeUpdate(sql);

        }catch (SQLException e){
            System.out.println("Failed to update student info: " + e.getMessage());
            return 0;
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
    }

    public static int updateFirstName(int student_id, String firstName){
        String sql = "UPDATE students \n\tSET first_name = '" + firstName + "'\n\t WHERE student_id = " +student_id;
        return updateStudentInfo(sql);
    }

    public static int updateMiddleName(int student_id, String middleName){
        String sql;
        if (middleName == null) sql = "UPDATE students \n\tSET middle_name = null\n\t WHERE student_id = " +student_id;
        else sql = "UPDATE students \n\tSET middle_name = '" + middleName + "'\n\t WHERE student_id = " +student_id;
        return updateStudentInfo(sql);
    }
    public static int updateLastName(int student_id, String lastName){
        String sql = "UPDATE students \n\tSET last_name = '" + lastName + "', email = '" + Helpers.generateEmail(lastName) +
                "'\n\t WHERE student_id = " +student_id;
        return updateStudentInfo(sql);
    }

    public static int updateDOB(int studentId, String dob){
        String sql = "UPDATE students \n\tSET date_of_birth = '" + dob + "'\n\t WHERE student_id = " +studentId;
        return updateStudentInfo(sql);
    }
    private static boolean isStudentEnrolled(int studentId, int courseId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM enrollments " +
                "WHERE student_id = " + studentId +
                " AND course_id = " + courseId + ";";
        try{
            assert con != null;
            Statement statement = con.createStatement();
            ResultSet enrollments =  statement.executeQuery(sql);
            if (enrollments.next()) return true;

        }catch (SQLException e){
            System.out.println("\nSomething went wrong while enrolling student : " + e.getMessage());
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
        return false;
    }

    public static void enrolStudentById(int studentId, int courseId){
        if(!isStudentEnrolled(studentId, courseId)) {

            Connection con = DatabaseConnection.getConnection();
            String sql = "INSERT INTO enrollments " +
                    "(student_id, course_id, date_enrolled) " +
                    "VALUES (?, ?, ?)";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, studentId);
                statement.setInt(2, courseId);
                statement.setDate(3, Helpers.getCurrentDate());

                statement.executeUpdate();
                System.out.println("\nStudent enrolled successfully....");

            } catch (SQLException e) {
                System.out.println("Failed to enrol student : " + e.getMessage());
            } finally {
                DatabaseConnection.closeConnection(con);
            }
        }
        else {
            System.out.println("\nStudent is already enrolled in this course!");
        }
    }

    // delete student
    public static int deleteStudentById(int studentId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "DELETE FROM students WHERE student_id = " + studentId;
        try{
            assert con != null;
            Statement statement = con.createStatement();
            return statement.executeUpdate(sql);

        }catch (SQLException e){
            System.out.println("Failed to delete student by id : " + e.getMessage());
            return 0;
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
    }

    public static void addStudent(Student student){
        Connection con = DatabaseConnection.getConnection();
        String sql = "INSERT INTO students " +
                "(first_name, middle_name, last_name, email, date_of_birth) " +
                "VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getMiddleName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.setDate(5, Date.valueOf(student.getDob()));

            statement.executeUpdate();
            System.out.println("\nNew student added successfully...");
        }catch (SQLException e) {
            System.out.println("\nFailed to add new student : " + e.getMessage());
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
    }

}