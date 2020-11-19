import java.io.*;
import java.util.*;

public class StudentManager{
    public static String studentLogin(LoginManager loginManager, LoginPage loginTiming, ArrayList<Student> students, Student curStudent){
        Console console = System.console();
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        Date dateNow = cal.getTime();
        boolean correctPassword = false;
        if (loginTiming.compareCurrentTime(dateNow) == false){
            System.out.println("Please try again during the stipulated time!");
            System.out.println("Start login time: " + loginTiming.getStartLoginTime());
            System.out.println("End login time: " + loginTiming.getEndLoginTime());
            return "0";
        }
        else{
            int i = 0;
            do { 
                boolean correctUserID = false;
                String inputUserID = "0";
                while(!correctUserID){
                    console.printf("Please type your Student ID: ");
                    inputUserID = console.readLine();
                    if (loginManager.checkUserID(inputUserID) == 1){
                        correctUserID = true;
                    }
                    else{
                        console.printf("User ID does not exist. Please try again\n");
                    }
                }
                console.printf("Please type your password: ");
                char[] passwordChars = console.readPassword();
                String inputStudentPassword = new String(passwordChars);
                if (loginManager.studentCompare(inputUserID, inputStudentPassword) == 0){
                    System.out.println("Wrong Username or Password. Please try again");
                    if (i == 3){
                        return "0";
                    }
                }
                else if (loginManager.studentCompare(inputUserID, inputStudentPassword) == 1) { 
                    return inputUserID;
                   /*  for (Student student: students){
                        if (student.getStudentID().equals(inputUserID)){
                            curStudent = student;
                            correctPassword = true;
                            return inputUserID;
                        }
                    } */
                }
                i++;
            } while (correctPassword = false);
        }
        return "0";
    }
}
