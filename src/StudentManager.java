import java.io.*;
import java.util.*;

public class StudentManager{
    public static String studentLogin(LoginManager loginManager, LoginPage loginTiming, ArrayList<Student> students, Student curStudent){
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        Date dateNow = cal.getTime();
        boolean correctPassword = false;
        if (loginTiming.compareCurrentTime(dateNow) == false){
            System.out.println("Please try again during the stipulated time!");
            System.out.printf("Start login time: " + loginTiming.getStartLoginTime());
            System.out.printf("End login time: " + loginTiming.getEndLoginTime());
            return "0";
        }
        else{
            int i = 0;
            do { 
                System.out.println("Please insert your UserID: ");
                String inputUserID = sc.nextLine();
                System.out.println("Please insert your password: ");
                String inputStudentPassword = sc.nextLine();
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
