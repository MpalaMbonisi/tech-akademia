package com.techakademia.util;

import com.techakademia.model.Student;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;

public class Helpers {
    public static String generateEmail(String lastName){
        int randomNum = (int)(Math.random() * 100);
        return lastName.toLowerCase() + randomNum + "@stu.techakademia.edu.pl";
    }

    public static Date getCurrentDate(){
        // get the current time in milliseconds since January 1, 1970
        long millis = System.currentTimeMillis();
        return new Date(millis);
    }

    public static int addTestStudent() {
        Connection con = DatabaseConnection.getConnection();
        String sql = "insert into students (student_id, first_name, middle_name, last_name, email, date_of_birth, date_enrolled)" +
                "values " +
                "   (0, 'Mbonisi', null, 'Mpala', 'mmpala01@stu.techakademia.edu.pl', '2001-12-16', '2022-10-01')";
        try{
            assert con != null;
            Statement statement = con.createStatement();
            return statement.executeUpdate(sql);

        }catch (SQLException e){
            System.out.println("Failed to add test student: " + e.getMessage());
            return 0;
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
    }

    public static int enrolTestStudent() {
        Connection con = DatabaseConnection.getConnection();
        String sql = "insert into enrollments(enrolment_id, student_id, course_id, date_enrolled)" +
                "values(0, 0, 125, '2022-10-10')";
        try{
            assert con != null;
            Statement statement = con.createStatement();
            return statement.executeUpdate(sql);

        }catch (SQLException e){
            System.out.println("Failed to delete test student: " + e.getMessage());
            return 0;
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
    }


}
