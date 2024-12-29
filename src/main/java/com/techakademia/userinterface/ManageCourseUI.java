package com.techakademia.userinterface;

import com.techakademia.model.Course;
import com.techakademia.service.CourseService;

import java.util.List;
import java.util.Scanner;

public class ManageCourseUI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CourseService courseService = new CourseService();

    public static void mainSection() {
        System.out.println("\n~~~~~~~~~~ Courses Section ~~~~~~~~~~\n");
        System.out.println("1. View All Courses");
        System.out.println("2. Back to main menu");

        System.out.print("Please enter your option [ 1 - 2 ] : ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                viewAllCourses();
                break;
            case 2:
                break;

            default:
                System.out.println("Invalid Input: Please enter numbers [ 1 - 2 ]!");
        }
    }

    private static void viewAllCourses() {
        while(true){
            System.out.println("\n~~~~~~~~~~~~ All Courses ~~~~~~~~~~~~\n");
            List<Course> courseList = courseService.getAllCourses();
            for (int i = 0; i < courseList.size(); i++) {
                System.out.println((i + 1) + ". " + courseList.get(i).getName());
            }
            System.out.println("8. Back to Main menu");
            System.out.print("\nPlease enter the course option [ 1 - 8 ] : ");
            int choice = scanner.nextInt();

            if (choice > 0 && choice < 8) {
                Course course = courseList.get(choice - 1);
                System.out.println("\n+ " + course.getName() + " +\n");
                System.out.println(course.displayAllInfo());

                System.out.print("\n Do you also want to view students enrolled for this course? [ Y/N ] : ");
                String viewEnrolledStudents = scanner.next();

                if (viewEnrolledStudents.equalsIgnoreCase("y")){
                    System.out.println("\n~~~~~~~~~~~~ Student Enrolled ~~~~~~~~~~~~\n");
                    List<String> studentList = courseService.getEnrolledStudentByCourseId(course.getCourseId());
                    for (String student: studentList) {
                        System.out.println(student);
                    }
                }
            }else if(choice == 8){
                break;
            }
            else{
                System.out.println("Invalid Input: Please enter numbers [ 1 - 8 ]!");
            }
        }
    }
}
