import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AdminManager{
	/**
	 * The admin will only be allowed to log in if he enters the correct username and password.
	 * The maximum number of wrong entries is 3 times.
	 * @param loginManager stores the login details on the admin and compares if the login details are correct
	 * @return a boolean whether the admin has entered the correct username and password or not
	 */
    public static int login(LoginManager loginManager){
        Console console = System.console();
        Scanner sc = new Scanner(System.in);
        int result;
        for(int i = 0; i < 3; i++){
            console.printf("Please type your Admin ID: ");
            String inputAdminID = console.readLine();
            console.printf(inputAdminID + "\n");
            console.printf("Please type your password: ");
            char[] passwordChars = console.readPassword();
            String inputAdminPassword = new String(passwordChars);
            result = loginManager.adminCompare(inputAdminID, inputAdminPassword);
            if (result == 1){
                return 1;
            }
            else if (result == 0){
                System.out.println("Wrong Password. Please try again");
            }
        }
        return 0;
    }

    /**
     * Prints out the 6 options that the admin can choose to do after logging in.
     */
    public static void printAdminOptions(){
        System.out.println("Welcome to NTU Stars Planner!");
        System.out.println("1. Edit student access period");
        System.out.println("2. Add a student");
        System.out.println("3. Add/Update a course");
        System.out.println("4. Check available slot for an index number (vacancy in a class)");
        System.out.println("5. Print student list by index number");
        System.out.println("6. Print student list by course");
        System.out.println("7. Add student to course");
        System.out.println("8. Save your progress and exit");
    }

    /**
     * Allows the admin to change the allowed login date and time for students.
     * @param loginTiming the time period during which the student is allowed to log in
     * @return the allowed log in time period for the students
     */
    public static LoginPage editAccessPeriod(LoginPage loginTiming){
        Scanner sc = new Scanner(System.in);
        System.out.println("Current start login timing: " + loginTiming.getStartLoginTime());
        System.out.println("Current end login timing: " + loginTiming.getEndLoginTime());
        StringBuilder newStartLogin = new StringBuilder();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        System.out.println("Enter new start login date (in format dd-mm-yyyy): ");
        newStartLogin.append(sc.nextLine());
        System.out.println("Enter new start login time (in format hh:mm) ");
        newStartLogin.append(" ");
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
        newEndLogin.append(sc.nextLine());
        System.out.println("Enter new end login time (in format hh:mm) ");
        newEndLogin.append(" ");
        newEndLogin.append(sc.nextLine());
        try{
            endLoginTime = formatter.parse(newEndLogin.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        loginTiming.setStartLoginTime(startLoginTime);
        loginTiming.setEndLoginTime(endLoginTime);
        System.out.println("Successfully changed login timing period!");
        return loginTiming;
    }
    
    /**
     * Allows the admin to register a new student and his relevant information into the STARS system.
     * The information includes the student's name, school, gender, nationality and email.
     * @param students a list of all the students registered under the STARS system
     * @return a newly registered student object
     */
    public static Student addStudent(ArrayList<Student> students){
        Scanner sc = new Scanner(System.in);
        System.out.println("Current student list: ");
        int i = 1;
        for (Student student: students){
            System.out.printf("%d %s %s %s %s\n", i, student.getStudentID(), student.getStudentName(), student.getStudentNationality(), student.getStudentGender());
            i++;
        }
        String studentName = "0";
        while (studentName.equals("0")){
            System.out.println("Input new Student name: ");
            studentName = sc.nextLine();
            for (Student student: students){
                if (studentName.equals(student.getStudentName())){
                    System.out.println("Student already exists! Please input a new student");
                    studentName = "0";
                    break;
                }
            }
        }
        System.out.println("Input new Student school: ");
        String studentSchool = sc.nextLine();
        String studentGender = "F";
        boolean correctInput = false;
        do{
            System.out.println("Input new Student gender (M/F): ");
            studentGender = sc.nextLine();
            if (studentGender.equals("M") || studentGender.equals("F")){
                correctInput = true;
            }
            else{
                System.out.println("Not valid entry! Insert either M or F");
            }
        } while (!correctInput);
        System.out.println("Input new Student nationality: ");
        String studentNationality = sc.nextLine();
        System.out.println("Input new Student email: "); 
        String studentEmail = sc.nextLine();
        Student addedStudent = new Student(studentName, studentSchool, studentGender, studentNationality, studentEmail);
        students.add(addedStudent);
        System.out.println("Updated student list: ");
        i = 1;
        for (Student student: students){
            System.out.printf("%d %s %s\n", i, student.getStudentID(), student.getStudentName());
            i++;
        }
        return addedStudent;
    }

    /**
     * Allows the admin to add a new course into the STARS system for students to register.
     * The information about the course includes the course name, the course school, course code, number of AU, number of indices and the lessons for each index
     * @param courses a list of all the courses under the STARS registration system
     */
    public static void addCourse(ArrayList<Course> courses){
        Scanner sc = new Scanner(System.in);
        String newCourseCode = "0";

        int i = 0;
        while (i == 0){
        System.out.printf("\nEnter new course code: ");
        newCourseCode = sc.nextLine();
        for (Course course: courses){
            if (newCourseCode.equals(course.getCourseCode())){
                System.out.println("Course already exists!");
                break;
            }
            else{
                i = 1;
            }
        }
        }
        System.out.printf("Enter new course name: ");
        String newCourseName = sc.nextLine();
        for (Course course: courses){
            if (newCourseName.equals(course.getCourseName())){
                System.out.println("Course already exists!");
                break;
            }
        }
        System.out.printf("\nEnter new course school: ");
        String newCourseSchool = sc.nextLine();
        System.out.printf("\nEnter new course AU: ");
        int newCourseAU = sc.nextInt();
        System.out.println("How many indices does this new course have? ");
        int numCourseIndices = sc.nextInt();    
        System.out.println("How many lessons in each index? ");
        int numLessons = sc.nextInt();
        ArrayList<Index> newIndexList = new ArrayList<Index>(numCourseIndices);
        ArrayList<Lesson> newLessonList = new ArrayList<Lesson>(numLessons);
        for (i = 0; i < numCourseIndices; i++){
            newLessonList.clear();
            for (int j = 0; j < numLessons; j++){
                System.out.printf("For index %d of %s, insert the lesson type for lesson number %d (1 for lecture, 2 for tutorial, 3 for lab, 4 for seminar)\n", i + 1, newCourseName, j + 1);
                int newLessonType = -1;
                while (newLessonType == -1){
                    int temp = sc.nextInt();
                    if (temp > 0 && temp < 5){
                        newLessonType = temp;
                        break;
                    }
                    System.out.println("Wrong input!");
                }
                System.out.printf("For this lesson, enter the day (Monday is 1, Friday is 5)\n");
                int newLessonDay = sc.nextInt();
                System.out.printf("For this lesson, enter the start period (0830 is 0, 2030 is 12)\n");
                int newLessonStartPeriod = sc.nextInt();
                System.out.printf("For this lesson, enter the end period (0830 is 0, 2030 is 12)\n");
                int newLessonEndPeriod = sc.nextInt();
                System.out.printf("For this lesson, enter the venue\n");
                sc.next();
                String newLessonVenue = sc.nextLine();
                newLessonList.add(new Lesson(newLessonType, newLessonDay, newLessonStartPeriod, newLessonEndPeriod, newLessonVenue));
            }
            System.out.printf("Enter the index ID: ");
            int newIndexID = sc.nextInt();
            System.out.println("What is the maximum number of students this new index has?");
            int newIndexMaxStudents = sc.nextInt();
            newIndexList.add(new Index(newCourseName, newCourseSchool, newCourseCode, newCourseAU, newIndexMaxStudents, newIndexMaxStudents, newIndexID, newLessonList));   
        }
        courses.add(new Course(newCourseName, newCourseSchool, newCourseCode, newCourseAU, newIndexList));
        System.out.println("Updated course list: ");
        i = 1;
        for (Course course: courses){
            System.out.printf("%d %s %s\n", i, course.getCourseCode(), course.getCourseName());
            i++;
        }
    }

    /**
     * Allows the admin to update the details of a particular course such as the name, school, and course code
     * @param course the object course that admin wants to update
     */
    public static void updateCourse(Course course){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Details of course %s", course.getCourseName());
        System.out.printf("(1) Course Name: %s\n (2) Course School: %s\n (3) Course Code: %s\n, (4) Add New Index ", course.getCourseName(), course.getCourseSchool(), course.getCourseCode());
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
            case 4:   
                System.out.printf("Enter the index ID: ");
                int newIndexID = sc.nextInt();
                System.out.println("What is the maximum number of students this new index has?");
                int newIndexMaxStudents = sc.nextInt();
                System.out.println("How many lessons does this index have?");
                int numLessons = sc.nextInt();
                ArrayList<Lesson> newIndexLessonArrayList = new ArrayList<Lesson>();
                for (int i = 0; i < numLessons; i++){
                    System.out.printf("insert the lesson type for lesson number %d (1 for lecture, 2 for tutorial, 3 for lab, 4 for seminar)\n", i + 1);
                    int newLessonType = sc.nextInt();
                    System.out.printf("For this lesson, enter the day\n");
                    int newLessonDay = sc.nextInt();
                    System.out.printf("For this lesson, enter the start period\n");
                    int newLessonStartPeriod = sc.nextInt();
                    System.out.printf("For this lesson, enter the end period\n");
                    int newLessonEndPeriod = sc.nextInt();
                    System.out.printf("For this lesson, enter the venue\n");
                    String newLessonVenue = sc.nextLine();
                    newIndexLessonArrayList.add(new Lesson(newLessonType, newLessonDay, newLessonStartPeriod, newLessonEndPeriod, newLessonVenue));
                }
                course.getCourseIndex().add(new Index(course.getCourseName(), course.getCourseSchool(), course.getCourseCode(), course.getCourseAU(), newIndexMaxStudents, newIndexMaxStudents, newIndexID, newIndexLessonArrayList));
                System.out.println("successfully added index to course");
                
            }
        }

    /**
     * Allows the admin to update an index of a particular course such as the number of students and the lessons.
     * @param index the object index of a course that the admin wants to update
     */
    public static void updateIndex(Index index){
        Scanner sc = new Scanner(System.in);
        System.out.printf("(1) Change the max number of students\n (2) Change the lessons");
        int changeIndexChoice = sc.nextInt();
        switch(changeIndexChoice){
            case 1:
                System.out.printf("The number of max students now is %d, what do you want to change it to?", index.getMaxStudents());
                int newMaxStudents = sc.nextInt();
                int change = newMaxStudents - index.getMaxStudents();
                index.setMaxStudents(newMaxStudents);
                System.out.printf("Successfully changed max students to %d", index.getMaxStudents());
                index.setVacancies(index.getVacancies()+change);
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

    /**
     * Allows the admin to update the details of the lesson for an index, such as lesson type, which day, start and end time, venue.
     * @param lesson the object lesson that the admin want to update
     */
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
