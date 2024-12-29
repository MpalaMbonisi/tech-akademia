package com.techakademia;

import com.techakademia.userinterface.ManageCourseUI;
import com.techakademia.userinterface.ManageInstructorsUI;
import com.techakademia.userinterface.ManageStudentUI;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("\n---------- Welcome to Teck Akademia ----------\n");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Manage Instructors");
            System.out.println("4. Exit");
            System.out.print("\nPlease select [1-4]\t:\t");
            int choice = scanner.nextInt();

            System.out.println("\n##############################################################\n");

            switch(choice){
                case 1 :
                    ManageStudentUI.mainSection();
                    break;
                case 2 :
                    ManageCourseUI.mainSection();
                    break;
                case 3 :
                    ManageInstructorsUI.mainSection();
                    break;
                case 4 :
                    System.out.println("GoodBye ;-)");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input: Please enter numbers [ 1 - 4 ]!");
            }
            System.out.println("\n##############################################################\n");
        }
    }
}
