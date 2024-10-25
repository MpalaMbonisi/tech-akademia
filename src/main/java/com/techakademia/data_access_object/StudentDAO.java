package com.techakademia.data_access_object;

import com.techakademia.model.Student;
import com.techakademia.util.DatabaseUtil;
import com.techakademia.util.ValidationUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public static void addStudent(Student student) {
        Connection connection = DatabaseUtil.connectToDatabase();
        String sql = "INSERT INTO public.students(" +
                "first_name, middle_name, last_name, email, date_of_birth, address, date_enrolled)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getMiddleName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.setDate(5, Date.valueOf(student.getDob()));
            statement.setString(6, student.getAddress());
            statement.setTimestamp(7, ValidationUtil.getTimeStamp());

            statement.executeUpdate();
            System.out.println("Student added successfully....\n");
            connection.close();
        }
        catch(SQLException e){
            System.out.println("Error adding student to database: " + e.getMessage());
        }
    }
}
