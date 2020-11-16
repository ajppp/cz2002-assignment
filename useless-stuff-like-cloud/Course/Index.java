//package Lesson;
import java.util.*;
import java.io.*;

public class Index extends AbstractCourse implements java.io.Serializable{
    private static final long serialVersionUID = 3L;
    private int indexID;
    private int vacancies = 10;
    private int maxStudents = 20;
    private ArrayList<Lesson> lessonList = new ArrayList<Lesson>(1);
    private ArrayList<Student> studentWaitlist = new ArrayList<Student>(0);
    private ArrayList<Student> registeredStudents = new ArrayList<Student>(0);

    public Index (String courseName, String courseSchool, String courseCode, int courseAU, int vacancies, int maxStudents, ArrayList<Lesson> lessonList, ArrayList<Student> studentWaitlist, ArrayList<Student> registeredStudents){
        this.courseName = courseName;
        this.courseSchool = courseSchool;
        this.courseCode = courseCode;
        this.courseAU = courseAU;
        indexID = 0;
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
        this.lessonList = lessonList;
        this.studentWaitlist = studentWaitlist;
        this.registeredStudents = registeredStudents;
    }

    //Creates the index with vacancies, the maximum number of students, the lessons it consist of and the waitlist
    public Index (int vacancies, int maxStudents, ArrayList<Lesson> lessonList, ArrayList<Student> studentWaitlist, ArrayList<Student> registeredStudents){
        indexID = 0;
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
        this.lessonList = lessonList;
        this.studentWaitlist = studentWaitlist;
        this.registeredStudents = registeredStudents;
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
    
    public ArrayList<Student> getStudentWaitlist(){
        return studentWaitlist;
    }

    public void setStudentWaitlist(ArrayList<Student> studentWaitList){
		this.studentWaitlist = studentWaitlist;
	}

    /*
     *private int createIndexID(){
     *    boolean used = false;
     *    while (true) {
     *        int createdIndexID = (int)(Math.random() * (9999 - 1000)) + 1000; 
     *        for (Index index:Main.index){
     *            if (createdIndexID == index.getIndexID()){
     *                used = true;
     *                break;
     *            }
     *        }
     *        //if id is not in use, break out of loop and assign index the id
     *        if (!used)
     *            break;
     *    } 
        }
     */
    
    //new methods by cloud
    public void addRegisteredStudent(Student student1){
        registeredStudents.add(student1);
    }

    public void removeRegisteredStudent(Student student1){
        registeredStudents.remove(student1);
    }

    public List<Student> listRegisteredStudents(){
        return registeredStudents;
    }

    public int listNoOfRegisteredStudents(){
        return registeredStudents.size();
    }

    public void addWaitlistStudent(Student student1) {
        studentWaitlist.add(student1);
    }

    public void removeWaitlistedStudent(Student student1){
        studentWaitlist.remove(student1);
    }

}

