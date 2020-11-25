import java.util.*;

/**
 * The class contains the details about all the courses in the STARS system.
 */
public class Course implements java.io.Serializable{
    
    private String courseName;
    private String courseSchool;
    private String courseCode;
    private int courseAU;
    private ArrayList<CourseIndex> courseIndex = new ArrayList<>(0);
    private static final long serialVersionUID = 2L;

    /**
     * This constructor defines a course
     * @param name the full name of the course
     * @param school the school which offers the course
     * @param code the course code
     * @param AU the number of Academic Units of the course
     * @param index the different indices available under the course
     */
    public Course (String name, String school, String code, int AU, ArrayList<CourseIndex> index){
        courseName = name;
        courseSchool = school;
        courseCode = code;
        courseAU = AU;
        courseIndex = index;
    }

    /**
     * @return an array list of course indices
     */
    public ArrayList<CourseIndex> getCourseIndex(){
        return courseIndex;
    }

    /**
     * @param index the different indices available under the course
     */
    public void setCourseIndex(ArrayList<CourseIndex> index){
        courseIndex = index;
    }

    /**
     * @return the full name of the course
     */
    public String getCourseName(){
        return this.courseName;
    }

    /**
     * @param name the full name of the course
     */
    public void setCourseName(String name){
        courseName = name;
    }

    /**
     * @return the school which offers the course
     */
    public String getCourseSchool(){
        return courseSchool;
    }

    /**
     * @param school the school which offers the course
     */
    public void setCourseSchool(String school){
        courseSchool = school;
    }

    /**
     * @return the course code
     */
    public String getCourseCode(){
        return courseCode;
    }

    /**
     * @param code the course code
     */
    public void setCourseCode(String code){
        courseCode = code;
    }

    /**
     * @return the number of Academic Units of the course
     */
    public int getCourseAU(){
        return courseAU;
    }

    /**
     * @param AU the number of Academic Units of the course
     */
    public void setCourseAU(int AU){
        courseAU = AU;
    }

    public boolean compareCourseCode(Course course){
        return courseCode.equals(course.courseCode);
    }
}
