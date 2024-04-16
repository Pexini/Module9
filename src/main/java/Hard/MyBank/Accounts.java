package Hard.MyBank;

public class Accounts {
    private int accountNumber;
    private String accountName;
    private int accountBalance;

    public Accounts(int accountNumber, String accountName, int accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void depositTransfer(int amount) {
        if (amount > 0) {
            this.accountBalance += amount;
            System.out.println("Счет " + this.accountName + " пополнен на " + amount + ". Новый баланс: " + this.accountBalance);
        } else {
            System.out.println("Ошибка! недостаточно средств.");
        }
    }

    public boolean withdrawTransfer(int amount) {
        if (amount > 0 && this.accountBalance >= amount) {
            this.accountBalance -= amount;
           // System.out.println("Со счета " + this.accountName + " списано " + amount + " . Ваш баланс составляет - " + this.accountBalance);
            return true;
        } else {
//            System.out.println("Ошибка, недостаточно средств на счете. Ваш балас - " + this.accountBalance);
        }
        return false;
    }
}