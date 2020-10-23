//package Lesson;
import java.util.*;

public class Index {
    private int vacancies = 10;
    private int maxStudents = 20;
    private ArrayList<Lesson> lessonList;
    private ArrayList<String> waitList;

    public Index (int vacancies, int maxStudents, ArrayList<Lesson> lessonList, ArrayList<String> waitList){
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
        this.lessonList = lessonList;
        this.waitList = waitList;
    }

    public Index (int vacancies, int maxStudents){
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
    }

    public Index(){}

    public int getVacancies(){
        return vacancies;
    }

    public void setVacancies(int vacancies){
        this.vacancies = vacancies;
    }

    public int getMaxStudents(){
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents){
        this.maxStudents = maxStudents;
    }

    public ArrayList<Lesson> getLessonList(){
        return lessonList;
    }

    public void setLessonList(ArrayList<Lesson> lessonList){
		this.lessonList = lessonList;
    }
    
    public ArrayList<String> getWaitList(){
        return waitList;
    }

    public void setWaitList(ArrayList<String> waitList){
		this.waitList = waitList;
	}

}
