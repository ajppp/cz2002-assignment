import java.util.*;
public class Test{
   public static void main(String[] args){
        ArrayList <Student> students = new ArrayList<>();
        // ArrayList <Index> indices = new ArrayList<>();
        ArrayList <Course> courses = new ArrayList<>();
        ArrayList <Lesson> lessonList = new ArrayList<>();
        ArrayList <Student> studentWaitlist = new ArrayList<>();
        ArrayList <Student> registeredStudentList = new ArrayList<>();
        Date startTime = new Date(120, 10, 3, 14, 30);
        Date endTime = new Date(120, 10, 30, 11, 30);
        LoginPage login = new LoginPage(startTime, endTime);
        LoginManager loginManager = new LoginManager();
        Student cloud = new Student("Claudia", "SCSE", "M", "Singaporean", "dummyemailforoodp@gmail.com");
        Student a = new Student("Sarah Lim", "SCSE", "F", "Malaysian", "dummyemailforoodp@gmail.com");
        Student b = new Student("Hazel Wang", "FASS", "F", "PRC", "dummyemailforoodp@gmail.com");
        Student c = new Student("Jackson Quek", "MAE", "M", "Singaporean", "dummyemailforoodp@gmail.com");
        Student d = new Student("Joe Chan", "EEE", "M", "Singaporean", "dummyemailforoodp@gmail.com");
        Student e = new Student("Emma Miller", "SPMS", "F", "American", "dummyemailforoodp@gmail.com");
        Student f = new Student("Aaron Lu", "NBS", "M", "Indonesian", "dummyemailforoodp@gmail.com");
        Student g = new Student("Laura Ng", "ACC", "F", "Singaporean", "dummyemailforoodp@gmail.com");
        Student h = new Student("Priyaa Singh", "NIE", "F", "Indian", "dummyemailforoodp@gmail.com");
        Student i = new Student("That Mhu Khin", "CEE", "F", "Burmese", "dummyemailforoodp@gmail.com");
        Student j = new Student("Brandon Tiong", "REP", "M", "Singaporean", "dummyemailforoodp@gmail.com");
        
        students.add(a);
        students.add(b);
        students.add(c);
        students.add(d);
        students.add(e);
        students.add(f);
        students.add(g);
        students.add(h);
        students.add(i);
        students.add(j);
        // creating MH2500
        ArrayList <Lesson> lessonList71050 = new ArrayList<>();
        lessonList71050.add(new Lesson(1, 5, 0, 2, "online"));
        lessonList71050.add(new Lesson(1, 2, 1, 2, "online"));
        lessonList71050.add(new Lesson(2, 4, 3, 4, "LHS-TR+27"));
        
        ArrayList <Lesson> lessonList71051 = new ArrayList<>();
        lessonList71051.add(new Lesson(1, 5, 0, 2, "online"));
        lessonList71051.add(new Lesson(1, 2, 1, 2, "online"));
        lessonList71051.add(new Lesson(2, 4, 3, 4, "LHS-TR+28"));

        ArrayList <Lesson> lessonList71052 = new ArrayList<>();
        lessonList71052.add(new Lesson(1, 5, 0, 2, "online"));
        lessonList71052.add(new Lesson(1, 2, 1, 2, "online"));
        lessonList71052.add(new Lesson(2, 4, 3, 4, "LHS-TR+31"));

        ArrayList <Lesson> lessonList71054 = new ArrayList<>();
        lessonList71054.add(new Lesson(1, 5, 0, 2, "online"));
        lessonList71054.add(new Lesson(1, 2, 1, 2, "online"));
        lessonList71054.add(new Lesson(2, 4, 3, 4, "LHS-TR+24"));

        ArrayList <Index> indexList2500 = new ArrayList<>();
        indexList2500.add(new Index("SPMS", "MH2500", 4, 20, 20, 71050, lessonList71050, new ArrayList<Student>(), new ArrayList<Student>(20)));
        indexList2500.add(new Index("SPMS", "MH2500", 4, 20, 20, 71051, lessonList71051, new ArrayList<Student>(), new ArrayList<Student>(20)));
        indexList2500.add(new Index("SPMS", "MH2500", 4, 20, 20, 71052, lessonList71052, new ArrayList<Student>(), new ArrayList<Student>(20)));
        indexList2500.add(new Index("SPMS", "MH2500", 4, 20, 20, 71054, lessonList71054, new ArrayList<Student>(), new ArrayList<Student>(20)));

        courses.add(new Course("Probability and Introduction to Statistics", "SPMS", "MH2500", 4, indexList2500));

        // creating CM1031
        ArrayList <Lesson> lessonList70089 = new ArrayList<>();
        lessonList70089.add(new Lesson(1, 3, 5, 6, "online"));
        lessonList70089.add(new Lesson(1, 4, 5, 7, "online"));
        lessonList70089.add(new Lesson(2, 4, 2, 3, "SPMS-TR+5"));
        lessonList70089.add(new Lesson(3, 1, 5, 8, "CBC Lab"));

        ArrayList <Index> indexList1031 = new ArrayList<>();
        indexList1031.add(new Index( "SPMS", "CM1031", 4, 0, 50, 70089, lessonList70089, new ArrayList<Student>(), new ArrayList<Student>(50)));

        courses.add(new Course("Basic Organic Chemistry with Laboratory", "SPMS", "CM1031", 4, indexList1031));

        // creating HC4050
        ArrayList <Lesson> lessonList17048 = new ArrayList<>();
        lessonList17048.add(new Lesson(4, 1, 2, 3, "TR+64"));

        ArrayList <Index> indexList4050 = new ArrayList<>();
        indexList4050.add(new Index("SOH", "HC4050", 4, 50, 50, 17048, lessonList17048, new ArrayList<Student>(), new ArrayList<Student>(40)));

        courses.add(new Course("Chinese Semantics", "SOH", "HC4050", 4, indexList4050));

        // creating BF2209
        ArrayList <Lesson> lessonList00224 = new ArrayList<>();
        lessonList00224.add(new Lesson(4, 3, 0, 4, "S4-SR2"));

        ArrayList <Lesson> lessonList00225 = new ArrayList<>();
        lessonList00225.add(new Lesson(4, 4, 0, 4, "LHS-TR+47"));

        ArrayList <Index> indexList2209 = new ArrayList<>();
        indexList2209.add(new Index("NBS", "BF2209", 4, 50, 50, 00224, lessonList00224, new ArrayList<Student>(), new ArrayList<Student>(50)));
        indexList2209.add(new Index("NBS", "BF2209", 4, 50, 50, 00225, lessonList00225, new ArrayList<Student>(), new ArrayList<Student>(50)));

        courses.add(new Course("Derivative Securities", "NBS", "BF2209", 4, indexList2209));

        //creating ADP26D
        ArrayList <Lesson> lessonList39686 = new ArrayList<>();
        lessonList39686.add(new Lesson(1, 2, 7, 10, "3A-B2-03"));

        ArrayList <Index> indexList26D = new ArrayList<>();
        indexList26D.add(new Index( "NIE", "ADP26D", 3, 5, 5, 39686, lessonList39686, new ArrayList<Student>(), new ArrayList<Student>(5)));

        courses.add(new Course("Theatre & Technology", "NIE", "ADP26D", 3, indexList26D));

        // Generate Password for each student
        for (Student student: students){
            loginManager.storeStudentPassword(student.getStudentID(), "password");
            System.out.println(loginManager.studentLogin.get(student.getStudentID()));
        }

        //Save an admin <3
        loginManager.storeAdminPassword("Cloud", "Cloud123");

        SerialEditor.writeStudents(students);
        SerialEditor.writeCourses(courses);
        SerialEditor.writeLoginTiming(login);
        SerialEditor.writeLoginDetails(loginManager);
        ArrayList<Course> testCourses = new ArrayList<>();
        testCourses = SerialEditor.loadCourses();
        for(Student student: students){
            FileEditor.writeStudents(student);
        }
        for (Student student: students){
            System.out.println(student.getStudentID());
        }
        for (Course course: testCourses){
            System.out.printf("size of course array list: %d\n", courses.size());
            System.out.printf("name of course : %s\n", course.getCourseName());
            System.out.printf("code of course : %s\n", course.getCourseCode());
        }
       // for (Index index: indices){
       //     System.out.println(index.getVacancies());
       // } 
    }
}
