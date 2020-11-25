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
                                System.out.println(loginTiming.getStartLoginTime().toLocaleString());
                                System.out.println(loginTiming.getEndLoginTime().toLocaleString());
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
                                        printIndices(courses.get(updateCourseChoice).getCourseIndex());
                                        int updateCourseIndexChoice = sc.nextInt() - 1;
                                        AdminManager.updateIndex(courses.get(updateCourseChoice).getCourseIndex().get(updateCourseIndexChoice));
                                        break;
                                }
                                break;
                            case 4:
                                System.out.println("Choose course to view vacancies: ");
                                printCourses(courses);
                                int courseChoice = sc.nextInt() - 1;
                                printIndices(courses.get(courseChoice).getCourseIndex());
                                System.out.println("Choose index of course to view vacancies: ");
                                int indexChoice = sc.nextInt() - 1;
                                System.out.printf("The number of vacancies for index %d of course %s is %d\n", courses.get(courseChoice).getCourseIndex().get(indexChoice).getIndexID(), courses.get(courseChoice).getCourseCode(), courses.get(courseChoice).getCourseIndex().get(indexChoice).getVacancies());
                                break;
                            case 5:
                                printCourses(courses);
                                courseChoice = -1;
                                while (courseChoice == -1){
                                    System.out.println("Choose course to view student namelist: ");
                                    int temp = sc.nextInt() - 1;
                                    if (temp >= 0 && temp < courses.size()){
                                        courseChoice = temp;
                                    }
                                    else{
                                        System.out.println("The course does not exist. Please enter a valid number from the option given above");
                                    }
                                }
                                printIndices(courses.get(courseChoice).getCourseIndex());
                                indexChoice = -1;
                                while (indexChoice == -1){
                                    System.out.println("Choose index of course to view student namelist: ");
                                    int temp = sc.nextInt() - 1;
                                    if (temp >= 0 && temp < courses.get(courseChoice).getCourseIndex().size()){
                                        indexChoice = temp;
                                    }
                                    else{
                                        System.out.println("The index does not exist. Please enter a valid number from the option given above");
                                    }
                                }
                                for (int i = 1; i < courses.get(courseChoice).getCourseIndex().get(indexChoice).listRegisteredStudents().size() + 1; i++){
                                    System.out.printf("%d %s %s %s %s\n", i, courses.get(courseChoice).getCourseIndex().get(indexChoice).listRegisteredStudents().get(i - 1).getStudentID(), courses.get(courseChoice).getCourseIndex().get(indexChoice).listRegisteredStudents().get(i - 1).getStudentName(), courses.get(courseChoice).getCourseIndex().get(indexChoice).listRegisteredStudents().get(i - 1).getStudentNationality(), courses.get(courseChoice).getCourseIndex().get(indexChoice).listRegisteredStudents().get(i - 1).getStudentGender());
                                }
                                break;
    
                            case 6:
                                System.out.println("Choose course to view student namelist: ");
                                printCourses(courses);
                                courseChoice = -1;
                                while (courseChoice == -1){
                                    System.out.println("Choose course to be viewed: ");
                                    int temp = sc.nextInt() - 1;
                                    if (temp >= 0 && temp < courses.size()){
                                        courseChoice = temp;
                                    }
                                    else{
                                        System.out.println("The course does not exist. Please enter a valid number from the option given above");
                                    }
                                }
                                // to be clear, i = index, j = student 
                                for (int i = 1; i < courses.get(courseChoice).getCourseIndex().size() + 1; i++){
                                    System.out.printf("Namelist of Index %d\n", courses.get(courseChoice).getCourseIndex().get(i - 1).getIndexID());
                                    for (int j = 1; j < courses.get(courseChoice).getCourseIndex().get(i - 1).listRegisteredStudents().size() + 1; j++) {
                                        System.out.printf("%d %s %s %s %s\n", j, courses.get(courseChoice).getCourseIndex().get(i - 1).listRegisteredStudents().get(j - 1).getStudentID(), courses.get(courseChoice).getCourseIndex().get(i - 1).listRegisteredStudents().get(j - 1).getStudentName(), courses.get(courseChoice).getCourseIndex().get(i - 1).listRegisteredStudents().get(j - 1).getStudentNationality(), courses.get(courseChoice).getCourseIndex().get(i - 1).listRegisteredStudents().get(j - 1).getStudentGender());
                                    }
                                }
                                break;
                            case 7:
                                int i = 1;
                                for (Student student: students){
                                    System.out.printf("%d) %s %s\n", i, student.getStudentID(), student.getStudentName());
                                    i++;
                                }
                                int studentChoice = sc.nextInt() - 1;
                                Student addedStudent = students.get(studentChoice);
                                System.out.println("Choose course to add student: ");
                                printCourses(courses);
                                courseChoice = sc.nextInt() - 1;

                                int sameCourse = 0;
                                for (CourseIndex index: addedStudent.getRegisteredIndices()){
                                    if (courses.get(courseChoice).getCourseCode().equals(index.getCourseCode())){
                                        System.out.println("You have been registered or are in the waitlist for this course. Please drop the index before trying to add. Thanks");
                                        sameCourse = 1;
                                        break;
                                    }

                                }
                                if (sameCourse == 0){
                                    printIndices(courses.get(courseChoice).getCourseIndex());
                                    System.out.println("Choose index to be added: ");
                                    indexChoice = sc.nextInt() - 1;
                                    if(compareClash(addedStudent, courses.get(courseChoice).getCourseIndex().get(indexChoice)))
                                        System.out.println("There is a clash");
                                    else {
                                        addedStudent.registerIndex(courses.get(courseChoice).getCourseIndex().get(indexChoice));
                                        // changing course details
                                        courses.get(courseChoice).getCourseIndex().get(indexChoice).studentAddedToIndex(addedStudent);
                                    }
                                }
                                break;
                            case 8:
                                SerialEditor.writeCourses(courses);
                                SerialEditor.writeStudents(students);
                                System.out.printf("Thanks for using NTU Stars Admin. Bye");
                                System.exit(0);
                                break;
                            }
                        }
                    }
                break;
                    
            case 2:
                Student curStudent = new Student();
                String studentLoginResult = StudentManager.studentLogin(loginManager, loginTiming, students, curStudent);
                if(studentLoginResult.equals("0")){
                    System.out.println("Thanks for using NTU Stars.");
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
                        System.out.println();
                        System.out.println("Welcome to NTU Stars Planner!");
                        System.out.println("1. Add Course");
                        System.out.println("2. Drop Course");
                        System.out.println("3. Check/Print Courses Registered");
                        System.out.println("4. Check Vacancies Available");
                        System.out.println("5. Change Index Number of Course");
                        System.out.println("6. Swap Index Number with Another Student");
                        System.out.println("7. Exit");
                        System.out.printf("No of current AUS: %d\n", curStudent.getStudentRegisteredAU());
                        studentChoice = sc.nextInt();
                        switch (studentChoice) {
                            case 1:
                                System.out.println("Choose the course to be added: ");
                                printCourses(courses);
                                int courseChoice = -1;
                                while (courseChoice == -1){
                                    System.out.println("Choose course to be added: ");
                                    int temp = sc.nextInt() - 1;
                                    if (temp >= 0 && temp < courses.size()){
                                        courseChoice = temp;
                                    }
                                    else{
                                        System.out.println("The course does not exist. Please enter a valid number from the option given above");
                                    }
                                }
                                int sameCourse = 0;
                                for (CourseIndex index: curStudent.getRegisteredIndices()){
                                    if (courses.get(courseChoice).getCourseCode().equals(index.getCourseCode())){
                                        System.out.println("You have been registered or are in the waitlist for this course. Please drop the index before trying to add. Thanks");
                                        sameCourse = 1;
                                        break;
                                    }

                                }
                                if (sameCourse == 0){
                                    printIndices(courses.get(courseChoice).getCourseIndex());
                                    int indexChoice = -1;
                                    while (indexChoice == -1){
                                        System.out.println("Choose index to be added: ");
                                        int temp = sc.nextInt() - 1;
                                        if (temp >= 0 && temp < courses.get(courseChoice).getCourseIndex().size()){
                                            indexChoice = temp;
                                        }
                                        else{
                                            System.out.println("The course does not exist. Please enter a valid number from the option given above");
                                        }
                                    }
                                    if(compareClash(curStudent, courses.get(courseChoice).getCourseIndex().get(indexChoice)))
                                        System.out.println("There is a clash");
                                    else {
                                        boolean added = curStudent.registerIndex(courses.get(courseChoice).getCourseIndex().get(indexChoice));
                                        // changing course details
                                        if (added == true)
                                            courses.get(courseChoice).getCourseIndex().get(indexChoice).studentAddedToIndex(curStudent);
                                    }
                                }
                                break;
                            case 2:
                                printRegisteredCourses(curStudent);
                                System.out.println("Choose the course to be dropped: ");
                                int indexChoice = sc.nextInt() - 1;
                                int indexIDToBeDropped = curStudent.getRegisteredIndices().get(indexChoice).getIndexID();
                                String courseCodeToDrop = curStudent.getRegisteredIndices().get(indexChoice).getCourseCode();
                                // changing course details
                                for(Course course: courses){
                                    if(course.getCourseCode().equals(courseCodeToDrop)){
                                        for(CourseIndex index: course.getCourseIndex()){
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
                                System.out.println("These are your registered courses:");
                                System.out.printf("%s\n", "--------------------");
                                for (Course course:courses){
                                    for (CourseIndex index: course.getCourseIndex()){
                                        for (Student student: index.listStudentWaitlist()){
                                            if (student.getStudentID().equals(curStudent.getStudentID())){
                                                System.out.printf("Waitlisted course: ");
                                                System.out.printf("%d|%s\n", index.getIndexID(), index.getCourseName());
                                                break;
                                            }
                                        }
                                        for (Student student: index.listRegisteredStudents()){
                                            if (student.getStudentID().equals(curStudent.getStudentID())){
                                            System.out.printf("Confirmed course: ");
                                            System.out.printf("%d|%s\n", index.getIndexID(), index.getCourseName());
                                            break;
                                            }
                                        }
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Choose the course to view vacancies: ");
                                printCourses(courses);
                                indexChoice = -1;
                                while (indexChoice == -1){
                                    System.out.println("Choose index to view vacancies: ");
                                    int temp = sc.nextInt() - 1;
                                    if (temp >= 0 && temp < courses.size()){
                                        indexChoice = temp;
                                    }
                                    else{
                                        System.out.println("The course does not exist. Please enter a valid number from the option given above");
                                    }
                                }
                                printIndices(courses.get(indexChoice).getCourseIndex());
                                break;
                            case 5:
                                printRegisteredCourses(curStudent);
                                courseChoice = -1;
                                while (courseChoice == -1){
                                    System.out.println("Choose the course to change index: ");
                                    int temp = sc.nextInt() - 1;
                                    if (temp >= 0 && temp < curStudent.getRegisteredIndices().size()){
                                        courseChoice = temp;
                                    }
                                    else{
                                        System.out.println("The course does not exist. Please enter a valid number from the option given above");
                                    }
                                }
                                String codeOfCourseToBeChanged = curStudent.getRegisteredIndices().get(courseChoice).getCourseCode();
                                CourseIndex indexToBeDropped = curStudent.getRegisteredIndices().get(courseChoice);
                                indexIDToBeDropped = curStudent.getRegisteredIndices().get(courseChoice).getIndexID();
                            
                                for (Course course:courses){
                                    if (course.getCourseCode().equals(codeOfCourseToBeChanged)){
                                        int i = 1;
                                        if (course.getCourseIndex().size() > 1){
                                            for (CourseIndex index:course.getCourseIndex()){
                                                System.out.printf("\n%d) Index ID:%d \nVacancy:%d\n Index Total Size:%d\nWaitlist Size:%d\n", i, index.getIndexID(), index.getVacancies(), index.getMaxStudents(), index.getStudentWaitlist().size());
                                                i++;
                                            }
                                            indexChoice = -1;
                                            while (indexChoice == -1){
                                                System.out.println("Choose the index to change to: ");
                                                int temp = sc.nextInt() - 1;
                                                if (temp >= 0 && temp < course.getCourseIndex().size()){
                                                    indexChoice = temp;
                                                }
                                                else{
                                                    System.out.println("The index does not exist. Please enter a valid number from the option given above");
                                                }
                                            }
                                            System.out.println("Choose new index: ");
                                            indexChoice = sc.nextInt() - 1;
                                            CourseIndex indexToSwapTo = new CourseIndex();
                                            for (Course course1:courses){
                                                if (course1.getCourseCode().equals(codeOfCourseToBeChanged)){
                                                    indexToSwapTo = course1.getCourseIndex().get(indexChoice);
                                                }
                                            }
                                            curStudent.dropIndex(indexIDToBeDropped, curStudent.getRegisteredIndices().get(courseChoice).getCourseAU());
                                            curStudent.registerIndex(indexToSwapTo);
                                            indexToBeDropped.removeStudentFromIndex(curStudent);
                                            indexToSwapTo.studentAddedToIndex(curStudent);
                                            break;
                                        }
                                        else{
                                            System.out.println("This course only has one index!");
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 6:
                                printRegisteredCourses(curStudent);
                                System.out.println("Choose the course to change index: ");
                                courseChoice = sc.nextInt() - 1;
                                Student swapperStudent = new Student();
                                System.out.println("This is for the student you are swapping with:");
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
                                String affectedCourseCode = curStudent.getRegisteredIndices().get(courseChoice).getCourseCode();
                                CourseIndex currentStudentIndex = curStudent.getRegisteredIndices().get(courseChoice);
                                // String affectedCourseCode = "0";
                                int curStudentsNewIndexID = 0;
                                int swapperStudentsNewIndexID = 0;
                                for (CourseIndex index: swapperStudent.getRegisteredIndices()){
                                    if (index.getCourseCode().equals(affectedCourseCode)){
                                        curStudent.registerIndex(index);
                                        curStudentsNewIndexID = index.getIndexID();
                                        curStudent.dropIndex(currentStudentIndex.getIndexID(), currentStudentIndex.getCourseAU());
                                        swapperStudent.registerIndex(currentStudentIndex);
                                        swapperStudentsNewIndexID = currentStudentIndex.getIndexID();
                                        swapperStudent.dropIndex(index.getIndexID(), index.getCourseAU());
                                        System.out.println("finished swapping students");
                                        break;
                                    }
                                }

                                for (Course course: courses){
                                    if (course.getCourseCode().equals(affectedCourseCode)){
                                        for (CourseIndex index: course.getCourseIndex()){
                                            if (index.getIndexID() == curStudentsNewIndexID){
                                                System.out.println("changing new index");
                                                index.removeRegisteredStudent(swapperStudent);
                                                index.addRegisteredStudent(curStudent);
                                            }
                                            else if (index.getIndexID() == swapperStudentsNewIndexID){
                                                System.out.println("changing old index");
                                                index.removeRegisteredStudent(curStudent);
                                                index.addRegisteredStudent(swapperStudent);
                                            }
                                        }
                                    }
                                    //if (course.getCourseCode().equals(currentStudentCourseCode)){
                                        //for (Index index: course.getCourseIndex()){
                                            //if (index.getIndexID() == currentStudentIndex.getIndexID()){
                                                //index.addRegisteredStudent(swapperStudent);
                                                //index.removeRegisteredStudent(curStudent);
                                            //}
                                            //else if (index.getIndexID() == newIndexID){
                                                //index.addRegisteredStudent(curStudent);
                                                //index.removeRegisteredStudent(swapperStudent);
                                            //}
                                        //}
                                    //}
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

    public static void printIndices(ArrayList <CourseIndex> indices){
        int i = 1;
        for (CourseIndex index: indices){
            System.out.printf("\n%d) Index ID: %d\nIndex Vacancy:%d\nIndex Total Size:%d\nIndex Waitlist Size:%d\n", i, index.getIndexID(), index.getVacancies(), index.getMaxStudents(), index.getStudentWaitlist().size());
            System.out.printf("%s\n", "--------------------");
            for(Lesson lesson: index.getLessonList()){
                System.out.printf("%s %s %s-%s %s \n", lesson.getLessonTypeStr(), lesson.getLessonDayStr(), lesson.getStartTime(), lesson.getEndTime(), lesson.getVenue());
            }
            i++;
        }
    }

    public static void printRegisteredCourses(Student curStudent){
        System.out.println("These are your registered courses (with waitlisted courses):");
        for (int i = 0; i < curStudent.getRegisteredIndices().size(); i++){
            System.out.printf("%s\n", "--------------------");
            
            System.out.printf("%d|%d|%s\n", i+1, curStudent.getRegisteredIndices().get(i).getIndexID(), curStudent.getRegisteredIndices().get(i).getCourseName());
        }
    }

    public static boolean compareClash(Student curStudent, CourseIndex addedIndex){
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
                            if (addedLessonStartPeriod < registeredLessonStartPeriod && addedLessonEndPeriod < registeredLessonEndPeriod && addedLessonEndPeriod > registeredLessonStartPeriod){
                                System.out.println("There is a clash");
                                clash = true;
                                return clash;
                            }
                            else if (addedLessonStartPeriod > registeredLessonStartPeriod && addedLessonStartPeriod < registeredLessonEndPeriod && addedLessonEndPeriod > registeredLessonEndPeriod){
                                System.out.println("There is a clash");
                                clash = true;
                                return clash;
                            }
                            else if (addedLessonStartPeriod < registeredLessonStartPeriod && addedLessonEndPeriod > registeredLessonEndPeriod){
                                System.out.println("There is a clash");
                                clash = true;
                                return clash;
                            }
                            else if (addedLessonStartPeriod > registeredLessonStartPeriod && addedLessonStartPeriod < registeredLessonEndPeriod){
                                System.out.println("There is a clash");
                                clash = true;
                                return clash;
                            }
                            else if (addedLessonStartPeriod == registeredLessonStartPeriod && addedLessonEndPeriod == registeredLessonEndPeriod){
                                System.out.println("There is a clash");
                                clash = true;
                                return clash;
                            }
                        }
                    }
                }
            }
        return clash;
    }
}
