package e3_3;

public class BankAccount {
    // Your variable declarations and code here
    private static int totalAccounts=0;
    private int id;
    private int balance;
    public BankAccount(int balance) {
        this.id=totalAccounts+=1;
        this.balance=balance;
    }
    public void deposit(int amount) {this.balance+=amount;}
    public void withdraw(int amount) {this.balance-=amount;}
    public int getAccountNumber() {return this.id;}
    public int getBalance() {return this.balance;}
    public static int getTotalAccounts() {return totalAccounts;}
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
