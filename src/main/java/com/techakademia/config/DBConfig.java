package com.techakademia.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    private final String dbUrl;
    private final String dbPassword;
    private final String dbUsername;
    public DBConfig(){
        // load database configuration from the properties file in resources
        try(InputStream inputStream = getClass()
                                    .getClassLoader()
                                    .getResourceAsStream("database_configuration/db.properties")){
            if (inputStream == null){
                throw new RuntimeException("Could not find db.properties in resources/database_configuration");
            }

            Properties properties = new Properties();
            properties.load(inputStream);

            this.dbUrl = properties.getProperty("db.url");
            this.dbUsername = properties.getProperty("db.username");
            this.dbPassword = properties.getProperty("db.password");

            // validate that all the required properties are present
            if (dbUrl == null || dbUsername == null || dbPassword == null){
                throw new RuntimeException("Missing database configuration properties in db.properties....");
            }
        }
        catch (IOException e){
            throw new RuntimeException("Failed to load database configuration: " + e.getMessage());
        }
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbUsername() {
        return dbUsername;
    }
}
