import java.util.*;

public class Course extends AbstractCourse implements java.io.Serializable{
    
    private ArrayList<Index> courseIndex;
    private static final long serialVersionUID = 2L;

    public Course (String name, String school, String code, int AU, ArrayList<Index> index){
        courseName = name;
        courseSchool = school;
        courseCode = code;
        courseAU = AU;
        courseIndex = index;
    }

    public Course (String school, String code, int AU){
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
}
