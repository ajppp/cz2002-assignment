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
                // TODO: all the admin stuff
                break;
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
                            System.out.println("Choose the course to be added: ");
                            printCourses(courses);
                            int courseChoice = sc.nextInt();
                            printIndices(courses.get(courseChoice).getIndex());
                            System.out.println("Choose index to be added: ");
                            int indexChoice = sc.nextInt();
                            // TODO: call the scheduler to see if there are any clashes
                            if(){
                                curStudent.registerIndex(courses.get(courseChoice).getIndex().get(indexChoice));
                            }
                            else{
                                System.out.println("There is a clash");
                            }
                            
                            break;
                        case 2:
                            // TODO: print list of courses
                            printRegisteredCourses(curStudent);
                            System.out.println("Choose the course to be dropped: ");
                            courseChoice = sc.nextInt();
                            curStudent.dropIndex(courseChoice, curStudent.getRegisteredIndices().get(courseChoice).getAU());
                            break;
                        case 3:
                            printRegisteredCourses(curStudent);
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
    public static void printCourses(ArrayList <Course> courses){
        //for (int i = 0; i < courses.size(); i++) {
        for (Course course: courses){
            int i = 0;
            System.out.printf("%d %s %s \n", i, course.getCode(), course.getCourseName());
            i++;
        }
    }

    public static void printIndices(ArrayList <Index> indices){
        for (Index index: indices){
            int i = 0;
            System.out.printf("%d\n", index.getIndexID());
            for(Lesson lesson: index.getLessonList()){
                int j = 0;
                System.out.printf("%d %s %s %s %s %s", j, lesson.getLessonTypeStr(), lesson.getLessonDayStr(), lesson.getStartTime(), lesson.getEndTime(), lesson.getVenue());
            }
        }
    }

    public static void printRegisteredCourses(Student curStudent){
        for (int i = 0; i < curStudent.getRegisteredIndices().size(); i++){
            System.out.printf("%d %d\n", i, curStudent.getRegisteredIndices().get(i).getIndexID());
        }
    }

    public void compareClash(Student curStudent, Index addedIndex){
        boolean clash = false;
        // get timing of all lessons in the index to be added
        while (!clash){
            for(int i = 0; i < addedIndex.getLessonList().size(); i++){
                int addedLessonDay = addedIndex.getLessonList().get(i).getLessonDay();
                int addedLessonStartPeriod = addedIndex.getLessonList().get(i).getStartPeriod();
                int addedLessonEndPeriod = addedIndex.getLessonList().get(i).getEndPeriod();
                for(int j = 0; j < curStudent.getRegisteredIndices().size(); j++){
                    for (int k = 0; k < curStudent.getRegisteredIndices().get(j).getLessonList().size(); k++){
                        int registeredLessonDay = curStudent.getRegisteredIndices().get(j).getLessonList().get(k).getLessonDay();
                        int registeredLessonStartPeriod = curStudent.getRegisteredIndices().get(j).getLessonList().get(k).getStartPeriod();
                        int registeredLessonEndPeriod = curStudent.getRegisteredIndices().get(j).getLessonList().get(k).getEndPeriod();
                        if (addedLessonDay == registeredLessonDay){
                            if (addedLessonStartPeriod > registeredLessonStartPeriod && addedLessonStartPeriod < registeredLessonEndPeriod){
                                System.out.println("clash");
                                clash = true;
                                break;
                            }
                            else if (addedLessonEndPeriod > registeredLessonStartPeriod && addedLessonEndPeriod < registeredLessonEndPeriod){
                                System.out.println("clash");
                                clash = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
}

    }
