// level 2 ----> task 3
import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {

    private static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose operation (1 for Encryption, 2 for Decryption): ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the file path: ");
        String filePath = sc.nextLine();

        System.out.print("Enter the output file path: ");
        String outputPath = sc.nextLine();

        try {
            String fileContent = readFile(filePath);
            String processedContent = "";

            if (choice == 1) {
                processedContent = encrypt(fileContent);
                System.out.println("File encrypted successfully!");
            } else if (choice == 2) {
                processedContent = decrypt(fileContent);
                System.out.println("File decrypted successfully!");
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            writeFile(outputPath, processedContent);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();
        return content.toString();
    }

    private static void writeFile(String filePath, String content) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write(content);
        bw.close();
    }

    private static String encrypt(String content) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char ch = content.charAt(i);
            if (Character.isLetter(ch)) {
                char encryptedChar = (char) (ch + SHIFT);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }

    private static String decrypt(String content) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char ch = content.charAt(i);
            if (Character.isLetter(ch)) {
                char decryptedChar = (char) (ch - SHIFT);
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(ch);
            }
        }
        return decrypted.toString();
    }
}
