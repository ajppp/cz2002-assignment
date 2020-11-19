import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class LoginManager implements java.io.Serializable{
    private static final long serialVersionUID = 7L;
    public HashMap<String, String> studentLogin = new HashMap<String, String>();
    public HashMap<String, String> adminLogin = new HashMap<String, String>();

    public LoginManager(){}

    public HashMap<String, String> getStudentLogin(){
        return studentLogin;
    }

    public HashMap<String, String> getAdminLogin(){
        return adminLogin;
    }

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

    public int studentCompare(String inputUsername, String inputPassword){
        if(getStudentLogin().get(inputUsername).equals(hashPassword(inputPassword))) {
            return 1;
        }
        else return 0;
    }

    public int adminCompare(String inputUsername, String inputPassword){
        if(getAdminLogin().get(inputUsername).equals(hashPassword(inputPassword))) {
            return 1;
        }
        else return 0;
    }

    public void storeStudentPassword(String inputStudentUsername, String inputStudentPassword){
        studentLogin.put(inputStudentUsername, hashPassword(inputStudentPassword));
    }
    
    public void storeAdminPassword(String inputAdminUsername, String inputAdminPassword){
        adminLogin.put(inputAdminUsername, hashPassword(inputAdminPassword));
    }

    public String returnStudentPassword(String studentUsername){
        return studentLogin.get(studentUsername);
    }

    public String returnAdminPassword(String adminUsername){
        return studentLogin.get(adminUsername);
    }

    public int checkUserID(String inputStudentUsername){
        if (getStudentLogin().containsKey(inputStudentUsername)){
            return 1;
        }
        return 0;
    }

}
