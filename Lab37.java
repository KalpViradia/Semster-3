import java.util.*;

class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class Lab37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of bank accounts: ");
        int numAccounts = sc.nextInt();
        sc.nextLine();
        BankAccount[] accounts = new BankAccount[numAccounts];
        for (int i = 0; i < numAccounts; i++) {
            System.out.println("Enter details for account " + (i + 1));
            System.out.print("Account Number: ");
            String accountNumber = sc.nextLine();
            System.out.print("Account Holder Name: ");
            String accountHolderName = sc.nextLine();
            System.out.print("Initial Balance: ");
            double initialBalance = sc.nextDouble();
            sc.nextLine();
            accounts[i] = new BankAccount(accountNumber, accountHolderName, initialBalance);
        }
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = sc.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    sc.nextLine();
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber().equals(depositAccountNumber)) {
                            account.deposit(depositAmount);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = sc.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    sc.nextLine();
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber().equals(withdrawAccountNumber)) {
                            account.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String balanceAccountNumber = sc.nextLine();
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber().equals(balanceAccountNumber)) {
                            account.checkBalance();
                            break;
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}