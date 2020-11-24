import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
 

 import javax.mail.Message;
 import javax.mail.MessagingException;
 import javax.mail.PasswordAuthentication;
 import javax.mail.Session;
 import javax.mail.Transport;
 import javax.mail.internet.InternetAddress;
 import javax.mail.internet.MimeMessage;

 /**
  * The class contains the details about all the indices for the courses available
  */
public class Index implements java.io.Serializable{
    private String courseName;
    private String courseSchool;
    private String courseCode;
    private int courseAU;
    private static final long serialVersionUID = 3L;
    private int indexID;
    private int vacancies;
    private int maxStudents;
    private ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
    private ArrayList<Student> studentWaitlist = new ArrayList<Student>();
    private ArrayList<Student> registeredStudents = new ArrayList<Student>();

    /**
     * This constructor defines an index
     * @param courseName the full name of the course
     * @param courseSchool the school which offers the course
     * @param courseCode the course code
     * @param courseAU the number of Academic Units of the course
     * @param vacancies the number of vacancies currently available for the particular index
     * @param maxStudents the maximum number of students for the particular index
     * @param indexID the number that represents the index
     * @param lessonList the array list that contains the details of the lessons for the particular index
     * @param studentWaitlist a list of students who are in the waitlist for the particular index
     * @param registeredStudents a list of students who are registered for the particular index
     */
    public Index (String courseName, String courseSchool, String courseCode, int courseAU, int vacancies, int maxStudents, int indexID, ArrayList<Lesson> lessonList, ArrayList<Student> studentWaitlist, ArrayList<Student> registeredStudents){
        this.courseName = courseName; this.courseSchool = courseSchool;
        this.courseCode = courseCode;
        this.courseAU = courseAU;
        this.indexID = indexID;
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
        this.lessonList = lessonList;
        this.studentWaitlist = studentWaitlist;
        this.registeredStudents = registeredStudents;
    }

    public Index (String courseName, String courseSchool, String courseCode, int courseAU, int vacancies, int maxStudents, int indexID, ArrayList<Lesson> lessonList){
        this.courseName = courseName;
        this.courseSchool = courseSchool;
        this.courseCode = courseCode;
        this.courseAU = courseAU;
        this.indexID = indexID;
        this.vacancies = vacancies;
        this.maxStudents = maxStudents;
        this.lessonList = lessonList;
    }

    public Index(){}

    /**
     * @return the full name of the course
     */
    public String getCourseName(){
        return courseName;
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

    /**
     * @return the number of vacancies currently available for the particular index
     */
    public int getVacancies(){
        return vacancies;
    }

    /**
     * @return the number that represents the index
     */
    public int getIndexID(){
        return indexID;
    }

    /**
     * @param vacancies the number of vacancies currently available for the particular index
     */
    public void setVacancies(int vacancies){
        this.vacancies = vacancies;
    }

    /**
     * @return the maximum number of students for the particular index
     */
    public int getMaxStudents(){
        return maxStudents;
    }

    /**
     * @param maxStudents the maximum number of students for the particular index
     */
    public void setMaxStudents(int maxStudents){
        this.maxStudents = maxStudents;
    }

    /**
     * @return the array list that contains the details of the lessons for the particular index
     */
    public ArrayList<Lesson> getLessonList(){
        return lessonList;
    }

    /**
     * @param lessonList the array list that contains the details of the lessons for the particular index
     */
    public void setLessonList(ArrayList<Lesson> lessonList){
		this.lessonList = lessonList;
    }

    /**
     * @return a list of students who are in the waitlist for the particular index
     */
    public ArrayList<Student> getStudentWaitlist(){
        return studentWaitlist;
    }

    /**
     * @param studentWaitList a list of students who are in the waitlist for the particular index
     */
    public void setStudentWaitlist(ArrayList<Student> studentWaitList){
		this.studentWaitlist = studentWaitlist;
	}

    //new methods by cloud
    /**
     * @param student1 the target student to be added in the list of students registered for that index
     */
    public void addRegisteredStudent(Student student1){
        registeredStudents.add(student1);
    }

    /**
     * @param student1 the target student that is to be removed from the list of students registered for that index
     */
    public void removeRegisteredStudent(Student student1){
        for(int i = 0; i < registeredStudents.size(); i++){
            if(student1.getStudentID().equals(registeredStudents.get(i).getStudentID())){
                registeredStudents.remove(i);
                break;
            }
        }
    }

    /**
     * @return a list of students who are registered for the particular index
     */
    public ArrayList<Student> listRegisteredStudents(){
        return registeredStudents;
    }

    /**
     * @return a list of students who are in the waitlist for the particular index
     */
    public ArrayList<Student> listStudentWaitlist(){
        return studentWaitlist;
    }

    /**
     * @return the number of registered students for the particular index
     */
    public int listNoOfRegisteredStudents(){
        return registeredStudents.size();
    }

    /**
     * @param student1 the target student to be added in the waitlist for the index
     */
    public void addWaitlistStudent(Student student1) {
        studentWaitlist.add(student1);
    }

    /**
     * @param student1 the target student to be removed from the waitlist for the index
     */
    public void removeWaitlistedStudent(Student student1){
        for(int i = 0; i < studentWaitlist.size(); i++){
            if(student1.getStudentID().equals(studentWaitlist.get(i).getStudentID())){
                studentWaitlist.remove(i);
                break;
            }
        }
    }

    /**
     * changing the vacancy of the index whenever a student is added
     * @param student1 the newly added student for the index
     */
    public void studentAddedToIndex(Student student1){
        if (vacancies > 0){
            addRegisteredStudent(student1);
            vacancies--;
        }
        else {
            addWaitlistStudent(student1);
        }
    }

    /**
     * changing the vacancy of the index whenever a student is removed
     * @param student1 the newly removed studentfor the index
     */
    public void removeStudentFromIndex(Student student1){
        if(registeredStudents.size() > 0){
            for(Student student: registeredStudents){
                System.out.println(student.getStudentID());
                if (student1.getStudentID().equals(student.getStudentID())){
                    removeRegisteredStudent(student1);
                    vacancies++;
                    break;
                }
            }
        }

        if(studentWaitlist.size() > 0){
            for(Student student: studentWaitlist){
                if (student1.getStudentID().equals(student.getStudentID())){
                    removeWaitlistedStudent(student1);
                    break;
                }
            }
        }

        if (studentWaitlist.size() > 0){
            Student firstStudentOnWaitlist = studentWaitlist.get(0);
            addRegisteredStudent(firstStudentOnWaitlist);
            removeWaitlistedStudent(firstStudentOnWaitlist);
            vacancies--;
            //TODO: add current index to the student's registered index
            sendEmail(firstStudentOnWaitlist, getIndexID(), this.getCourseCode());
        }
    }
 
    /**
     * Sending a notification email to the student
     * @param student the student that has just successfully registered for a new course
     * @param addedIndex the index that the student has registered for in the course
     * @param courseCode the course code that the student has registered for
     */
    public static void sendEmail(Student student, int addedIndex, String courseCode){
        
        final String username = "dummyemailforoodp"; // to be added
        final String password = "dummyemailOODP123"; // to be added

        String studentEmail = student.getStudentEmail();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dummyemailforoodp@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(studentEmail)); // to be added an email addr
            message.setSubject("Successfully Added Course Notification (automatic email)");
            message.setText("Dear Student,"
                + "\n\n Index" + addedIndex + "of course" + courseCode + " has been successfully added to your timetable!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    } 
}

