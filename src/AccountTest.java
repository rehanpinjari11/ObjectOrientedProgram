class Account {

    private double balance;

    public Account(double initialBalance)
    {
        if (initialBalance > 0.0)
        {
            balance = initialBalance;
        }
    }

    // Method to credit (add) an amount to the account
    public void credit(double amount)
    {
        balance += amount;
    }

    // Method to debit (subtract) an amount from the account
    public void debit(double amount)
    {
        if (amount > balance)
        {
            System.out.println("Debit amount exceeded account balance.");
        }
        else
        {
            balance -= amount;
        }
    }

    // Method to return the account balance
    public double getBalance()
    {
        return balance;
    }
}


public class AccountTest {

    public static void main(String[] args)
    {
        Account account1 = new Account(50.00);
        Account account2 = new Account(100.00);

        System.out.printf("Account1 balance: $%.2f%n", account1.getBalance());
        System.out.printf("Account2 balance: $%.2f%n", account2.getBalance());

        account1.debit(30.00); // valid debit
        account2.debit(150.00); // invalid debit, should print a message

        System.out.printf("%nAfter debits:%n");
        System.out.printf("Account1 balance: $%.2f%n", account1.getBalance());
        System.out.printf("Account2 balance: $%.2f%n", account2.getBalance());
    }
}
