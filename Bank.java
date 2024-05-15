package Banking_System;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Bank {
    String name , account_no , password;
    double balance;
    Bank(String name , String account_no , String password){
        this.name = name;
        this.account_no = account_no;
        this.password = password;
        this.balance = 0;
    }
    void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient funds");
        }
        else {
            balance -= amount;
            System.out.println(amount + " Debited");
            System.out.println(balance + " Remaining");
        }
    }
    void deposit(double amount){
        balance += amount;
        System.out.println("Your current balance is: " + balance);
    }

}
class GFG{
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList <Bank> accounts = new ArrayList<>();
        System.out.println("Welcome To SBI!!! \nPlease enter your details: ");
        while(choice != 6) {
            System.out.println("Please Select an Option: ");
            System.out.println("1. Create new account\n2. Display all account details\n" +
                    "3. Search By account number\n4. Deposit the amount\n5. Withdraw the amount\n6. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter your name : ");
                    String name = sc.next();
                    name += sc.nextLine();
                    System.out.println("Enter your account_no: ");
                    String account_no = sc.next();
                    System.out.println("Enter your Password: ");
                    String password = sc.next();
                    Bank newAccount = new Bank(name,account_no,password);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully!!");
                    break;
                }
                case 2: {
                    System.out.println("Account details are: ");
                    System.out.println("----------------------------------");
                    for (Bank account : accounts) {
                        System.out.println("Name: " + account.name);
                        System.out.println("Account_no: " + account.account_no);
                        System.out.println("Balance: " + account.balance);
                        System.out.println("----------------------------------");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter account_no: ");
                    String accountNo = sc.next();
                    for(Bank account : accounts){
                        if(Objects.equals(account.account_no, accountNo)){
                            System.out.println("Account details are: ");
                            System.out.println("Name: " + account.name);
                            System.out.println("Account_no: " + account.account_no);
                            System.out.println("Balance: " + account.balance);
                        }
                    }
                   break;
                }
                case 4: {
                    System.out.println("Enter the account_no: ");
                    String accountNo = sc.next();
                    for(Bank account : accounts) {
                        if(Objects.equals(account.account_no, accountNo)) {
                            System.out.println("Enter the amount to be deposited: ");
                            double amount = sc.nextDouble();
                            account.deposit(amount);
                        } else {
                            System.out.println("Account Not found!!");
                        }
                        break;
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter the account_no: ");
                    String accountNo = sc.next();
                    System.out.println("Enter Password: ");
                    String psw = sc.next();
                    for(Bank account : accounts) {
                        if (Objects.equals(account.account_no, accountNo) && Objects.equals(account.password, psw)) {
                            System.out.println("Enter the amount to be withdrawn");
                            double amount = sc.nextDouble();
                            account.withdraw(amount);
                        }
                        else {
                            System.out.println("INVALID ACCOUNT OR PASSWORD!!");
                        }
                        break;
                    }
                    break;
                }
                case 6: {
                    System.out.println("Thanks for visiting!!!");
                    break;
                }
                default: {
                    System.out.println("!!!Select a valid option");
                }
            }
        }
    }
}