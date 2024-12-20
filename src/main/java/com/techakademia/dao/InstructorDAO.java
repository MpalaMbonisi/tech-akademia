package com.techakademia.dao;

import com.techakademia.model.Instructor;
import com.techakademia.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO {

    private static Instructor getInfo(ResultSet instructorInfo)  {
        try{
            int instructorId = instructorInfo.getInt("instructor_id");
            String firstName = instructorInfo.getString("first_name");
            String middleName = instructorInfo.getString("middle_name");
            String lastName = instructorInfo.getString("last_name");
            String email = instructorInfo.getString("email");
            String title = instructorInfo.getString("education_title");

            return new Instructor(instructorId, firstName, middleName, lastName, email, title);
        } catch(SQLException e){
            System.out.println("Error when getting instructor's info : " + e.getMessage());
            return null;
        }
    }
    public static List<Instructor> getAllInstructors(){
        Connection con = DatabaseConnection.getConnection();
        String sql = "select * from instructors order by instructor_id asc";
        List<Instructor> instructorsList = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet instructors = statement.executeQuery(sql);

            while(instructors.next()){
                instructorsList.add(getInfo(instructors));
            }
            return instructorsList;

        }catch (SQLException e){
            System.out.println("Failed to retrieve all instructors : " + e.getMessage());
            return null;
        }
        finally{
            DatabaseConnection.closeConnection(con);
        }
    }

    public static Instructor getInstructorById(int instructorId){
        Connection con = DatabaseConnection.getConnection();
        String sql = "select * from instructors where instructor_id = " + instructorId;
        try{

            assert con != null;
            Statement statement = con.createStatement();
            ResultSet instructorInfo = statement.executeQuery(sql);
            instructorInfo.next();
            return getInfo(instructorInfo);

        }catch (SQLException e){
            System.out.println("Failed to retrieve instructor by id : " + e.getMessage());
            return null;
        }finally{
            DatabaseConnection.closeConnection(con);
        }
    }

}
