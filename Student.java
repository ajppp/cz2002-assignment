public class Student{
    private String studentID;
    private String studentName;
    private String studentSchool;
    private String studentGender;
    private String studentNationality;

    public Student(String ID, String Name, String School, String Gender, String Nationality){
        studentID = ID;
        studentName = Name;
        studentSchool = School;
        studentGender = Gender;
        studentNationality = Nationality;
    }

    public String getStudentID(){
        return studentID;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getStudentSchool(){
        return studentSchool;
    }
    public String getStudentGender(){
        return studentGender;
    }
    public String getStudentNationality(){
        return studentNationality;
    }
}
