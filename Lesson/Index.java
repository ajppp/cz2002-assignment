package Lesson;
import java.util.*;

public class Index {
    private int vacancies;
    private int maxStudents;
    private ArrayList<Lesson> lessonList;
    private ArrayList<String> waitList;

    public Index (int vacancies, int maxStudents, ArrayList<Lesson> lessonList, ArrayList<String> waitList){
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
        this.lessonList = lessonList;
        this.waitList = waitList;
    }

    public int getVacancies(){
        return this.vacancies;
    }

    public void setVacancies(int vacancies){
        this.vacancies = vacancies;
    }

    public int getMaxStudents(){
        return this.maxStudents;
    }

    public void setMaxStudents(int maxStudents){
        this.maxStudents = maxStudents;
    }

    public ArrayList<Lesson> getLessonList(){
        return this.lessonList;
    }

    public void setLessonList(ArrayList<Lesson> lessonList){
		this.lessonList = lessonList;
    }
    
    public ArrayList<String> getWaitList(){
        return this.waitList;
    }

    public void setWaitList(ArrayList<String> waitList){
		this.waitList = waitList;
	}



}
