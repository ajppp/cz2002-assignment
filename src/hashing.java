import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your Password: ");
		String password = sc.nextLine();
		String algorithm = "MD5";
		byte[] salt = createSalt();
		String hashedPassword = generateHash(password, algorithm, salt)
		System.out.println( algorithm + " Hashed password: " + hashedPassword);
		
	}
	
	private static String generateHash(String password, String algorithm, byte[] salt) throws NoSuchAlgorithmException{
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.reset();
		digest.update(salt);
		byte[] hash = digest.digest(password.getBytes());
				return bytesToStringHex(hash);
		
	}
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public static String bytesToStringHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j=0; j<bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
	
	public static byte[] createSalt() {
		byte[] bytes = new byte[20];
		SecureRandom random = new SecureRandom();
		random.nextBytes(bytes);;
		return bytes;
	}

	public static boolean checkPassword(String typedPassword, String hashedPassword) {
		
	}
	
}
