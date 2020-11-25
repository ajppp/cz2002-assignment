import java.util.*;
public class Test{
   public static void main(String[] args){
        ArrayList <Student> students = new ArrayList<>();
        ArrayList <Course> courses = new ArrayList<>();
        ArrayList <Lesson> lessonList = new ArrayList<>();
        ArrayList <Student> studentWaitlist = new ArrayList<>();
        ArrayList <Student> registeredStudentList = new ArrayList<>();
        Date startTime = new Date(120, 10, 10, 14, 30);
        Date endTime = new Date(120, 10, 30, 11, 30);
        LoginPage login = new LoginPage(startTime, endTime);
        LoginManager loginManager = new LoginManager();
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
        Student k = new Student("Aurelio Jethro", "SCSE", "M", "Indonesian", "dummyemailforoodp@gmail.com");
        Student l = new Student( "Elroy Ang", "SCSE", "M", "Singaporean", "dummyemailforoodp@gmail.com");
        Student m = new Student( "Lian Ran", "SCSE", "F", "Singaporean", "dummyemailforoodp@gmail.com");
        Student n = new Student( "Claudia", "SCSE", "F", "Singaporean", "dummyemailforoodp@gmail.com");
        Student o = new Student( "Isabela Angus", "SCSE", "F", "Singaporean", "dummyemailforoodp@gmail.com");
        
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
        students.add(k);
        students.add(l);
        students.add(m);
        students.add(n);
        students.add(o);

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

        ArrayList <CourseIndex> indexList2500 = new ArrayList<>();
        indexList2500.add(new CourseIndex("Probability and Introduction to Statistics","SPMS", "MH2500", 6, 20, 20, 71050, lessonList71050, new ArrayList<Student>(), new ArrayList<Student>(20)));
        indexList2500.add(new CourseIndex("Probability and Introduction to Statistics","SPMS", "MH2500", 6, 20, 20, 71051, lessonList71051, new ArrayList<Student>(), new ArrayList<Student>(20)));
        indexList2500.add(new CourseIndex("Probability and Introduction to Statistics","SPMS", "MH2500", 6, 20, 20, 71052, lessonList71052, new ArrayList<Student>(), new ArrayList<Student>(20)));
        indexList2500.add(new CourseIndex("Probability and Introduction to Statistics","SPMS", "MH2500", 6, 20, 20, 71054, lessonList71054, new ArrayList<Student>(), new ArrayList<Student>(20)));

        courses.add(new Course("Probability and Introduction to Statistics", "SPMS", "MH2500", 6, indexList2500));

        // creating CM1031
        ArrayList <Lesson> lessonList70089 = new ArrayList<>();
        lessonList70089.add(new Lesson(1, 3, 5, 6, "online"));
        lessonList70089.add(new Lesson(1, 4, 5, 7, "online"));
        lessonList70089.add(new Lesson(2, 4, 2, 3, "SPMS-TR+5"));
        lessonList70089.add(new Lesson(3, 1, 5, 8, "CBC Lab"));

        ArrayList <CourseIndex> indexList1031 = new ArrayList<>();
        indexList1031.add(new CourseIndex("Basic Organic Chemistry with Laboratory","SPMS", "CM1031", 5, 50, 50, 70089, lessonList70089, new ArrayList<Student>(), new ArrayList<Student>(50)));

        courses.add(new Course("Basic Organic Chemistry with Laboratory", "SPMS", "CM1031", 5, indexList1031));

        // creating HC4050
        ArrayList <Lesson> lessonList17048 = new ArrayList<>();
        lessonList17048.add(new Lesson(4, 1, 2, 3, "TR+64"));

        ArrayList <CourseIndex> indexList4050 = new ArrayList<>();
        indexList4050.add(new CourseIndex("Chinese Semantics", "SOH", "HC4050", 5, 1, 50, 17048, lessonList17048, new ArrayList<Student>(), new ArrayList<Student>(40)));

        courses.add(new Course("Chinese Semantics", "SOH", "HC4050", 5, indexList4050));

        // creating BF2209
        ArrayList <Lesson> lessonList00224 = new ArrayList<>();
        lessonList00224.add(new Lesson(4, 3, 0, 4, "S4-SR2"));

        ArrayList <Lesson> lessonList00225 = new ArrayList<>();
        lessonList00225.add(new Lesson(4, 4, 0, 4, "LHS-TR+47"));

        ArrayList <CourseIndex> indexList2209 = new ArrayList<>();
        indexList2209.add(new CourseIndex("Derivative Securities", "NBS", "BF2209", 4, 50, 50, 00224, lessonList00224, new ArrayList<Student>(), new ArrayList<Student>(50)));
        indexList2209.add(new CourseIndex("Derivative Securities", "NBS", "BF2209", 4, 50, 50, 00225, lessonList00225, new ArrayList<Student>(), new ArrayList<Student>(50)));

        courses.add(new Course("Derivative Securities", "NBS", "BF2209", 4, indexList2209));

        //creating ADP26D
        ArrayList <Lesson> lessonList39686 = new ArrayList<>();
        lessonList39686.add(new Lesson(1, 2, 7, 10, "3A-B2-03"));

        ArrayList <CourseIndex> indexList26D = new ArrayList<>();
        indexList26D.add(new CourseIndex( "Theatre & Technology", "NIE", "ADP26D", 5, 5, 5, 39686, lessonList39686, new ArrayList<Student>(), new ArrayList<Student>(5)));

        courses.add(new Course("Theatre & Technology", "NIE", "ADP26D", 5, indexList26D));

        // Generate Password for each student
        for (Student student: students){
            loginManager.storeStudentPassword(student.getStudentID(), "password");
            System.out.println(student.getStudentID());
        }

        // Generate admins
        loginManager.storeAdminPassword("Claudia", "Claudia123");
        loginManager.storeAdminPassword("Jethro", "Jethro123");
        loginManager.storeAdminPassword("Elroy", "Elroy123");
        loginManager.storeAdminPassword("Lianran", "Lianran123");
        loginManager.storeAdminPassword("Isabela", "Isabela123");

        SerialEditor.writeStudents(students);
        SerialEditor.writeCourses(courses);
        SerialEditor.writeLoginTiming(login);
        SerialEditor.writeLoginDetails(loginManager);
    }
}
