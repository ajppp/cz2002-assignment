import java.util.Scanner;

public class LoginPage{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to NTU STARS!");
        System.out.printf("Username: ");
        String username = sc.next();
        String password = PasswordField.readPassword("Enter password: ");
        System.out.println("The username entered is: " + username);
        System.out.println("The password entered is: " + password);
    }
}
