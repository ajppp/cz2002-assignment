package src.Controller;
import java.util.*;
import java.io.*;
// import LoginPage

public class Choice {
    public static void main(String[] args){
        // TODO: read in the login details of student and admin
        // initialise a new array list of students, indices and courses and read in from the existing data.
        ArrayList <Student> students = SerialEditor.loadStudents();
        ArrayList <Index> indices = SerialEditor.loadIndices();
        ArrayList <Course> courses = SerialEditor.loadCourses(); 
        LoginPage login = SerialEditor.loadLogin();
        // TODO: Login with the hashing

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to NTU Stars!");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                // TODO
            case 2:
                Calendar cal = Calendar.getInstance();
                Date dateNow = cal.getTime();
                if (login.compareCurrentTime(dateNow) == false){
                    System.out.println("Please try again during the stipulated time!");
                    System.out.printf("Start login time: " + login.getStartLoginTime());
                    System.out.printf("End login time: " + login.getEndLoginTime());
                }
                else {
                    // TODO: Login with username and password and curStudent refers to the student who logged in
                    Student curStudent;
                    System.out.println("Welcome to NTU Stars Planner!");
                    System.out.println("1. Add Course");
                    System.out.println("2. Drop Course");
                    System.out.println("3. Check/Print Courses Registered");
                    System.out.println("4. Check Vacancies Available");
                    System.out.println("5. Change Index Number of Course");
                    System.out.println("6. Swap Index Number with Another Student");
                    int studentChoice = sc.nextInt();
                    switch (studentChoice) {
                        case 1:
                            // TODO: print list of courses
                            break;
                        case 2:
                            // TODO: print list of courses
                            break;
                        case 3:
                            // TODO: print courses registered
                            break;
                        case 4:
                            // TODO:
                            break;
                        case 5:
                            // TODO: change index number of course
                            break;
                        case 6:
                            // TODO: swap index number of course
                            break;
                        default:
                            System.out.println("Not a valid choice! Please insert a number from 1 - 6");
                    }
                }
            default:
                System.out.println("Not valid choice!");

        }

    
}
