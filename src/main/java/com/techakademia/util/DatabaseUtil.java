package com.techakademia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    public static Connection connectToDatabase() {
        try{
            String password = "Sunset@4102";
            String userName = "postgres";
            String url = "jdbc:postgresql://localhost:5432/tech-akademia-system";
            return DriverManager.getConnection(url, userName, password);
        }catch(SQLException e){
            System.out.println("Error adding student to database: " + e.getMessage());
        }
        return null;
    }
}
