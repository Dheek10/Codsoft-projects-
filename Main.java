import java.util.Scanner;
class BankAccount {
private double balance;
public BankAccount(double initialBalance) {
this.balance = initialBalance;
}
public double getBalance() {
return balance;
}
public void deposit(double amount) {
balance += amount;
}
public boolean withdraw(double amount) {
if (amount <= balance) {
balance -= amount;
return true;
} 
else{
return false;
}
}
}
class ATM {
private BankAccount userAccount;
public ATM(BankAccount userAccount) {
this.userAccount = userAccount;
}
public void withdraw(double amount) {
if (amount > 0 && amount <= userAccount.getBalance()) {
if (userAccount.withdraw(amount))
System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
} 
else if
{
System.out.println("Withdrawal failed. Insufficient funds.");
}
}
else
{
System.out.println("Invalid withdrawal amount.");
}
}
public void deposit(double amount) {
if (amount > 0) {
userAccount.deposit(amount);
System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
} 
else 
{
System.out.println("Invalid deposit amount.");
}
}
public void checkBalance() {
System.out.println("Current balance: " + userAccount.getBalance());
}
public void displayOptions() {
System.out.println("1. Withdraw");
System.out.println("2. Deposit");
System.out.println("3. Check Balance");
System.out.println("4. Quit");
}
}
}
public class Main {
public static void main(String[] args) {
BankAccount userAccount = new BankAccount(1000.0);
ATM atm = new ATM(userAccount);
Scanner scanner = new Scanner(System.in);
while (true) {
atm.displayOptions();
System.out.print("Choose an option (1-4): ");
int option = scanner.nextInt();
switch (option) {
case 1:
System.out.print("Enter withdrawal amount: ");
double withdrawAmount = scanner.nextDouble();
atm.withdraw(withdrawAmount);
break;
case 2:
System.out.print("Enter deposit amount: ");
double depositAmount = scanner.nextDouble();
atm.deposit(depositAmount);
break;
case 3:
atm.checkBalance();
break;
case 4:
System.out.println("Exiting. Thank you!");
System.exit(0);
}
}
}
}