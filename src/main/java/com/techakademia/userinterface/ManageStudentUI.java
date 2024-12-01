package com.techakademia.userinterface;

import com.techakademia.model.Student;
import com.techakademia.service.StudentService;
import com.techakademia.util.Helpers;

import java.util.Scanner;

public class ManageStudentUI {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService = new StudentService();

    public static void mainSection(){

        System.out.println("\n~~~~~~~~~~ Students Section ~~~~~~~~~~\n");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. View All Students");
        System.out.println("4. View Student");
        System.out.println("5. Back to main menu");

        System.out.print("Please enter your option [ 1 - 5 ] : ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                addStudentSection();
                break;
            case 2:
                deleteStudentSection();
                break;
            case 3:
                viewAllStudentSection();
                break;
            case 4:
                viewStudentSection();
                break;

            case 5:
                break;

            default:
                System.out.println("Invalid Input: Please enter numbers [ 1 - 5 ]!");
        }
    }
    private static void viewStudentSection(){

    }

    private static void viewAllStudentSection(){

    }

    private static void deleteStudentSection(){

    }

    private static void addStudentSection(){
        System.out.print("\n~~~~~~~~~~ Add Student ~~~~~~~~~~\n");
        System.out.print("Enter First Name : ");
        String firstName = scanner.next();
        System.out.print("Enter Middle Name [ if you student doesn't have middle name, enter character ' - ' ] : ");
        String middleName = scanner.next();
        System.out.print("Enter Last Name : ");
        String lastName = scanner.next();
        System.out.print("Enter Date Of Birth [ yyyy-mm-dd ] : ");
        String dob = scanner.next();
        if (Helpers.validateDate(dob) == null) {
            System.out.println("\n**********************************************************\n");
            System.out.println("Please enter a valid date. Format : yyyy-mm-dd eg. 2001-12-16");
            System.out.println("\n**********************************************************\n");
        }
        else{
            Student student = new Student(firstName, middleName, lastName, dob);
            studentService.addStudent(student);
        }
        viewStudentSection();
    }
}
