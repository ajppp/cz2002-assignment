import java.util.*;

public class Course implements java.io.Serializable{
    
    private String courseName;
    private String courseSchool;
    private String courseCode;
    private int courseAU;
    private ArrayList<Index> courseIndex = new ArrayList<>(0);
    private static final long serialVersionUID = 2L;

    public Course (String name, String school, String code, int AU, ArrayList<Index> index){
        courseName = name;
        courseSchool = school;
        courseCode = code;
        courseAU = AU;
        courseIndex = index;
    }

    public Course (String name, String school, String code, int AU){
        courseName = name;
        courseSchool = school;
        courseCode = code;
        courseAU = AU;
    }

    public ArrayList<Index> getIndex(){
        return courseIndex;
    }

    public void setIndex(ArrayList<Index> index){
        courseIndex = index;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseName(String name){
        courseName = name;
    }

    public String getCourseSchool(){
        return courseSchool;
    }

    public void setCourseSchool(String school){
        courseSchool = school;
    }

    public String getCourseCode(){
        return courseCode;
    }

    public void setCourseCode(String code){
        courseCode = code;
    }

    public int getCourseAU(){
        return courseAU;
    }

    public void setCourseAU(int AU){
        courseAU = AU;
    }

    public boolean compareCourseCode(Course course){
        return courseCode.equals(course.courseCode);
    }
}
