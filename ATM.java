import java.util.*;

public class ATM {
    private double balance;
    private List<String> transactionHistory;
    private String userId;
    private String userPin;

    public ATM(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 1000.0; // default balance
        this.transactionHistory = new ArrayList<>();
    }

    public boolean login(String enteredId, String enteredPin) {
        return userId.equals(enteredId) && userPin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Date() + " - Deposited: Rs." + amount);
            System.out.println("Rs." + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Date() + " - Withdrawn: Rs." + amount);
            System.out.println("Rs." + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void transfer(double amount, String recipientId) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Date() + " - Transferred Rs." + amount + " to " + recipientId);
            System.out.println("Transferred Rs." + amount + " to " + recipientId + " successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String record : transactionHistory) {
                System.out.println(record);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM("user123", "1234");

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine();
        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (atm.login(enteredId, enteredPin)) {
            System.out.println("Login Successful!");
            while (true) {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Quit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.showTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: Rs.");
                        atm.withdraw(sc.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: Rs.");
                        atm.deposit(sc.nextDouble());
                        break;
                    case 4:
                        System.out.print("Enter recipient ID: ");
                        sc.nextLine(); // consume newline
                        String recipientId = sc.nextLine();
                        System.out.print("Enter amount to transfer: Rs.");
                        atm.transfer(sc.nextDouble(), recipientId);
                        break;
                    case 5:
                        atm.checkBalance();
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Have A Nice Day!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid User ID or PIN.");
        }
    }
}
