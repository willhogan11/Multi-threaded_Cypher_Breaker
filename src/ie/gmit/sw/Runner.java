package ie.gmit.sw;
import java.util.*;

public class Runner {

	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your Plain text message to be sent:"); // Prompt user to enter the message they want to send
		String message = input.nextLine().toUpperCase(); // Store it in a String
		String encryptMessage = new RailFence().encrypt(message, 5); // Encrypt the message using the RailCypher class
		System.out.println(">" + encryptMessage); // Print Encrypted Text out to screen
		input.close();
		
		// ** DEBUG **
			// String decryptMessage = new RailFence().decrypt(encryptMessage, 5); // Decrypt the message using the RailCypher class
			// System.out.println(">" + decryptMessage); // Test Print
		// ** END DEBUG **
		
		Consumer consumer = new Consumer(encryptMessage);

	} // End main
	
} // End class