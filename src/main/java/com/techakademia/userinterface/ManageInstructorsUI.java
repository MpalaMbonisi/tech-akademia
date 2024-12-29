package com.techakademia.userinterface;

import com.techakademia.model.Instructor;
import com.techakademia.service.InstructorService;

import java.util.List;
import java.util.Scanner;

public class ManageInstructorsUI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InstructorService instructorService = new InstructorService();
    public static void mainSection() {
        boolean running = true;
        while(running){
            System.out.println("\n~~~~~~~~~~ Instructors Section ~~~~~~~~~~\n");
            System.out.println("1. View All Instructors");
            System.out.println("2. View Instructor Info");
            System.out.println("3. Back to main menu");

            System.out.print("\nPlease enter your option [ 1 - 3 ] : ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    viewAllInstructors();
                    break;
                case 2:
                    viewInstructorInfo();
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Input: Please enter numbers [ 1 - 3 ]!");
            }
        }
    }
    private static void viewAllInstructors() {
        System.out.println("\n~~~~~~~~~~~~ All Instructors ~~~~~~~~~~~~\n");
        List<Instructor> instructorList = instructorService.getAllInstructors();
        for (Instructor instructor: instructorList) {
            System.out.println(instructor.toString());
        }
    }

    private static void viewInstructorInfo(){
        System.out.println("\n~~~~~~~~~~~~ Instructor Info ~~~~~~~~~~~~\n");
        System.out.print("Please enter instructor Id : ");
        int instructor_id = scanner.nextInt();

        if(instructorService.isInstructorInDatabase(instructor_id)){
            System.out.println("\n~~~~~~~~~~~~ Personal Info ~~~~~~~~~~~~\n");
            Instructor instructor = instructorService.getInstructor(instructor_id);
            System.out.println(instructor.displayAllInfo() + "\n");
        }else{
            System.out.println("\nInstructor not found in database!");
        }
    }
}
