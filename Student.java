public class Student{
    private String studentID;
    private String studentName;
    private String studentSchool;
    private String studentGender;
    private String studentNationality;
    private static final int MAX_AU = 21;

    /*
     *used to initialise the student method with all attributes
     *only used when reading in student's information from file
     */
    public Student(String ID, String Name, String School, String Gender, String Nationality){
        studentID = ID;
        studentName = Name;
        studentSchool = School;
        studentGender = Gender;
        studentNationality = Nationality;
    }

    //Initialises the student object with the ID, Name, School, Gender and Nationality
    public Student(String Name, String School, String Gender, String Nationality){
        studentID = createStudentID();
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

    /*
     *Method that generates a random student ID for any new Student
     */
    private String createStudentID(){
        StringBuilder createdStudentID = new StringBuilder("U");
        boolean used;
         while (true) {
            //generate random seven digit number
            int idNumber = (int) (Math.random() * (1999999 - 1000000)) + 1000000; 
            createdStudentID.append(Integer.toString(idNumber)); 
            createdStudentID.append("C");
            //check if id has been in use
            for (Student student:Main.students){
                if (createdStudentID.equals(student.getStudentID())){
                    used = true;
                    break;
                }
            }
            //if id is not in use, break out of loop and assign student the id
            if (!used)
                break;
        } 
        return createdStudentID.toString();
    }
}
