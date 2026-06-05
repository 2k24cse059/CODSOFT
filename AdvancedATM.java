import java.util.Scanner;

class UserAccount {
    private double balance;
    private int pin;

    public UserAccount(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Please Collect Your Cash.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class AdvancedATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserAccount account = new UserAccount(15000, 1234);

        System.out.println("===== ATM LOGIN =====");
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!account.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN. Access Denied!");
            return;
        }

        int choice;

        do {
            System.out.println("\n========== ATM ==========");
            System.out.println("1. Cash Deposit");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Select Option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Withdrawal Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Available Balance: ₹" + account.getBalance());
                    break;

                case 4:
                    System.out.println("----- MINI STATEMENT -----");
                    System.out.println("Account Type : Savings");
                    System.out.println("Current Balance : ₹" + account.getBalance());
                    break;

                case 5:
                    System.out.println("Thank You For Using ATM.");
                    break;

                default:
                    System.out.println("Invalid Option!");
            }

        } while (choice != 5);

        sc.close();
    }
}