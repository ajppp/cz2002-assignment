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
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to NTU Stars!");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                int adminLoginResult = AdminManager.login(loginManager);
                if (adminLoginResult == 0){
                    System.out.println("You have entered the wrong password too many times");
                    return;
                }
                else if (adminLoginResult == 1){
                    while(true){
                        AdminManager.printAdminOptions();
                        int adminChoice = sc.nextInt();
                        switch(adminChoice){
                            case 1:
                                loginTiming = AdminManager.editAccessPeriod(loginTiming);
                                System.out.println(loginTiming.getStartLoginTime().toGMTString());
                                System.out.println(loginTiming.getEndLoginTime().toGMTString());
                                SerialEditor.writeLoginTiming(loginTiming);
                                break;
                            case 2:
                                Student newStudent = AdminManager.addStudent(students);
                                SerialEditor.writeStudents(students);
                                loginManager.storeStudentPassword(newStudent.getStudentID(), "password");
                                SerialEditor.writeLoginDetails(loginManager);
                                System.out.printf("The added student's ID is: %s\n", newStudent.getStudentID());
                                break;
                            case 3:
                                printCourses(courses);
                                System.out.println("1. Add new course");
                                System.out.println("2. Update existing course");
                                System.out.println("3. Update existing course index");
                                // we do not update indices, we add indices
                                int case3choice = sc.nextInt();
                                switch(case3choice){
                                    case 1:    
                                        AdminManager.addCourse(courses);
                                        break;
                                    case 2:
                                        System.out.println("Choose which course to update: ");
                                        printCourses(courses);
                                        int updateCourseChoice = sc.nextInt() - 1;
                                        AdminManager.updateCourse(courses.get(updateCourseChoice));
                                        break;
                                    case 3:
                                        System.out.println("Choose which course to update");
                                        printCourses(courses);
                                        updateCourseChoice = sc.nextInt() - 1;
                                        System.out.println("Choose which index to update");
                                        printIndices(courses.get(updateCourseChoice).getIndex());
                                        int updateCourseIndexChoice = sc.nextInt() - 1;
                                        AdminManager.updateIndex(courses.get(updateCourseChoice).getIndex().get(updateCourseIndexChoice));
                                        break;
                                }
                                break;
                            case 4:
                                System.out.println("Choose course to view vacancies: ");
                                printCourses(courses);
                                int courseChoice = sc.nextInt() - 1;
                                printIndices(courses.get(courseChoice).getIndex());
                                System.out.println("Choose index of course to view vacancies: ");
                                int indexChoice = sc.nextInt() - 1;
                                System.out.printf("The number of vacancies for index %d of course %s is %d\n", courses.get(courseChoice).getIndex().get(indexChoice).getIndexID(), courses.get(courseChoice).getCourseCode(), courses.get(courseChoice).getIndex().get(indexChoice).getVacancies());
                                break;
                            case 5:
                                System.out.println("Choose course to view student namelist: ");
                                printCourses(courses);
                                courseChoice = sc.nextInt() - 1;
                                printIndices(courses.get(courseChoice).getIndex());
                                System.out.println("Choose index of course to view student namelist: ");
                                indexChoice = sc.nextInt() - 1;
                                for (int i = 1; i < courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().size() + 1; i++){
                                    System.out.printf("%d %s %s\n", i, courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().get(i - 1).getStudentID(), courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().get(i - 1).getStudentName());
                                }
                                break;
    
                            case 6:
                                System.out.println("Choose course to view student namelist: ");
                                printCourses(courses);
                                courseChoice = sc.nextInt() - 1;
                                // to be clear, i = index, j = student 
                                for (int i = 1; i < courses.get(courseChoice).getIndex().size() + 1; i++){
                                    for (int j = 1; j < courses.get(courseChoice).getIndex().get(i - 1).listRegisteredStudents().size() + 1; j++) {
                                        System.out.printf("Namelist of Index %d\n", courses.get(courseChoice).getIndex().get(i - 1).getIndexID());
                                        System.out.printf("%d %s %s\n", j, courses.get(courseChoice).getIndex().get(i - 1).listRegisteredStudents().get(j - 1).getStudentID(), courses.get(courseChoice).getIndex().get(i - 1).listRegisteredStudents().get(j - 1).getStudentName());
                                    }
                                }
                                break;
                            }
                        }
                    }
                    
            case 2:
                Student curStudent = new Student();
                String studentLoginResult = StudentManager.studentLogin(loginManager, loginTiming, students, curStudent);
                if(studentLoginResult.equals("0")){
                    System.out.println("Thanks for using NTU Stars. Ciao");
                    return;
                }
                else{
                    int studentChoice;
                    for (Student student: students){
                        if (student.getStudentID().equals(studentLoginResult)){
                            curStudent = student;
                            break;
                        }
                    }
                    do {
                        System.out.println("Welcome to NTU Stars Planner!");
                        System.out.println("1. Add Course");
                        System.out.println("2. Drop Course");
                        System.out.println("3. Check/Print Courses Registered");
                        System.out.println("4. Check Vacancies Available");
                        System.out.println("5. Change Index Number of Course");
                        System.out.println("6. Swap Index Number with Another Student");
                        System.out.println("7. Exit :D");
                        System.out.println(curStudent.getStudentRegisteredAU());
                        studentChoice = sc.nextInt();
                        switch (studentChoice) {
                            case 1:
                                System.out.println("Choose the course to be added: ");
                                printCourses(courses);
                                int courseChoice = sc.nextInt() - 1;
                                printIndices(courses.get(courseChoice).getIndex());
                                System.out.println("Choose index to be added: ");
                                int indexChoice = sc.nextInt() - 1;
                                if(compareClash(curStudent, courses.get(courseChoice).getIndex().get(indexChoice)))
                                    System.out.println("There is a clash");
                                else {
                                    curStudent.registerIndex(courses.get(courseChoice).getIndex().get(indexChoice));
                                    // changing course details
                                    courses.get(courseChoice).getIndex().get(indexChoice).studentAddedToIndex(curStudent);
                                }
                                break;
                            case 2:
                                printRegisteredCourses(curStudent);
                                System.out.println("Choose the course to be dropped: ");
                                indexChoice = sc.nextInt() - 1;
                                int indexIDToBeDropped = curStudent.getRegisteredIndices().get(indexChoice).getIndexID();
                                String courseCodeToDrop = curStudent.getRegisteredIndices().get(indexChoice).getCourseCode();
                                // changing course details
                                for(Course course: courses){
                                    if(course.getCourseCode().equals(courseCodeToDrop)){
                                        for(Index index: course.getIndex()){
                                            if(index.getIndexID() == indexIDToBeDropped){
                                                index.removeStudentFromIndex(curStudent);
                                                break;
                                            }
                                        }
                                    }
                                }
                                curStudent.dropIndex(indexIDToBeDropped, curStudent.getRegisteredIndices().get(indexChoice).getCourseAU());
                                break;
                            case 3:
                                printRegisteredCourses(curStudent);
                                System.out.println("Finished printing registered courses");
                                break;
                            case 4:
                                System.out.println("Choose the course to view vacancies: ");
                                printCourses(courses);
                                courseChoice = sc.nextInt() - 1;
                                printIndices(courses.get(courseChoice).getIndex());
                                /* System.out.println("Choose index to view vacancies: ");
                                indexChoice = sc.nextInt();
                                System.out.printf("The number of vacancies for index %d is %d", courses.get(courseChoice).getIndex().get(indexChoice), courses.get(courseChoice).getIndex().get(indexChoice).getVacancies()); */
                                break;
                            case 5:
                                printRegisteredCourses(curStudent);
                                System.out.println("Choose the course to change index: ");
                                courseChoice = sc.nextInt() - 1;
                                String codeOfCourseToBeChanged = curStudent.getRegisteredIndices().get(courseChoice).getCourseCode();
                                Index indexToBeDropped = curStudent.getRegisteredIndices().get(courseChoice);
                                indexIDToBeDropped = curStudent.getRegisteredIndices().get(courseChoice).getIndexID();
                                for (Course course:courses){
                                    if (course.getCourseCode().equalsIgnoreCase(codeOfCourseToBeChanged)){
                                        int i = 1;
                                        for (Index index:course.getIndex()){
                                            System.out.printf("%d) %d %d %d\n", i, index.getIndexID(), index.getVacancies(), index.getStudentWaitlist().size());
                                            i++;
                                        }
                                    }
                                }
                                System.out.println("Choose new index: ");
                                indexChoice = sc.nextInt() - 1;
                                Index indexToBeAdded = courses.get(courseChoice).getIndex().get(indexChoice);
                                int indexIDToBeAdded = courses.get(courseChoice).getIndex().get(indexChoice).getIndexID();
                                // implement the checking
                                if (indexIDToBeDropped != indexIDToBeAdded){
                                    curStudent.dropIndex(indexIDToBeDropped, curStudent.getRegisteredIndices().get(courseChoice).getCourseAU());
                                    curStudent.registerIndex(indexToBeAdded);
                                    indexToBeDropped.removeStudentFromIndex(curStudent);
                                    indexToBeAdded.studentAddedToIndex(curStudent);
                                }
                                break;
                            case 6:
                                // TODO: swap index number of course
                                printRegisteredCourses(curStudent);
                                System.out.println("Choose the course to change index: ");
                                courseChoice = sc.nextInt() - 1;

                                Student swapperStudent = new Student();
                                studentLoginResult = StudentManager.studentLogin(loginManager, loginTiming, students, swapperStudent);
                                if(studentLoginResult.equals("0")){
                                    System.out.println("Wrong password!");
                                    break;
                                }
                                else {
                                    for (Student student: students){
                                        if (student.getStudentID().equals(studentLoginResult)){
                                            swapperStudent = student;
                                            break;
                                        }
                                    }
                                }
                                codeOfCourseToBeChanged = curStudent.getRegisteredIndices().get(courseChoice).getCourseCode();
                                indexIDToBeDropped = curStudent.getRegisteredIndices().get(courseChoice).getIndexID();
                                indexToBeDropped = curStudent.getRegisteredIndices().get(courseChoice);
                                for (Index index: swapperStudent.getRegisteredIndices()){
                                    if (index.getCourseCode().equals(codeOfCourseToBeChanged)){
                                        curStudent.dropIndex(indexIDToBeDropped, index.getCourseAU());
                                        curStudent.registerIndex(index);
                                        index.removeRegisteredStudent(swapperStudent);
                                        index.addRegisteredStudent(curStudent);
                                        
                                        swapperStudent.dropIndex(index.getIndexID(), index.getCourseAU());
                                        swapperStudent.registerIndex(indexToBeDropped);
                                        indexToBeDropped.removeRegisteredStudent(curStudent);
                                        indexToBeDropped.addRegisteredStudent(swapperStudent);
                                        System.out.println("Successfully swapped index with student!");

                                        /* for (Course course: courses){
                                            for (Index index1: course.getIndex()){
                                                if (indexIDToBeDropped == index1.getIndexID()){
                                                    index1.studentAddedToIndex(swapperStudent);
                                                    index1.removeStudentFromIndex(curStudent);
                                                }
                                                else if (newIndexID == index1.getIndexID()){
                                                    index1.studentAddedToIndex(curStudent);
                                                    index1.removeStudentFromIndex(swapperStudent);
                                                }
                                            }
                                        break;
                                        } */
                                    }
                                }
                                break;
                            case 7:
                                SerialEditor.writeCourses(courses);
                                SerialEditor.writeStudents(students);
                                System.out.println("Thanks for using NTU Stars. Bye");
                                System.exit(0);
                                break;

                            default:
                                SerialEditor.writeCourses(courses);
                                SerialEditor.writeStudents(students);
                        }

                    } while (true);
                }
            default:
                System.out.println("Not valid choice!");
            }
        }
    public static void printCourses(ArrayList<Course> courses){
        int i = 1;
        for (Course course: courses){
            System.out.printf("%d %s %s \n", i, course.getCourseCode(), course.getCourseName());
            i++;
        }
    }

    public static void printIndices(ArrayList <Index> indices){
        int i = 1;
        for (Index index: indices){
            System.out.printf("%d)Index ID: %d\nIndex Vacancy:%d\nIndex Waitlist Size:%d\n", i, index.getIndexID(), index.getVacancies(), index.getStudentWaitlist().size());
            for(Lesson lesson: index.getLessonList()){
                System.out.printf("%s %s %s %s %s \n", lesson.getLessonTypeStr(), lesson.getLessonDayStr(), lesson.getStartTime(), lesson.getEndTime(), lesson.getVenue());
            }
            i++;
        }
    }

    public static void printRegisteredCourses(Student curStudent){
        for (int i = 0; i < curStudent.getRegisteredIndices().size(); i++){
            System.out.printf("%d|%d|%s\n", i+1, curStudent.getRegisteredIndices().get(i).getIndexID(), curStudent.getRegisteredIndices().get(i).getCourseName());
        }
    }

    public static boolean compareClash(Student curStudent, Index addedIndex){
        boolean clash = false;
        // get timing of all lessons in the index to be added
        //while (!clash){
        if(curStudent.getRegisteredIndices().size() == 0){
            return clash = false;
        }
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
        //}
        return clash;
    }
}
