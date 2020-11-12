import java.util.*;
import java.io.*;
// import LoginPage
import java.text.SimpleDateFormat;

public class Choice {
    public static void main(String[] args){
        // initialise a new array list of students, indices and courses and read in from the existing data.
        ArrayList <Student> students = SerialEditor.loadStudents();
        ArrayList <Index> indices = SerialEditor.loadIndices();
        ArrayList <Course> courses = SerialEditor.loadCourses(); 
        LoginPage loginTiming = SerialEditor.loadLogin();
        LoginManager loginManager = SerialEditor.loadLoginDetails();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to NTU Stars!");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                // TODO: all the admin stuff
                System.out.println("Please type your Admin ID: ");
                String inputAdminID = sc.nextLine();
                System.out.println("Please type your password: ");
                String inputPassword = sc.nextLine();
                if (!loginManager.adminCompare(inputAdminID, inputPassword)){
                    System.out.println("Wrong Password");
                }
                else {
                    System.out.println("Welcome to NTU Stars Planner!");
                    System.out.println("1. Edit student access period");
                    System.out.println("2. Add a student");
                    System.out.println("3. Add/Update a course");
                    System.out.println("4. Check available slot for an index number (vacancy in a class)");
                    System.out.println("5. Print student list by index number");
                    System.out.println("6. Print student list by course");
                    int adminChoice = sc.nextInt();
                    switch(adminChoice){
                        case 1:
                            // cloud note: i dont know why it is loginTiming, not loginPage. shouldnt it be LoginPage? but loginTiming gives me red squiggly line >:(
                            System.out.printf("Current start login timing: " + loginTiming.getStartLoginTime());
                            System.out.printf("Current end login timing: " + loginTiming.getEndLoginTime());
                            System.out.println("Enter new start login timing (in format HHMM): ");
                            String newStartLoginTime = sc.nextLine();
                            Date startLoginTime = new SimpleDateFormat("HHmm").parse(newStartLoginTime);
                            System.out.println("Enter new end login timing (in format HHMM): ");
                            String newEndLoginTime = sc.nextLine();
                            Date endLoginTime =  new SimpleDateFormat("HHmm").parse(newEndLoginTime);
                            loginPage.setStartLoginTime(startLoginTime);
                            loginPage.setEndLoginTime(endLoginTime);
                            System.out.println("Successfully changed login timing period!");
                            break;
                        case 2:
                            System.out.println("Current student list: ");
                            for (int i=0; i<students.size(); i++){
                                System.out.printf("%d %d %s", i, students.get(i).getStudentID(), students.get(i).getStudentName());
                            };
                            System.out.println("Input new Student name: ");
                            String studentName = sc.nextLine();
                            System.out.println("Input new Student school: ");
                            String studentSchool = sc.nextLine();
                            System.out.println("Input new Student gender (M/F): ");
                            String studentGender = sc.nextLine();
                            System.out.println("Input new Student nationality: ");
                            String studentNationality = sc.nextLine();
                            // TODO: use REGEX!!! :D to check email~~~ 
                            System.out.println("Input new Student email: "); 
                            String studentEmail = sc.nextLine();
                            Student addedStudent = new Student(studentName, studentSchool, studentGender, studentNationality, studentEmail);
                            students.add(addedStudent);
                            break;
                        case 3:
                            // sry jeth ill leave u to it
                            System.out.println("Current courses: ");
                            printCourses(courses);
                            System.out.println("1. Add new course");
                            System.out.println("2. Update existing course");
                            int case3choice = sc.nextInt();
                            switch(case3choice){
                                case 1:    

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
                            for (int i=0; i<courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().size(); i++){
                                System.out.printf("%d %d %s", i, courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().get(i).getStudentID(), courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().get(i).getStudentName());
                            }
                            break;
                        case 6:
                            System.out.println("Choose course to view student namelist: ");
                            printCourses(courses);
                            courseChoice = sc.nextInt();
                            // to be clear, i = index, j = student 
                            for (int i=0; i<courses.get(courseChoice).getIndex().size(); i++){
                                for (int j=0; j<courses.get(courseChoice).getIndex().get(indexChoice).listRegisteredStudents().size(); j++) {
                                    System.out.printf("Namelist of Index %d", courses.get(courseChoice).getIndex().get(i).getIndexID());
                                    System.out.printf("%d %d %s", j, courses.get(courseChoice).getIndex().get(i).listRegisteredStudents().get(j).getStudentID(), courses.get(courseChoice).getIndex().get(i).listRegisteredStudents().get(j).getStudentName());
                                }
                            }
                            break;
                    }
                }
            }
            break;

            case 2:
                Calendar cal = Calendar.getInstance();
                Date dateNow = cal.getTime();
                if (loginTiming.compareCurrentTime(dateNow) == false){
                    System.out.println("Please try again during the stipulated time!");
                    System.out.printf("Start login time: " + loginTiming.getStartLoginTime());
                    System.out.printf("End login time: " + loginTiming.getEndLoginTime());
                }
                else {
                    System.out.println("Please insert your UserID: ");
                    String inputUserID = sc.nextLine();
                    System.out.println("Please insert your password: ");
                    inputPassword = sc.nextLine();
                    Student curStudent;
                    if (!loginManager.studentCompare(inputUserID, inputPassword)){
                        System.out.println("Wrong Password");
                        return; 
                    }
                    else{
                        for (Student student: students){
                            if (student.getStudentID() == inputUserID){
                                curStudent = student;
                                break;
                            }
                        }
                    }
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
                            int indexIDToBeDropped = curStudent.getRegisteredIndices().get(courseChoice).getIndexID();
                            curStudent.dropIndex(indexIDToBeDropped, curStudent.getRegisteredIndices().get(courseChoice).getCourseAU());
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
                            printRegisteredCourses(curStudent);
                            System.out.println("Choose the course to change index: ");
                            courseChoice = sc.nextInt();
                            codeOfCourseToBeChanged = curStudent.getRegisteredIndices().get(courseChoice).getCourseCode();
                            indexIDToBeDropped = curStudent.getRegisteredIndices().get(courseChoice).getIndexID();
                            System.out.println("Student ID: ");

                            String studentID = sc.next();
                            String password = PasswordField.readPassword("Password: "); // remember to put eraser class in same dir
                            // check if student exists 
                            if (studentExists){
                                Student swapperStudent;
                            }
                            else{
                                System.out.println("Student does not exist!");
                                break;
                            }
                            int i = 0;
                            for (Index index: swapperStudent.getRegisteredIndices()){
                                if (index.getCourseCode().equalsIgnoreCase(codeOfCourseToBeChanged)){
                                    Index indexOfSwapperStudent = swapperStudent.getRegisteredIndices().get(i).getIndex();
                                }
                                i++;
                            };
                            indexIDToBeSwapped = indexOfSwapperStudent.getIndexID();
                            

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
        for (Course course: courses){
            int i = 0;
            System.out.printf("%d %s %s \n", i, course.getCode(), course.getCourseName());
            i++;
        }
    }

    public static void printIndices(ArrayList <Index> indices){
        for (Index index: indices){
            int i = 0;
            System.out.printf("%d %d %d\n", index.getIndexID(), index.getVacancies(), index.getStudentWaitlist().size());
            for(Lesson lesson: index.getLessonList()){
                int j = 0;
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
