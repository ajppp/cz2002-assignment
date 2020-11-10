import java.util.*;
public class Test{
   public static void main(String[] args){
        ArrayList <Student> students = new ArrayList<>();
        ArrayList <Index> indices = new ArrayList<>();
        ArrayList <Course> courses = new ArrayList<>();
        ArrayList <Lesson> lessonList = new ArrayList<>();
        ArrayList <Student> studentWaitlist = new ArrayList<>();
        ArrayList <Student> registeredStudentList = new ArrayList<>();
        Date startTime = new Date(2020, 11, 3, 14, 30);
        Date endTime = new Date(2020, 11, 30, 11, 30);
        LoginPage login = new LoginPage(startTime, endTime);
        Student cloud = new Student("Claudia", "SCSE", "M", "Vietnamese");
        registeredStudentList.add(cloud);
        Index dsai = new Index("SCSE", "1234", 3, 39, 40, lessonList, studentWaitlist, registeredStudentList);
        indices.add(dsai);
        Course oodp = new Course("SCSE", "CZ2002", 3, indices);
        students.add(cloud);
        courses.add(oodp);
        SerialEditor.writeStudents(students);
        SerialEditor.writeIndices(indices);
        SerialEditor.writeCourses(courses);
        SerialEditor.writeLogin(login);
        students.remove(cloud);
        indices.remove(dsai);
        courses.remove(oodp);
        students = SerialEditor.loadStudents();
        indices = SerialEditor.loadIndices();
        courses = SerialEditor.loadCourses();
        for (Student student: students){
            System.out.println(student);
        }
        for (Course course: courses){
            System.out.println(course.getAU());
        }
        for (Index index: indices){
            System.out.println(index.getVacancies());
        }
    }
}
