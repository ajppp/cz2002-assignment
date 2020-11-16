public class AbstractCourse {
    
    protected String courseName;
    protected String courseSchool;
    protected String courseCode;
    protected int courseAU;

    public String getCourseName(){
        return courseName;
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
        return courseCode.equalsIgnoreCase(course.courseCode);
    }
}
