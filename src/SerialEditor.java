import java.util.*;
import java.io.*;

public class SerialEditor{
    public static final String studentFileName = "data/student.ser";
    public static final String courseFileName = "data/course.ser";
    public static final String indexFileName = "data/index.ser";
    public static final String loginTimingFileName = "data/loginTiming.ser";
    public static final String loginDetailsFileName = "data/loginDetails.ser";

    public static void writeStudents(ArrayList<Student> student){
        try {
            FileOutputStream fileOut = new FileOutputStream(studentFileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(student);
        } catch (Exception e) {
            System.out.println("Error in adding a student");
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> loadStudents(){
        ArrayList<Student> students = new ArrayList<Student>(0);
        try { 
            FileInputStream fileIn = new FileInputStream(studentFileName);
            ObjectInputStream in = new ObjectInputStream(fileIn); 
            students = (ArrayList <Student>)in.readObject();
            in.close();
        } catch (Exception e) {
                e.printStackTrace();
            }
        return students;
    }

    public static void writeIndices(ArrayList<Index> index){
        try {
            FileOutputStream fileOut = new FileOutputStream(indexFileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(index);
        } catch (Exception e) {
            System.out.println("Error in adding indices");
            e.printStackTrace();
        }
    }

    public static ArrayList<Index> loadIndices(){
        ArrayList<Index> index = new ArrayList<Index>(0);
        try { 
            FileInputStream fileIn = new FileInputStream(indexFileName);
            ObjectInputStream in = new ObjectInputStream(fileIn); 
            index = (ArrayList <Index>)in.readObject();
            in.close();
        } catch (Exception e) {
                e.printStackTrace();
            }
        return index;
    }

    public static void writeCourses(ArrayList<Course> course){
        try {
            FileOutputStream fileOut = new FileOutputStream(courseFileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(course);
        } catch (Exception e) {
            System.out.println("Error in adding courses");
            e.printStackTrace();
        }
    }

    public static ArrayList<Course> loadCourses(){
        ArrayList<Course> course = new ArrayList<Course>(0);
        try { 
            FileInputStream fileIn = new FileInputStream(courseFileName);
            ObjectInputStream in = new ObjectInputStream(fileIn); 
            course = (ArrayList<Course>)in.readObject();
            in.close();
        } catch (Exception e) {
                e.printStackTrace();
            }
        return course;
    }

    public static void writeLoginTiming(LoginPage login){
        try {
            FileOutputStream fileOut = new FileOutputStream(loginTimingFileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(login);
        } catch (Exception e) {
            System.out.println("Error in adding login timing");
            e.printStackTrace();
        }
    }

    public static LoginPage loadLoginTiming(){
        LoginPage login = new LoginPage();
        try { 
            FileInputStream fileIn = new FileInputStream(loginTimingFileName);
            ObjectInputStream in = new ObjectInputStream(fileIn); 
            login = (LoginPage) in.readObject();
            in.close();
        } catch (Exception e) {
                e.printStackTrace();
            }
        return login;
    }

    public static void writeLoginDetails(LoginManager loginManager){
        try {
            FileOutputStream fileOut = new FileOutputStream(loginDetailsFileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(loginManager);
        } catch (Exception e) {
            System.out.println("Error in adding login details");
            e.printStackTrace();
        }
    }

    public static LoginManager loadLoginDetails(){
        LoginManager loginManager = new LoginManager();
        try { 
            FileInputStream fileIn = new FileInputStream(loginDetailsFileName);
            ObjectInputStream in = new ObjectInputStream(fileIn); 
             loginManager = (LoginManager)in.readObject();
            in.close();
        } catch (Exception e) {
                e.printStackTrace();
            }
        return loginManager;
    }

}
