
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import LoginPage;

public class Choice {
    public static void main(String[] args){
        // TODO: read in the login details of student and admin
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
                if (LoginPage.compareCurrentTime(dateNow) == false){
                    System.out.println("Please try again during the stipulated time!");
                    System.out.printf("Start login time: " + LoginPage.getStartLoginTime());
                    System.out.printf("End login time: " + LoginPage.getEndLoginTime());
                else {
                    Student curStudent =  // smth smth
                    System.out.println("Welcome to NTU Stars Planner!");
                    System.out.println("1. Add Course");
                    System.out.println("2. Drop Course");
                    System.out.println("3. Check/Print Courses Registered");
                    System.out.println("4. Check Vacancies Available");
                    System.out.println("5. Change Index Number of Course");
                    System.out.println("6. Swop Index Number with Another Student");
                
                    int studentChoice = sc.nextInt();
                    switch (studentChoice) {
                        case 1:
    
                            System.out.println("Choose the course to be added: ");
                            for (int i=0; i<=courseList.length(); i++){
                                System.out.printf("%d", i);
                                System.out.printf("%s", i.getCode());
                                System.out.println(i.getCourseName());
                            }
                            int courseChoice = sc.nextInt();
                            for (int i=0; i<= courseList[courseChoice].getIndex().length(); i++){
                                System.out.printf("%d", courseList[i].getIndexID());
                            }
                            System.out.println("Choose index to be added: ");
                            int indexChoice = sc.nextInt();
                            for (int i=0; i<=courseList[courseChoice])
                            courseList[courseChoice].getIndex());

                            curStudent.registerIndex();




                            


                    }



                }
            default:
                System.out.println("Not valid choice!");

        }

    
}
