//Task 1 

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Enter the unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);
        
        double convertedTemp;
        
        if (unit == 'C') {
            convertedTemp = (temperature * 9 / 5) + 32;
            System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit.%n", temperature, convertedTemp);
        } else if (unit == 'F') {
            convertedTemp = (temperature - 32) * 5 / 9;
            System.out.printf("%.2f Fahrenheit is equal to %.2f Celsius.%n", temperature, convertedTemp);
        } else {
            System.out.println("Invalid unit. Please enter C for Celsius or F for Fahrenheit.");
        }
        
        scanner.close();
    }
}
