package com.techakademia.userinterface;

import com.techakademia.model.Course;
import com.techakademia.model.Student;
import com.techakademia.service.CourseService;
import com.techakademia.service.StudentService;
import com.techakademia.util.Helpers;

import java.util.List;
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
                viewAllStudentsSection();
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
        System.out.println("\n~~~~~~~~~~~~ View Student ~~~~~~~~~~~~\n");
        System.out.println("Please enter student Id : ");
        int studentId = scanner.nextInt();

        if (studentService.isStudentInDatabase(studentId)){
            boolean goBack = false;
            while(!goBack){
                System.out.println("\n~~~~~~~~~~~~ Student Info Portal ~~~~~~~~~~~~\n");
                System.out.println("1. View Personal Info");
                System.out.println("2. View Courses Enrolled");
                System.out.println("3. Update Personal Info");
                System.out.println("4. Enroll Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Back to Main Menu");

                System.out.print("\nPlease select [1-5]\t:\t");
                int choice = scanner.nextInt();

                System.out.println("\n##############################################################\n");

                switch(choice){
                    case 1 :
                        viewPersonalInfo(studentId);
                        break;
                    case 2 :
                        viewCoursesEnrolled(studentId);
                        break;
                    case 3 :
                        updatePersonalInfo(studentId);
                        break;
                    case 4 :
                        enrolledStudent(studentId);
                        break;

                    case 5 :
                        System.out.print("\nDo you really want to delete this student? [ Y/N ] : ");
                        String desicionToDelete = scanner.next();
                        if (desicionToDelete.equalsIgnoreCase("y")){
                            studentService.deleteStudent(studentId);
                            System.out.println("\n Student [ id - " + studentId + " ] has been deleted!");
                        }else {
                            System.out.println("\nStudent not deleted. Nothing has been changed!");
                        }
                        goBack=true;
                        break;

                    case 6 :
                        goBack = true;
                        break;
                    default:
                        System.out.println("Invalid Input: Please enter numbers [ 1 - 5 ]!");
                }
                System.out.println("\n##############################################################\n");
            }
        }else{
            System.out.println("\nStudent not found in database!");
        }

    }
    
    private static void viewPersonalInfo(int studentId){
        System.out.println("\n~~~~~~~~~~~~ Student Personal Info ~~~~~~~~~~~~\n");
        System.out.println(studentService.getStudent(studentId).toString());
    }
    
    private static void viewCoursesEnrolled(int studentId){
        System.out.println("\n~~~~~~~~~~~~ Student's Courses ~~~~~~~~~~~~\n");
        for (Course course: studentService.getCoursesEnrolled(studentId)) {
            System.out.println(course.toString());
        }
    }
    
    private static void updatePersonalInfo(int studentId){
        System.out.println("\n~~~~~~~~~~~~ Update Personal Info ~~~~~~~~~~~~\n");
        System.out.println("1. Update First Name");
        System.out.println("2. Update Middle Name");
        System.out.println("3. Update Last Name");
        System.out.println("4. Update First & Last Name");
        System.out.println("5. Update All the above");

        System.out.print("\nPlease option select [1-5]\t:\t");
        int choice = scanner.nextInt();

        System.out.println("\n##############################################################\n");
        String decisionToUpdate, firstName, lastName, middleName;
        switch(choice){
            case 1 :
                System.out.print("Please enter updated First Name: ");
                firstName = scanner.next();
                System.out.print("Do you want to update first name? [ Y/N ]");
                decisionToUpdate = scanner.next();
                if(decisionToUpdate.equalsIgnoreCase("y")) {
                    studentService.updateFirstName(studentId, firstName);
                    viewPersonalInfo(studentId);
                }else{
                    System.out.println("Information not updated...");
                }

                break;
            case 2 :
                System.out.print("Please enter updated Middle Name: ");
                middleName = scanner.next();
                System.out.print("Do you want to update middle name? [ Y/N ]");
                decisionToUpdate = scanner.next();
                if(decisionToUpdate.equalsIgnoreCase("y")) {
                    studentService.updateMiddleName(studentId, middleName);
                    viewPersonalInfo(studentId);
                }else{
                    System.out.println("Information not updated...");
                }
                break;
            case 3 :
                System.out.print("Please enter updated Last Name: ");
                lastName = scanner.next();
                System.out.print("Do you want to update last name? [ Y/N ]");
                decisionToUpdate = scanner.next();
                if(decisionToUpdate.equalsIgnoreCase("y")) {
                    studentService.updateLastName(studentId, lastName);
                    viewPersonalInfo(studentId);
                }else{
                    System.out.println("Information not updated...");
                }
                break;
            case 4 :
                System.out.print("Please enter updated First Name: ");
                firstName = scanner.next();
                System.out.print("Please enter updated Last Name: ");
                lastName = scanner.next();
                System.out.print("Do you want to update both first and last name? [ Y/N ]");
                decisionToUpdate = scanner.next();
                if(decisionToUpdate.equalsIgnoreCase("y")) {
                    studentService.updateFirstName(studentId, firstName);
                    studentService.updateLastName(studentId, lastName);
                    viewPersonalInfo(studentId);
                }else{
                    System.out.println("Information not updated...");
                }
                break;

            case 5 :
                System.out.print("Please enter updated First Name: ");
                firstName = scanner.next();
                System.out.print("Please enter updated Middle Name: ");
                middleName = scanner.next();
                System.out.print("Please enter updated Last Name: ");
                lastName = scanner.next();
                System.out.print("Do you want to update both first and last name? [ Y/N ]");
                decisionToUpdate = scanner.next();
                if(decisionToUpdate.equalsIgnoreCase("y")) {
                    studentService.updateFirstName(studentId, firstName);
                    studentService.updateMiddleName(studentId, middleName);
                    studentService.updateLastName(studentId, lastName);
                    viewPersonalInfo(studentId);
                }else{
                    System.out.println("Information not updated...");
                }

                break;
            default:
                System.out.println("Invalid Input: Please enter numbers [ 1 - 5 ]!");
        }
        System.out.println("\n##############################################################\n");
    }
    
    private static void enrolledStudent(int studentId){
        CourseService courseService = new CourseService();
        System.out.println("\n~~~~~~~~~~~~ Student Enrollment ~~~~~~~~~~~~\n");
        List<Course> courseList = courseService.getAllCourses();
        for(int i=0; i < courseList.size();i++){
            System.out.println((i+1) + ". " + courseList.get(i).getName());
        }
        System.out.print("\nPlease enter the course option [ 1 - 7 ] : ");
        int choice = scanner.nextInt();
        System.out.print("\nDo you want to enrol student to this course [ Y/N ]: ");
        String decisionToEnrol = scanner.next();
        if(decisionToEnrol.equalsIgnoreCase("y")){
            int courseId= courseService.getAllCourses().get(choice - 1).getCourseId();
            studentService.erolStudent(studentId, courseId);
        }else{
            System.out.println("\nStudent not enrolled, no changes made!");
        }
    }

    private static void viewAllStudentsSection(){
        System.out.println("\n~~~~~~~~~~~~ All Students ~~~~~~~~~~~~\n");
        for (Student student: studentService.getAllStudents()) {
            System.out.println(student.toString());
        }
    }

    private static void deleteStudentSection(){
        System.out.print("\n~~~~~~~~~~ Delete Student ~~~~~~~~~~\n");
        System.out.print("Please enter student Id: ");
        int studentId = scanner.nextInt();
        if(studentService.isStudentInDatabase(studentId)){
            System.out.print("\n Do you really want to delete this student? [ Y/N ]: ");
            String decisionToDelete = scanner.next();
            if(decisionToDelete.equalsIgnoreCase("y")){
                studentService.deleteStudent(studentId);
                System.out.println("\n Student [ id - " + studentId + " ] has been deleted!");
            }else {
                System.out.println("\nStudent not deleted. Nothing has been changed!");
            }
        }else{
            System.out.println("\nStudent not found in database!");
        }
    }

    private static void addStudentSection(){
        System.out.print("\n~~~~~~~~~~ Add Student ~~~~~~~~~~\n");
        System.out.print("Enter First Name : ");
        String firstName = scanner.next();
        String middleName;
        do{
            System.out.print("Enter Middle Name [ if you student doesn't have middle name, enter character ' - ' ] : ");
            middleName = scanner.next();
        }while(middleName.isEmpty());
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
        viewAllStudentsSection();
    }
}
