public abstract class AbstractCourse {
    private String courseSchool;
    private String courseCode;
    private int courseAU;

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
