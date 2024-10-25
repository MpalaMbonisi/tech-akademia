package com.techakademia.userinterface;

import com.techakademia.model.Student;
import com.techakademia.service.StudentService;
import com.techakademia.util.ValidationUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    public static void getMainUI(){
        Scanner scr = new Scanner(System.in);

        while (true){
            System.out.println("-------------------------------------");
            System.out.println("TECH AKADEMIA SYSTEM MANAGEMENT");
            System.out.println("-------------------------------------");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Enrol Student in Course");
            System.out.println("6. View Enrollments");
            System.out.println("7. View Instructors");
            System.out.println("8. Exit");
            System.out.println("-------------------------------------");
            System.out.print("Please select an option (1-8) : ");
            int option = scr.nextInt();

            switch (option){
                case 1:
                    addStudentUI();
                    break;
                case 2:
                    viewStudentsUI();
                    break;
                case 3:
                    addCourseUI();
                    break;
                case 4:
                    viewCoursesUI();
                    break;
                case 5:
                    System.out.println("selected 5");
                    break;
                case 6:
                    System.out.println("selected 6");
                    break;
                case 7:
                    viewInstructorsUI();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("invalid selection");
            }
        }
    }
    private static void addStudentUI(){
        Scanner src =  new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("ADD NEW STUDENT");
        System.out.println("-------------------------------------");
        System.out.print("Enter First Name:\t");
        String firstName = src.next();
        System.out.print("Enter Middle Name:\t");
        String middleName = src.next();
        System.out.print("Enter Last Name:\t");
        String lastName = src.next();
        System.out.print("Enter Date of Birth (YYYY-MM-DD):\t");
        String date = src.next();
        LocalDate dob = ValidationUtil.convertToDate(date);
        src.nextLine();
        System.out.print("Enter Address:\t");
        String address = src.nextLine();
        System.out.println("-------------------------------------");

        Student student = new Student(firstName, middleName, lastName, address, dob);

        StudentService.addStudent(student);

    }
    private static void viewStudentsUI(){
        Scanner src = new Scanner(System.in);
        do {
            System.out.println("-------------------------------------");
            System.out.println("VIEW STUDENTS");
            System.out.println("-------------------------------------");
            // populate with data
            System.out.println("-------------------------------------");
            System.out.println("Enter 'E' to exit back to main menu...");
        } while (!src.next().equalsIgnoreCase("e"));
    }
    private static void addCourseUI(){
        Scanner src =  new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("ADD NEW COURSE");
        System.out.println("-------------------------------------");
        System.out.print("Enter Course Name:\t");
        String courseName = src.next();
        System.out.print("Enter Description:\t");
        String description = src.next();
        System.out.print("Enter Credits:\t");
        int credits = src.nextInt();
        System.out.println("-------------------------------------");

    }

    private static void viewCoursesUI(){
        Scanner src = new Scanner(System.in);
        do {
            System.out.println("-------------------------------------");
            System.out.println("VIEW COURSES");
            System.out.println("-------------------------------------");
            // populate with data
            System.out.println("-------------------------------------");
            System.out.println("Enter 'E' to exit back to main menu...");
        } while (!src.next().equalsIgnoreCase("e"));
    }

    private static void viewInstructorsUI(){
        Scanner src = new Scanner(System.in);
        do {
            System.out.println("-------------------------------------");
            System.out.println("VIEW INSTRUCTORS");
            System.out.println("-------------------------------------");
            // populate with data
            System.out.println("-------------------------------------");
            System.out.println("Enter 'E' to exit back to main menu...");
        } while (!src.next().equalsIgnoreCase("e"));
    }
}
