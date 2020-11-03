import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileEditor{
    private static final String studentFileName = "studentFile.csv";
    private static final String studentHEADER = "studentID,studentName,studentSchool,studentGender,studentNationality";
    private static final int studentIdIndex = 0;
    private static final int studentNameIndex = 1;
    private static final int studentSchoolIndex = 2;
    private static final int studentGenderIndex = 3;
    private static final int studentNationalityIndex = 4;

    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    
    public static void writeStudents(Student student){
        File file;
        FileWriter Writer = null;
        try {
            file = new File(studentFileName);
            Writer = new FileWriter(studentFileName, true);
            if (file.length() == 0) {
                Writer.append(studentHEADER);
                Writer.append(NEW_LINE);
            }
            Writer.append(student.getStudentID());
            Writer.append(COMMA);
            Writer.append(student.getStudentName());
            Writer.append(COMMA);
            Writer.append(student.getStudentSchool());
            Writer.append(COMMA);
            Writer.append(student.getStudentGender());
            Writer.append(COMMA);
            Writer.append(student.getStudentNationality());
            Writer.append(COMMA);
            Writer.append(NEW_LINE);
        } catch (Exception e) {
            System.out.println("Error in adding a student");
            e.printStackTrace();
        } finally {
            try {
                Writer.flush();
                Writer.close();
            } catch (IOException e) {
                System.out.println("Error in flushing or closing");
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Student> loadStudents(){
        BufferedReader fileReader = null;
        ArrayList<Student> students = new ArrayList<Student>(0);
        try { 
            String line;
            fileReader = new BufferedReader(new FileReader(studentFileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] attributes = line.split(COMMA);
                if (attributes.length > 0) {
                    Student student = new Student(attributes[studentIdIndex], attributes[studentNameIndex], attributes[studentSchoolIndex], attributes[studentGenderIndex], attributes[studentNationalityIndex]);
                    students.add(student);
                }
            }
        } catch (Exception e) {
                System.out.println("Error loading student file");
                e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error when closing file reader");
                e.printStackTrace();
            }
        }
        return students;
    }
}
