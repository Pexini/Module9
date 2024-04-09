package Middle.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);

        bankAccount.push(500);
        bankAccount.pop(8000);

    }
}
