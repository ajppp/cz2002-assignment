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

    public int getVacancies(){
        return vacancies;
    }

    public int getIndexID(){
        return indexID;
    }

    public void setVacancies(int vacancies){
        this.vacancies = vacancies;
    }

    public int getMaxStudents(){
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents){
        this.maxStudents = maxStudents;
    }

    public ArrayList<Lesson> getLessonList(){
        return lessonList;
    }

    public void setLessonList(ArrayList<Lesson> lessonList){
		this.lessonList = lessonList;
    }

    
    public ArrayList<Student> getStudentWaitlist(){
        return studentWaitlist;
    }

    public void setStudentWaitlist(ArrayList<Student> studentWaitList){
		this.studentWaitlist = studentWaitlist;
	}

    //new methods by cloud
    public void addRegisteredStudent(Student student1){
        registeredStudents.add(student1);
    }

    public void removeRegisteredStudent(Student student1){
        for(int i = 0; i < registeredStudents.size(); i++){
            if(student1.getStudentID().equals(registeredStudents.get(i).getStudentID())){
                registeredStudents.remove(i);
                break;
            }
        }
    }

    public ArrayList<Student> listRegisteredStudents(){
        return registeredStudents;
    }

    public ArrayList<Student> listStudentWaitlist(){
        return studentWaitlist;
    }

    public int listNoOfRegisteredStudents(){
        return registeredStudents.size();
    }

    public void addWaitlistStudent(Student student1) {
        studentWaitlist.add(student1);
    }

    public void removeWaitlistedStudent(Student student1){
        for(int i = 0; i < studentWaitlist.size(); i++){
            if(student1.getStudentID().equals(studentWaitlist.get(i).getStudentID())){
                studentWaitlist.remove(i);
                break;
            }
        }
    }
    // this function runs in the BACKEND ONLY!!!!
    /*
     *public void waitlistedStudentGetsIndex(Student studentDroppedIndex, Student studentGotIndex){
     *    removeRegisteredStudent(studentDroppedIndex);
     *    removeWaitlistedStudent(studentGotIndex);
     *    addRegisteredStudent(studentGotIndex);
     *    sendEmail(studentGotIndex, getIndexID(), this.getCourseCode());
     *}
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

