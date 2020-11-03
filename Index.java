//package Lesson;
import java.util.*;

public class Index {
    private int indexID;
    private int vacancies = 10;
    private int maxStudents = 20;
    private ArrayList<Lesson> lessonList = new ArrayList<Lesson>(1);
    private ArrayList<String> waitList = new ArrayList<String>(0);

    //Creates the index with vacancies, the maximum number of students, the lessons it consist of and the waitlist
    public Index (int vacancies, int maxStudents, ArrayList<Lesson> lessonList, ArrayList<String> waitList){
        indexID = createIndexID();
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
        this.lessonList = lessonList;
        this.waitList = waitList;
    }
    
    //Creates the index with vacancies and the maximum number of students
    public Index (int vacancies, int maxStudents){
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
    }

    public Index(){}

    public int getVacancies(){
        return vacancies;
    }

    public int getIndexID(){
        return indexID;
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

    private int createIndexID(){
        boolean used = false;
        while (true) {
            int createdIndexID = (int)(Math.random() * (9999 - 1000)) + 1000; 
            for (Index index:Main.index){
                if (createdIndexID == index.getIndexID()){
                    used = true;
                    break;
                }
            }
            //if id is not in use, break out of loop and assign index the id
            if (!used)
                break;
        } 
    }
}
