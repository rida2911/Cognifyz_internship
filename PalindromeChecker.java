//task 2 

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();
        
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int length = cleanedInput.length();
        boolean isPalindrome = true;
        
        for (int i = 0; i < length / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println("The entered word or phrase is a palindrome.");
        } else {
            System.out.println("The entered word or phrase is not a palindrome.");
        }
        
        scanner.close();
    }
}

