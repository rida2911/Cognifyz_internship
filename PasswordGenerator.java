//task 4

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the desired password length: ");
        int length = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        if (length < 1) {
            System.out.println("Password length should be at least 1.");
            return;
        }

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLower = sc.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUpper = sc.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = sc.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = sc.nextLine().equalsIgnoreCase("yes");

        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        StringBuilder charPool = new StringBuilder();
        if (includeLower) charPool.append(lowerCase);
        if (includeUpper) charPool.append(upperCase);
        if (includeNumbers) charPool.append(numbers);
        if (includeSpecial) charPool.append(specialChars);

        if (charPool.length() == 0) {
            System.out.println("You must select at least one character type.");
            return;
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        System.out.println("Generated Password: " + password);

        sc.close();
    }
}
