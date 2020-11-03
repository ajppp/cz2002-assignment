import java.util.*;

public class Course{
    private String courseschool;
    private String courseCode;
    private int courseAU;
    private ArrayList<Index> courseIndex;

    public Course (String school, String code, int AU, ArrayList<Index> index){
        courseschool = school;
        courseCode = code;
        courseAU = AU;
        courseIndex = index;
    }

    public Course (String school, String code, int AU){
        courseschool = school;
        courseCode = code;
        courseAU = AU;
    }

    public String getSchool(){
        return courseschool;
    }

    public void setSchool(String school){
        courseschool = school;
    }

    public String getCode(){
        return courseCode;
    }

    public void setCode(String code){
        courseCode = code;
    }

    public int getAU(){
        return courseAU;
    }

    public void setAU(int AU){
        courseAU = AU;
    }

    public ArrayList<Index> getIndex(){
        return courseIndex;
    }

    public void setIndex(ArrayList<Index> index){
        courseIndex = index;
    }
}
