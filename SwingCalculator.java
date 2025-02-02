import java.util.InputMismatchException;
import java.util.Scanner;

public class SwingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input validation for numbers
        double num1 = getNumberInput(scanner, "Enter the first number: ");
        double num2 = getNumberInput(scanner, "Enter the second number: ");

        // Display operation choices
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        // Input validation for operation choice
        int choice = getOperationChoice(scanner);

        double result = performOperation(num1, num2, choice);

        if (result != Double.NaN) {
            System.out.println("Result: " + num1 + " " + getOperationSymbol(choice) + " " + num2 + " = " + result);
        }

        scanner.close();
    }

    private static double getNumberInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static int getOperationChoice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the number corresponding to the operation: ");
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static double performOperation(double num1, double num2, int choice) {
        switch (choice) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                    return Double.NaN;
                }
            default:
                return Double.NaN;
        }
    }

    private static String getOperationSymbol(int choice) {
        switch (choice) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
            case 4:
                return "/";
            default:
                return "";
        }
    }
}
