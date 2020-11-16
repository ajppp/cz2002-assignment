import java.util.*;

public class Student implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String studentID;
    private String studentName;
    private String studentSchool;
    private String studentGender;
    private String studentNationality;
    private int studentRegisteredAU = 0;
    private ArrayList<Index> registeredIndex;
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

    public void setStudentID(String ID){
        this.studentID = ID;
        
    }

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String name){
        this.studentName = name;
    }

    public String getStudentSchool(){
        return studentSchool;
    }

    public void setStudentSchool(String school){
        this.studentSchool = school;
    }

    public String getStudentGender(){
        return studentGender;
    }

    public void setStudentGender(String gender){
        this.studentGender = gender;
    }

    public String getStudentNationality(){
        return studentNationality;
    }
    // check is done in main on whether it can be added
    // this method is just to add to student
    public void registerIndex(Index index){
        if ((studentRegisteredAU += index.getAU()) <= MAX_AU){
            registeredIndex.add(index);
            //add au to student registered au
            studentRegisteredAU += index.getAU(); 
        }
    }

    // drop index, 

    public void dropIndex(int indexNo, int au){
        registeredIndex.remove(indexNo);
        // wrong, index is outside of this method. need to get au using another method
        // pass au or index[i].getAU();
        studentRegisteredAU -= au;
    }

    public ArrayList<Index> getRegisteredIndices(){
        return registeredIndex;
    }


    // Implement a toString method to return student ID
    // student name 

    /*
     *Method that generates a random student ID for any new Student
     */
    private String createStudentID(){
        StringBuilder createdStudentID = new StringBuilder("U");
        boolean used;
         //while (true) {
            //generate random seven digit number
            int idNumber = (int) (Math.random() * (1999999 - 1000000)) + 1000000; 
            createdStudentID.append(Integer.toString(idNumber)); 
            createdStudentID.append("C");
            //check if id has been in use
            //for (Student student:Main.students){
                //if (createdStudentID.equals(student.getStudentID())){
                    //used = true;
                    //break;
                //}
            //}
            ////if id is not in use, break out of loop and assign student the id
            //if (!used)
                //break;
        //} 
        return createdStudentID.toString();
    }
}
