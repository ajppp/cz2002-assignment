import java.util.*;

public class Student implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String studentID;
    private String studentName;
    private String studentSchool;
    private String studentGender;
    private String studentNationality;
    private String studentEmail;
    private int studentRegisteredAU = 0;
    private ArrayList<Index> registeredIndex = new ArrayList<>(0);
    private static final int MAX_AU = 21;

    /*
     *used to initialise the student method with all attributes
     *only used when reading in student's information from file
     */
    public Student(String ID, String Name, String School, String Gender, String Nationality, String Email, int AU, ArrayList<Index> index){
        studentID = ID;
        studentName = Name;
        studentSchool = School;
        studentGender = Gender;
        studentNationality = Nationality;
        studentEmail = Email;
        studentRegisteredAU = AU;
        registeredIndex = index;
    }

    //Initialises the student object with the ID, Name, School, Gender and Nationality when the admin adds the student manually
    public Student(String Name, String School, String Gender, String Nationality, String Email){
        studentID = createStudentID();
        studentName = Name;
        studentSchool = School;
        studentGender = Gender;
        studentNationality = Nationality;
        studentEmail = Email;
    }
    
    public Student(){}

    public String getStudentID(){
        return studentID;
    }

  /*   public void setStudentID(String ID){
        this.studentID = ID;
        
    } */

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

    public String getStudentEmail(){
        return studentEmail;
    }

    public void setStudentEmail(String email){
        this.studentEmail = email;
    }

    public void setStudentNationality(String nationality){
        this.studentNationality = nationality;
    }
    // check is done in main on whether it can be added
    // this method is just to add to student
    public void registerIndex(Index index){
        if ((studentRegisteredAU += index.getCourseAU()) <= MAX_AU){
            boolean sameCourse = false;
            for (int i=0; i<=registeredIndex.size(); i++){
                if (index.getCourseCode()== registeredIndex.get(i).getCourseCode()){
                    sameCourse = true;
                    break;
                }
            }
            if (sameCourse){
                System.out.println("Course already registered! Cannot add course");
            }
            else {
                registeredIndex.add(index);
                System.out.println("Index added successfully!");
            }
            //add au to student registered au
            studentRegisteredAU += index.getCourseAU(); 
        }
    }

    public void dropIndex(int indexID, int au){
        int i = 0, indexLocation = 0;
        for(Index index: registeredIndex){
            if (index.getIndexID() == indexID){
                indexLocation = i;
                break;
            }
            i++;
        }
        registeredIndex.remove(indexLocation);
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
