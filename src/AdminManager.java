import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AdminManager{
    public static int login(LoginManager loginManager){
        Scanner sc = new Scanner(System.in);
        int result;
        for(int i = 0; i < 3; i++){
            System.out.printf("i = %d\n", i);
            System.out.println("Please type your Admin ID: ");
            String inputAdminID = sc.nextLine();
            System.out.println("Please type your password: ");
            String inputAdminPassword = sc.nextLine();
            result = loginManager.adminCompare(inputAdminID, inputAdminPassword);
            if (result == 1){
                System.out.println("we are in the if block");
                return 1;
            }
            else if (result == 0){
                System.out.println("Wrong Password. Please try again");
            }
        }
        return 0;
    }

    public static void printAdminOptions(){
        System.out.println("Welcome to NTU Stars Planner!");
        System.out.println("1. Edit student access period");
        System.out.println("2. Add a student");
        System.out.println("3. Add/Update a course");
        System.out.println("4. Check available slot for an index number (vacancy in a class)");
        System.out.println("5. Print student list by index number");
        System.out.println("6. Print student list by course");
    }

    public static void editAccessPeriod(LoginPage loginTiming){
        Scanner sc = new Scanner(System.in);
        System.out.println("Current start login timing: " + loginTiming.getStartLoginTime());
        System.out.println("Current end login timing: " + loginTiming.getEndLoginTime());
        StringBuilder newStartLogin = new StringBuilder();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println("Enter new start login date (in format dd-mm-yyyy): ");
        newStartLogin.append(sc.nextLine());
        System.out.println("Enter new start login date (in format hh:mm) ");
        newStartLogin.append(sc.nextLine());
        Date startLoginTime = new Date();
        Date endLoginTime = new Date();
        try{
            startLoginTime = formatter.parse(newStartLogin.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        StringBuilder newEndLogin = new StringBuilder();
        System.out.println("Enter new end login date (in format dd-mm-yyyy): ");
        newStartLogin.append(sc.nextLine());
        System.out.println("Enter new end login date (in format hh:mm) ");
        newStartLogin.append(sc.nextLine());
        try{
            endLoginTime = formatter.parse(newEndLogin.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        loginTiming.setStartLoginTime(startLoginTime);
        loginTiming.setEndLoginTime(endLoginTime);
        System.out.println("Successfully changed login timing period!");
    }
    
    public static void addStudent(ArrayList<Student> students){
        Scanner sc = new Scanner(System.in);
        System.out.println("Current student list: ");
        for (Student student: students){
            int i = 0;
            System.out.printf("%d %s %s", i, student.getStudentID(), student.getStudentName());
            i++;
        }
        System.out.println("Input new Student name: ");
        String studentName = sc.nextLine();
        System.out.println("Input new Student school: ");
        String studentSchool = sc.nextLine();
        System.out.println("Input new Student gender (M/F): ");
        String studentGender = sc.nextLine();
        System.out.println("Input new Student nationality: ");
        String studentNationality = sc.nextLine();
        // TODO: use REGEX!!! :D to check email~~~ 
        // as always, cloud is using something/one...
        // yeah im using regex, what are you thinking about?
        System.out.println("Input new Student email: "); 
        String studentEmail = sc.nextLine();
        Student addedStudent = new Student(studentName, studentSchool, studentGender, studentNationality, studentEmail);
        students.add(addedStudent);
    }

    public static void addCourse(ArrayList<Course> courses){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter new course name: ");
        String newCourseName = sc.nextLine();
        System.out.printf("\nEnter new course school: ");
        String newCourseSchool = sc.nextLine();
        System.out.printf("\nEnter new course code: ");
        String newCourseCode = sc.nextLine();
        System.out.printf("\nEnter new course AU: ");
        int newCourseAU = sc.nextInt();
        System.out.println("How many indices does this new course have? ");
        int numCourseIndices = sc.nextInt();
        System.out.println("How many lessons in each index? ");
        int numLessons = sc.nextInt();
        ArrayList<Index> newIndexList = new ArrayList<Index>(numCourseIndices);
        ArrayList<Lesson> newLessonList = new ArrayList<Lesson>(numLessons);
        for (int i = 0; i < numCourseIndices; i++){
            for (int j = 0; j < numLessons; j++){
                System.out.printf("For index %d of %s, insert the lesson type for lesson number %d (0 for lecture, 1 for tutorial, 2 lab )\n", i + 1, newCourseName, j = 1);
                int newLessonType = sc.nextInt();
                System.out.printf("For this lesson, enter the day\n");
                int newLessonDay = sc.nextInt();
                System.out.printf("For this lesson, enter the start period\n");
                int newLessonStartPeriod = sc.nextInt();
                System.out.printf("For this lesson, enter the end period\n");
                int newLessonEndPeriod = sc.nextInt();
                System.out.printf("For this lesson, enter the venue\n");
                String newLessonVenue = sc.nextLine();
                newLessonList.set(j, new Lesson(newLessonType, newLessonDay, newLessonStartPeriod, newLessonEndPeriod, newLessonVenue));
            }
            System.out.printf("Enter the index ID: ");
            int newIndexID = sc.nextInt();
            System.out.println("How many vacancies does this new index have?");
            int newIndexVacancies = sc.nextInt();
            System.out.println("What is the maximum number of students this new index has?");
            int newIndexMaxStudents = sc.nextInt();
            newIndexList.set(i, new Index(newCourseName, newCourseSchool, newCourseCode, newCourseAU, newIndexID, newIndexVacancies, newIndexMaxStudents, newLessonList, new ArrayList<Student>(0), new ArrayList<Student>(0)));
        }
        courses.add(new Course(newCourseName, newCourseSchool, newCourseCode, newCourseAU, newIndexList));
    }

    public static void updateCourse(Course course){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Details of course %s", course.getCourseName());
        System.out.printf("(1) Course Name: %s\n (2) Course School: %s\n (3) Course Code: %s \n ", course.getCourseName(), course.getCourseSchool(), course.getCourseCode());
        System.out.printf("Choose detail of course to change: ");
        int courseAttributeToChange = sc.nextInt();
        switch(courseAttributeToChange){
            case 1:
                System.out.println("Set new course name: ");
                String case2newCourseName = sc.nextLine();
                course.setCourseName(case2newCourseName);
                System.out.printf("New course name %s has been changed successfully!", case2newCourseName);
                break;
            case 2:
                System.out.println("Change course of school: ");
                String case2newCourseSchool = sc.nextLine();
                course.setCourseSchool(case2newCourseSchool);
                System.out.printf("Course school has been changed to %s successfully!", case2newCourseSchool);
                break;
            case 3:
                System.out.println("Change course code: ");
                String case2newCourseCode = sc.nextLine();
                course.setCourseCode(case2newCourseCode);
                System.out.printf("Course code has been changed to %s successfully!", case2newCourseCode);
                break;
        }
    }

    public static void updateIndex(Index index){
        Scanner sc = new Scanner(System.in);
        System.out.printf("(1) Change the max number of students\n (2) Change the lessons");
        int changeIndexChoice = sc.nextInt();
        switch(changeIndexChoice){
            case 1:
                System.out.printf("The number of max students now is %d, what do you want to change it to?", index.getMaxStudents());
                index.setMaxStudents(sc.nextInt());
                System.out.printf("Successfully changed max students to %d", index.getMaxStudents());
                break;

            case 2:
                for(Lesson lesson: index.getLessonList()){
                    int j = 0;
                    System.out.printf("%d %s %s %s %s %s", j, lesson.getLessonTypeStr(), lesson.getLessonDayStr(), lesson.getStartTime(), lesson.getEndTime(), lesson.getVenue());
                    j++;
                }
                System.out.println("Choose which lesson to change");
                Lesson lessonToChange = index.getLessonList().get(sc.nextInt());
                updateLesson(lessonToChange);
                break;
        }
    }

    public static void updateLesson(Lesson lesson){
        Scanner sc = new Scanner(System.in);
        System.out.printf("(1) Change lesson type (2) Change lesson day (3) Change lesson start time (4) Change lesson end time (5) Change lesson venue\n");
        int lessonAttributeToChange = sc.nextInt();
        switch(lessonAttributeToChange){
            case 1:
                System.out.printf("insert the lesson type (0 for lecture, 1 for tutorial, 2 lab )\n");
                lesson.setLessonType(sc.nextInt());
                break;
            case 2:
                System.out.printf("For this lesson, enter the day\n");
                lesson.setLessonDay(sc.nextInt());
                break;
            case 3:
                System.out.printf("For this lesson, enter the start period\n");
                lesson.setStartPeriod(sc.nextInt());
                break;
            case 4:
                System.out.printf("For this lesson, enter the end period\n");
                lesson.setEndPeriod(sc.nextInt());
                break;
            case 5:
                System.out.printf("For this lesson, enter the venue\n");
                lesson.setVenue(sc.nextLine());
                break;
        }
    }
}
