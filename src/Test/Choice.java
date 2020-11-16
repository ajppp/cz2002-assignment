//TODO: add error checking in case the admin is an idiot that gives string for ints and whatever... basically if else statement.. yippee for a 1k line main function <3 
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Choice {
    public static void main(String[] args){
        ArrayList <Student> students = SerialEditor.loadStudents();
        ArrayList <Course> courses = SerialEditor.loadCourses(); 
        LoginPage loginTiming = SerialEditor.loadLoginTiming();
        LoginManager loginManager = SerialEditor.loadLoginDetails();
        for(Course course:courses){
            System.out.printf("%s %s \n", course.getCourseCode(), course.getCourseName());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to NTU Stars!");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                if (AdminManager.login(loginManager) == 0){
                    System.out.println("You have entered the wrong password too many times");
                    return;
                }
                else if (AdminManager.login(loginManager) == 1){
                    AdminManager.printAdminOptions();
                    int adminChoice = sc.nextInt();
                    switch(adminChoice){
                        case 1:
                            AdminManager.editAccessPeriod(loginTiming);
                            break;
                        case 2:
                            AdminManager.addStudent(students);
                            break;
                        case 3:
                            System.out.println("Current courses: ");
                            printCourses(courses);
                            System.out.println("1. Add new course");
                            System.out.println("2. Update existing course");
                            System.out.println("3. Update existing course index");
                            int case3choice = sc.nextInt();
                            switch(case3choice){
                                case 1:    
                                    AdminManager.addCourse(courses);
                                    break;
                                case 2:
                                    System.out.println("Choose which course to update: ");
                                    printCourses(courses);
                                    int updateCourseChoice = sc.nextInt();
                                    AdminManager.updateCourse(courses.get(updateCourseChoice));
                                    break;
                                case 3:
                                    System.out.println("Choose which course to update");
                                    printCourses(courses);
                                    updateCourseChoice = sc.nextInt();
                                    System.out.println("Choose which index to update");
                                    printIndices(courses.get(updateCourseChoice).getIndex());
                                    int updateCourseIndexChoice = sc.nextInt();
                                    AdminManager.updateIndex(courses.get(updateCourseChoice).getIndex().get(updateCourseIndexChoice));
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("Choose course to view vacancies: ");
                            printCourses(courses);
                            int courseChoice = sc.nextInt();
                            printIndices(courses.get(courseChoice).getIndex());
                            System.out.println("Choose index of course to view vacancies: ");
                            int indexChoice = sc.nextInt();
                            System.out.printf("The number of vacancies for index %d of course %s is %d", courses.get(courseChoice).getIndex().get(indexChoice).getIndexID(), courses.get(courseChoice).getCourseCode(), courses.get(courseChoice).getIndex().get(indexChoice).getVacancies());
                            break;
                        case 5:
                            System.out.println("Choose course to view student namelist: ");
                            printCourses(courses);
                            courseChoice = sc.nextInt();
                            printIndices(courses.get(courseChoice).getIndex());
                            System.out.println("Choose index of course to view student namelist: ");
                            indexChoice = sc.nextInt();
                            for (int i = 0; i < courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().size(); i++){
                                System.out.printf("%d %d %s", i, courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().get(i).getStudentID(), courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().get(i).getStudentName());
                            }
                            break;

                        case 6:
                            System.out.println("Choose course to view student namelist: ");
                            printCourses(courses);
                            courseChoice = sc.nextInt();
                            // to be clear, i = index, j = student 
                            for (int i = 0; i < courses.get(courseChoice).getIndex().size(); i++){
                                for (int j = 0; j < courses.get(courseChoice).getIndex().get(j).listRegisteredStudents().size(); j++) {
                                    System.out.printf("Namelist of Index %d", courses.get(courseChoice).getIndex().get(i).getIndexID());
                                    System.out.printf("%d %d %s", j, courses.get(courseChoice).getIndex().get(i).listRegisteredStudents().get(j).getStudentID(), courses.get(courseChoice).getIndex().get(i).listRegisteredStudents().get(j).getStudentName());
                                }
                            break;
                        }
                    }
                }
                break;
            case 2:
                Student curStudent = new Student();
                if(StudentManager.studentLogin(loginManager, loginTiming, students, curStudent) == 0){
                    System.out.println("Thanks for using NTU Stars. Ciao");
                    return;
                }
                else if (StudentManager.studentLogin(loginManager, loginTiming, students, curStudent) == 1){
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
                            if(compareClash(curStudent, courses.get(courseChoice).getIndex().get(indexChoice)))
                                System.out.println("There is a clash");
                            else
                                curStudent.registerIndex(courses.get(courseChoice).getIndex().get(indexChoice));
                            break;
                        case 2:
                            printRegisteredCourses(curStudent);
                            System.out.println("Choose the course to be dropped: ");
                            indexChoice = sc.nextInt();
                            int indexIDToBeDropped = curStudent.getRegisteredIndices().get(indexChoice).getIndexID();
                            curStudent.dropIndex(indexIDToBeDropped, curStudent.getRegisteredIndices().get(indexChoice).getCourseAU());
                            break;
                        case 3:
                            printRegisteredCourses(curStudent);
                            break;
                        case 4:
                            System.out.println("Choose the course to view vacancies: ");
                            printCourses(courses);
                            courseChoice = sc.nextInt();
                            printIndices(courses.get(courseChoice).getIndex());
                            System.out.println("Choose index to view vacancies: ");
                            indexChoice = sc.nextInt();
                            System.out.printf("The number of vacancies for index %d is %d", courses.get(courseChoice).getIndex().get(indexChoice), courses.get(courseChoice).getIndex().get(indexChoice).getVacancies());
                            break;
                        case 5:
                            printRegisteredCourses(curStudent);
                            System.out.println("Choose the course to change index: ");
                            courseChoice = sc.nextInt();
                            String codeOfCourseToBeChanged = curStudent.getRegisteredIndices().get(courseChoice).getCourseCode();
                            Index indexToBeDropped = curStudent.getRegisteredIndices().get(courseChoice);
                            indexIDToBeDropped = curStudent.getRegisteredIndices().get(courseChoice).getIndexID();
                            for (Course course:courses){
                                if (course.getCourseCode().equalsIgnoreCase(codeOfCourseToBeChanged))
                                    for (Index index:course.getIndex()){
                                        int i = 0;
                                        System.out.printf("%d) %d %d %d\n", i, index.getIndexID(), index.getVacancies(), index.getStudentWaitlist().size());
                                        i++;
                                    }
                            }
                            System.out.println("Choose new index: ");
                            indexChoice = sc.nextInt();
                            Index indexToBeAdded = courses.get(courseChoice).getIndex().get(indexChoice);
                            int indexIDToBeAdded = courses.get(courseChoice).getIndex().get(indexChoice).getIndexID();
                            // implement the checking
                            if (indexIDToBeDropped != indexIDToBeAdded){
                                curStudent.dropIndex(indexIDToBeDropped, curStudent.getRegisteredIndices().get(courseChoice).getCourseAU());
                                curStudent.registerIndex(indexToBeAdded);
                            }
                            break;
                        case 6:
                            // TODO: swap index number of course
                            /*
                             *System.out.println("Please insert your UserID: ");
                             *String swappedStudentUserID = sc.nextLine();
                             *System.out.println("Please insert your password: ");
                             *String swappedStudentPassword = sc.nextLine();
                             *Student swapperStudent;
                             *if (!loginManager.studentCompare(swappedStudentUserID, swappedStudentPassword)){
                             *    System.out.println("Wrong Password");
                             *    return; 
                             *}
                             *else{
                             *    for (Student student : students){
                             *        if (student.getStudentID() == inputUserID){
                             *            swapperStudent = student;
                             *        }
                             *        break;
                             *    }
                             *}
                             *printRegisteredCourses(curStudent);
                             *System.out.println("Choose the course to change index: ");
                             *courseChoice = sc.nextInt();
                             *codeOfCourseToBeChanged = curStudent.getRegisteredIndices().get(courseChoice).getCourseCode();
                             *indexIDToBeDropped = curStudent.getRegisteredIndices().get(courseChoice).getIndexID();
                             *int i = 0;
                             *for (Index index: swapperStudent.getRegisteredIndices()){
                             *    if (index.getCourseCode().equalsIgnoreCase(codeOfCourseToBeChanged)){
                             *        Index indexOfSwapperStudent = swapperStudent.getRegisteredIndices().get(i);
                             *        int indexIDToBeSwapped = indexOfSwapperStudent.getIndexID();
                             *    }
                             *    i++;
                             *}
                             *break;
                             */

                        default:
                            System.out.println("Not a valid choice! Please insert a number from 1 - 6");
                    }
                }
            default:
                System.out.println("Not valid choice!");
            }
        }
    public static void printCourses(ArrayList<Course> courses){
        int i = 0;
        for (Course course: courses){
            System.out.printf("%d %s %s \n", i, course.getCourseCode(), course.getCourseName());
            i++;
        }
    }

    public static void printIndices(ArrayList <Index> indices){
        int i = 0;
        for (Index index: indices){
            System.out.printf(" %d %d %d\n", index.getIndexID(), index.getVacancies(), index.getStudentWaitlist().size());
            int j = 0;
            for(Lesson lesson: index.getLessonList()){
                System.out.printf("%d %s %s %s %s %s", j, lesson.getLessonTypeStr(), lesson.getLessonDayStr(), lesson.getStartTime(), lesson.getEndTime(), lesson.getVenue());
                j++;
            }
            i++;
        }
    }

    public static void printRegisteredCourses(Student curStudent){
        for (int i = 0; i < curStudent.getRegisteredIndices().size(); i++){
            System.out.printf("%d|%d|%s\n", i, curStudent.getRegisteredIndices().get(i).getIndexID(), curStudent.getRegisteredIndices().get(i).getCourseName());
        }
    }

    public static boolean compareClash(Student curStudent, Index addedIndex){
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
                                return clash;
                            }
                            else if (addedLessonEndPeriod > registeredLessonStartPeriod && addedLessonEndPeriod < registeredLessonEndPeriod){
                                System.out.println("clash");
                                clash = true;
                                return clash;
                            }
                        }
                    }
                }
            }
        }
        return clash;
    }
}
