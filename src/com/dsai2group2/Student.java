import java.util.*;

/**
 * This class contains all the information about a particular student 
 * It includes the studentID, name, school, gender, nationality, email, number of academic units, the registered indices
 */
public class Student implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String studentID;
    private String studentName;
    private String studentSchool;
    private String studentGender;
    private String studentNationality;
    private String studentEmail;
    private int studentRegisteredAU = 0;
    private ArrayList<Index> registeredIndex = new ArrayList<>();
    private static final int MAX_AU = 21;

    /*
     *used to initialise the student method with all attributes
     *only used when reading in student's information from file
     */
    /**
     * This constructor defines a student
     * @param ID the matriculation number of the student
     * @param Name the student's name
     * @param School the school which the student is enrolled in
     * @param Gender the gender of the student
     * @param Nationality the nationality of the student
     * @param Email the school email address of the student
     * @param AU the number of academic units the student has registered
     * @param index the indices which the student has registered for
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

    /**
     * @return the matriculation number of the student
     */
    public String getStudentID(){
        return studentID;
    }

    /**
     * @return the student's name
     */
    public String getStudentName(){
        return studentName;
    }

    /**
     * @param name the student's name
     */
    public void setStudentName(String name){
        this.studentName = name;
    }

    /**
     * @return the school which the student is enrolled in
     */
    public String getStudentSchool(){
        return studentSchool;
    }

    /**
     * @param school the school which the student is enrolled in
     */
    public void setStudentSchool(String school){
        this.studentSchool = school;
    }

    /**
     * @return the gender of the student
     */
    public String getStudentGender(){
        return studentGender;
    }

    /**
     * @param gender the gender of the student
     */
    public void setStudentGender(String gender){
        this.studentGender = gender;
    }

    /**
     * @return the nationality of the student
     */
    public String getStudentNationality(){
        return studentNationality;
    }

    /**
     * @return the school email address of the student
     */
    public String getStudentEmail(){
        return studentEmail;
    }

    /**
     * @param email the school email address of the student
     */
    public void setStudentEmail(String email){
        this.studentEmail = email;
    }

    /**
     * @return the number of academic units the student has registered
     */
    public int getStudentRegisteredAU(){
        return studentRegisteredAU;
    }

    /**
     * @param nationality the nationality of the student
     */
    public void setStudentNationality(String nationality){
        this.studentNationality = nationality;
    }
    // check is done in main on whether it can be added
    // this method is just to add to student
    /**
     * Allows the student to register a new index
     * @param index the index that the student is trying to register for
     */
    public boolean registerIndex(Index index){
        int newAU = studentRegisteredAU + index.getCourseAU();
        if (newAU > MAX_AU){
            System.out.println("You have exceeded the total AUs. Please drop a course before adding");
            return false;
        } else {
                registeredIndex.add(index);
                System.out.println("Index added successfully!");
                studentRegisteredAU += index.getCourseAU(); 
                return true;
                }
    }

    /**
     * Allows the student to drop an index
     * @param indexID the number that represents the index which the student wishes to drop
     * @param au the number of academic units attached to the index
     */
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

    /**
     * @return the indices which the student has registered for
     */
    public ArrayList<Index> getRegisteredIndices(){
        return registeredIndex;
    }


    // Implement a toString method to return student ID
    // student name 

    /*
     *Method that generates a random student ID for any new Student
     */
    /**
     * @return the matriculation number as the studentID
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

    /**
     * Allows the student to swap index
     * @param index1 the index that the student wants to swap to
     * @param index2 the index that the student currently has and is dropping
     */
    public void swapIndex(Index index1, Index index2){
        registeredIndex.add(index1);
        dropIndex(index2.getIndexID(), index2.getCourseAU());
        studentRegisteredAU += index1.getCourseAU();
        System.out.println("done swapping");
    }
}
