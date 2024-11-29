package com.techakademia.util;

import com.techakademia.config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection(){
        try{
            DBConfig config = new DBConfig();
            return DriverManager.getConnection(
                    config.getDbUrl(),
                    config.getDbUsername(),
                    config.getDbPassword()
            );
        }catch(SQLException e){
            throw new RuntimeException("Failed to connect to the database: " + e.getMessage());
        }
    }

    public static void closeConnection(Connection connection){
        if (connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println("Failed to close the connection: " + e.getMessage());
            }
        }
    }
}
