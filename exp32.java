/*
Medium Level
Problem Statement: Write a Java program to simulate an ATM withdrawal system. The program should:

Ask the user to enter their PIN.
Allow withdrawal if the PIN is correct and the balance is sufficient.
Throw exceptions for invalid PIN or insufficient balance.
Ensure the system always shows the remaining balance, even if an exception occurs.

Input Example:
Enter PIN: 1234
Withdraw Amount: 5000
Output Example:
Error: Insufficient balance. Current Balance: 3000

*/
import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class exp32 {
    private static final int PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();
            if (enteredPin != PIN) {
                throw new InvalidPINException("Error: Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();

            if (amount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);

        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Current Balance: " + balance);
            scanner.close();
        }
    }
}
