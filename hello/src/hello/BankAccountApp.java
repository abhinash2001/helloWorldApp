package hello;

import java.util.Scanner;

//Custom exception for insufficient balance
class InsufficientFundsException extends Exception {
 public InsufficientFundsException(String message) {
     super(message);
 }
}

class BankAccount {
 private String owner;
 private double balance;

 public BankAccount(String owner, double initialBalance) {
     this.owner = owner;
     this.balance = initialBalance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: $" + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 public void withdraw(double amount) throws InsufficientFundsException {
     if (amount > balance) {
         throw new InsufficientFundsException("Insufficient funds. Available balance: $" + balance);
     } else {
         balance -= amount;
         System.out.println("Withdrew: $" + amount);
     }
 }

 public void showBalance() {
     System.out.println(owner + "'s Balance: $" + balance);
 }
}

public class BankAccountApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     BankAccount account = new BankAccount("Alice", 1000.0);

     int choice;
     do {
         System.out.println("\n--- Bank Menu ---");
         System.out.println("1. Deposit");
         System.out.println("2. Withdraw");
         System.out.println("3. Show Balance");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");

         choice = scanner.nextInt();
         switch (choice) {
             case 1:
                 System.out.print("Enter amount to deposit: ");
                 double dep = scanner.nextDouble();
                 account.deposit(dep);
                 break;
             case 2:
                 System.out.print("Enter amount to withdraw: ");
                 double wd = scanner.nextDouble();
                 try {
                     account.withdraw(wd);
                 } catch (InsufficientFundsException e) {
                     System.out.println("Error: " + e.getMessage());
                 }
                 break;
             case 3:
                 account.showBalance();
                 break;
             case 4:
                 System.out.println("Exiting. Thank you!");
                 break;
             default:
                 System.out.println("Invalid choice. Try again.");
         }
     } while (choice != 4);

     scanner.close();
 }
}
