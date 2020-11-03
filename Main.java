import java.util.ArrayList;
import java.io.*;

public class Main{
    public ArrayList<Lesson> DSAI1Lessons = new ArrayList<Lesson>(0);
    public ArrayList<Student> DSAI1Students = new ArrayList<Student>(0);
    public static void main(String[] args){
        ArrayList<Lesson> DSAI1Lessons = new ArrayList<Lesson>(0);
        Lesson lecture = new Lesson(0, 1, 9, 10, "LT2");
        Lesson tutorial = new Lesson(1, 3, 19, 21, "TR2");
        Lesson lab = new Lesson(2, 4, 9, 10, "HWLAB2");
        Index DSAI1 = new Index();
        DSAI1Lessons.add(lecture);
        DSAI1Lessons.add(tutorial);
        DSAI1Lessons.add(lab);
        DSAI1.setLessonList(DSAI1Lessons);
        Student Cloud = new Student("Cloud", "SCSE", "S", "S");
        try{
            FileOutputStream fileOut =
            new FileOutputStream("trying.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(DSAI1);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in trying.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
