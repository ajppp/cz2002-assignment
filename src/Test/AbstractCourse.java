public abstract class AbstractCourse {
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

    public String getSchool(){
        return courseSchool;
    }

    public void setSchool(String school){
        courseSchool = school;
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
}
