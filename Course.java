import java.util.*;

public class Course extends AbstractCourse{
    
    private ArrayList<Index> courseIndex;


    public Course (String school, String code, int AU, ArrayList<Index> index){
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
