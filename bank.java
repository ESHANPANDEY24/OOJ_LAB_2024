import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int number, String type) {
        customerName = name;
        accountNumber = number;
        accountType = type;
        balance = 0.0;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Updated balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavAcct extends Account {
    double interestRate;

    SavAcct(String name, int number) {
        super(name, number, "Savings");
        interestRate = 0.05; // Set your desired interest rate
    }

    void computeInterest() {
        double interest = balance * interestRate;
        deposit(interest);
        System.out.println("Interest computed and deposited. Updated balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Updated balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

class CurAcct extends Account {
    double minBalance;
    double serviceCharge;

    CurAcct(String name, int number) {
        super(name, number, "Current");
        minBalance = 1000.0; 
        serviceCharge = 20.0; 
    }

    void imposeServiceCharge() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Service charge imposed. Updated balance: " + balance);
        }
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Updated balance: " + balance);
            imposeServiceCharge();
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        SavAcct savingsAccount = new SavAcct(customerName, accountNumber);
        CurAcct currentAccount = new CurAcct(customerName, accountNumber);

        System.out.print("Enter deposit amount for Savings Account: ");
        double savingsDeposit = scanner.nextDouble();
        savingsAccount.deposit(savingsDeposit);

        System.out.print("Enter deposit amount for Current Account: ");
        double currentDeposit = scanner.nextDouble();
        currentAccount.deposit(currentDeposit);

        System.out.print("Enter withdrawal amount for Savings Account: ");
        double savingsWithdrawal = scanner.nextDouble();
        savingsAccount.withdraw(savingsWithdrawal);

        System.out.print("Enter withdrawal amount for Current Account: ");
        double currentWithdrawal = scanner.nextDouble();
        currentAccount.withdraw(currentWithdrawal);

        System.out.println("Savings Account Balance:");
        savingsAccount.displayBalance();

        System.out.println("Current Account Balance:");
        currentAccount.displayBalance();

        scanner.close();
    }
}
