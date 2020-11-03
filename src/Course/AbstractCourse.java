public abstract class AbstractCourse {
    protected String courseSchool;
    protected String courseCode;
    protected int courseAU;

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
