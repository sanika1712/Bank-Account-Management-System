import java.util.*;
 class BankAccount {

    // Private variables (Encapsulation)
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(int accNo, String name, double initialBalance) {
        accountNumber = accNo;
        accountHolderName = name;
        balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}
public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking account details
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        // Creating BankAccount object
        BankAccount account = new BankAccount(accNo, name, balance);

        int choice;

        // Menu loop
        while (true) {
            System.out.println("\n------ Bank Menu ------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using our bank.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
