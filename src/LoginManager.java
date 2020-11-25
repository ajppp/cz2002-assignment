import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

/**
 * This class contains the login information required from the user.
 * It includes the storing and hashing of the password.
 */
public class LoginManager implements java.io.Serializable{
    private static final long serialVersionUID = 7L;
    public HashMap<String, String> studentLogin = new HashMap<String, String>();
    public HashMap<String, String> adminLogin = new HashMap<String, String>();

    public LoginManager(){}

    /**
     * @return the hashmap studentLogin
     */
    public HashMap<String, String> getStudentLogin(){
        return studentLogin;
    }

    /**
     * @return the hashmap adminLogin
     */
    public HashMap<String, String> getAdminLogin(){
        return adminLogin;
    }

    /**
     * Using the MD5 algorithm to hash the password that the user registered and stores it.
     * @param Password The user's registered password
     * @return the hashed generated password
     */
    public static String hashPassword(String Password){
        String generatedPassword = null;
        Scanner sc = new Scanner(System.in);
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(Password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
        return generatedPassword;
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * Compares the student's login input with his account details
     * @param inputUsername the username that the user entered
     * @param inputPassword the password that the user entered
     * @return an int of 1 if the input is correct or a 0 if the input is wrong
     */
    public int studentCompare(String inputUsername, String inputPassword){
        if(getStudentLogin().get(inputUsername).equals(hashPassword(inputPassword))) {
            return 1;
        }
        else return 0;
    }

    /**
     * Compares the admin's login input with his account details
     * @param inputUsername the username that the user entered
     * @param inputPassword the password that the user entered
     * @return an int of 1 if the input is correct or a 0 if the input is wrong
     */
    public int adminCompare(String inputUsername, String inputPassword){
        if(getAdminLogin().get(inputUsername).equals(hashPassword(inputPassword))) {
            return 1;
        }
        else return 0;
    }

    /**
     * Stores the student's login details
     * @param inputStudentUsername the username that the student entered
     * @param inputStudentPassword the password that the student entered
     */
    public void storeStudentPassword(String inputStudentUsername, String inputStudentPassword){
        studentLogin.put(inputStudentUsername, hashPassword(inputStudentPassword));
    }
    
    /**
     * Stores the admin's login details
     * @param inputAdminUsername the username that the admin entered
     * @param inputAdminPassword the password that the admin entered
     */
    public void storeAdminPassword(String inputAdminUsername, String inputAdminPassword){
        adminLogin.put(inputAdminUsername, hashPassword(inputAdminPassword));
    }

    /**
     * @param studentUsername the registered username of the student
     * @return the stored hashed password for the student
     */
    public String returnStudentPassword(String studentUsername){
        return studentLogin.get(studentUsername);
    }

    /**
     * @param adminUsername the registered username of the admin
     * @return the stored hashed password for the admin
     */
    public String returnAdminPassword(String adminUsername){
        return studentLogin.get(adminUsername);
    }

    /**
     * @param inputStudentUsername the username that the student entered
     * @return a boolean of 1 if student entered correctly
     */
    public int checkUserID(String inputStudentUsername){
        if (getStudentLogin().containsKey(inputStudentUsername)){
            return 1;
        }
        return 0;
    }

}
