package com.techakademia.util;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidationUtil {

    public static LocalDate convertToDate(String date){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);

        }catch (DateTimeParseException e){
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
        return null;
    }

    public static String generateEmail(String firstName, String lastName){
        char initial = firstName.charAt(0);
        int randomNum = (int)(Math.random() * 100);
        return (initial + lastName).toLowerCase() + randomNum + "@stu.techakademia.edu.pl";
    }

    public static Timestamp getTimeStamp(){
        return new Timestamp(System.currentTimeMillis());
    }

}
