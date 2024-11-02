package com.techakademia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String password = "Sunset@4102";
    private static final String username = "postgres"; // default username
    private static final String url = "jdbc:postgresql://localhost:5432/tech_akademia_system";
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url, username,password);
        }catch(SQLException e){
            System.out.println("SQL Exception occurred : " + e.getMessage());
        }
        return null;
    }
    public static void closeConnection(Connection connection){
        if (connection != null){
            try{
                connection.close();
            }catch(SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
