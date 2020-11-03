import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        ArrayList<Lesson> DSAI1Lessons = new ArrayList<Lesson>(0);
        Lesson lecture = new Lesson(0, 1, "09:00", "10:00", "LT2");
        Lesson tutorial = new Lesson(1, 3, "19:00", "21:00", "TR2");
        Lesson lab = new Lesson(2, 4, "09:00", "10:00", "HWLAB2");
        Index DSAI1 = new Index();
        DSAI1Lessons.add(lecture);
        DSAI1Lessons.add(tutorial);
        DSAI1Lessons.add(lab);
        DSAI1.setLessonList(DSAI1Lessons);
        System.out.println(DSAI1.getLessonList().toString());
    }
}
