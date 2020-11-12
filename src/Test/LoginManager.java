import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class LoginManager implements java.io.Serializable{
    private static final long serialVersionUID = 7L;
    private Dictionary studentLogin = new Hashtable();
    private Dictionary adminLogin = new Hashtable();

    public String hashPassword(String Password){
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

    public boolean studentCompare(String inputUsername, String inputPassword){
        return (studentLogin.get(inputUsername) == inputPassword);
    }

    public boolean adminCompare(String inputUsername, String inputPassword){
        return (adminLogin.get(inputUsername) == inputPassword);
    }
}
