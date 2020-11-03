import java.util.*;
public class Test{
    public static void main(String[] args){
        ArrayList <Student> students = new ArrayList<>();
        ArrayList <Index> indices = new ArrayList<>();
        ArrayList <Course> courses = new ArrayList<>();
        Student jeth = new Student("H", "H", "H", "H");
        Index dsai = new Index(20, 40);
        Course oodp = new Course("SCSE", "CZ2002", 3);

        students.add(jeth);
        indices.add(dsai);
        courses.add(oodp);
        SerialEditor.writeStudents(students);
        SerialEditor.writeIndices(indices);
        SerialEditor.writeCourses(courses);
        students.remove(jeth);
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
