// level 2 
// task 2 

import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        String strength = checkStrength(password);
        System.out.println("Password Strength: " + strength);

        sc.close();
    }

    static String checkStrength(String password) {
        int length = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.contains(String.valueOf(ch))) hasSpecial = true;
        }

        if (length < 8) {
            return "Weak (Too short)";
        } else if (hasLower && hasUpper && hasDigit && hasSpecial) {
            return "Strong";
        } else if ((hasLower || hasUpper) && hasDigit && hasSpecial) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}
