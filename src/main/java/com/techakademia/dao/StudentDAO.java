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
            String dateEnrolled = studentInfo.getString("date_enrolled");
            return new Student(studId, firstName,  middleName, lastName, email, dob, dateEnrolled);


        } catch(SQLException e){
            System.out.println("Error when getting student's info : " + e.getMessage());
            return null;
        }
    }

    public static Student getStudentById(int studentId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "select * from students " +
                "where student_id = " + studentId;
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
        String sql = "select * from students order by student_id asc";
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
        String sql = "select c.course_name, c.description, c.credits, i.education_title as title, i.first_name, i.last_name\n" +
                "from students s\n" +
                "join enrollments e on s.student_id = e.student_id\n" +
                "join courses c on c.course_id = e.course_id\n" +
                "join instructors i on c.instructor_id = i.instructor_id\n" +
                "where s.student_id = " + studentId;

        List<Course> coursesList = new ArrayList<>();
        try {

            assert con != null;
            Statement statement = con.createStatement();
            ResultSet courses =  statement.executeQuery(sql);

            while (courses.next()) {
                String courseName = courses.getString("course_name");
                String description = courses.getString("description");
                int credits = courses.getInt("credits");
                String instructorTitle = courses.getString("title");
                String instructorName = courses.getString("first_name");
                String instructorSurname = courses.getString("last_name");


                Course course = new Course(courseName, description, credits, instructorTitle, instructorName, instructorSurname);
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
        String sql = "update students \n\tset first_name = '" + firstName + "'\n\t where student_id = " +student_id;
        return updateStudentInfo(sql);
    }

    public static int updateMiddleName(int student_id, String middleName){
        String sql;
        if (middleName == null) sql = "update students \n\tset middle_name = null\n\t where student_id = " +student_id;
        else sql = "update students \n\tset middle_name = '" + middleName + "'\n\t where student_id = " +student_id;
        return updateStudentInfo(sql);
    }
    public static int updateLastName(int student_id, String lastName){
        String sql = "update students \n\tset last_name = '" + lastName + "', email = '" + Helpers.generateEmail(lastName) +
                "'\n\t where student_id = " +student_id;
        return updateStudentInfo(sql);
    }

    public static int updateDOB(int student_id, String dob){
        String sql = "update students \n\tset date_of_birth = '" + dob + "'\n\t where student_id = " +student_id;
        return updateStudentInfo(sql);
    }

    // delete student
    public static int deleteStudentById(int studentId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "delete from students where student_id = " + studentId;
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
        String sql = "insert into students " +
                "(first_name, middle_name, last_name, email, date_of_birth, date_enrolled) " +
                "values (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getMiddleName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.setDate(5, Date.valueOf(student.getDob()));
            statement.setDate(6, Helpers.getCurrentDate());

            statement.executeUpdate();
            System.out.println("New student added successfully....\n");
        }catch (SQLException e) {
            System.out.println("Failed to add new student : " + e.getMessage());
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
    }

}