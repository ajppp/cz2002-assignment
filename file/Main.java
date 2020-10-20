import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Student jeth = new Student("123", "Jeth", "NIL", "NIL", "NIL");
        Student cloud = new Student("123", "Cloud", "NIL", "NIL", "NIL");
        FileEditor.writeStudents(jeth);
        FileEditor.writeStudents(cloud);
        ArrayList<Student> students = FileEditor.loadStudents();
        System.out.println(students);
    }
}
