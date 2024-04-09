package Middle.MyBank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int balance;
    private List<Accounts> accounts = new ArrayList<>();

    public void addAccount(Accounts account) {
        accounts.add(account);
    }

    public void transferMoney(Accounts accounts1, int money, Accounts accounts2) {
        if (accounts1.accountBalance >= money) {
            int sendPayment = accounts1.getAccountBalance();
            int acceptPayment = accounts2.getAccountBalance();
            int newBalanceAccount1 = sendPayment - money;
            int newBalanceAccount2 = acceptPayment + money;

            accounts1.setAccountBalance(newBalanceAccount1);
            accounts2.setAccountBalance(newBalanceAccount2);
            System.out.println( "Деньги успешно переведены " + "Ваш баланс составляет " + newBalanceAccount1);
        }else {
            System.out.println(accounts1.accountName + " Недостаточно средств для снятия перевода. Ваш доступный лимит " + accounts1.getAccountBalance());
        }
    }

    public void addMoney(Accounts accounts, int money) {
        int currentBalance = accounts.getAccountBalance();
        int newBalance = currentBalance + money;
        accounts.setAccountBalance(newBalance);
        System.out.println(accounts.accountName + " Деньги успешно приняты, " + "ваш баланс " + accounts.accountBalance + " руб.");
    }

    public void withdrawMoney(Accounts accounts, int money) {
        if (accounts.accountBalance <= money) {
            System.out.println(accounts.accountName + " Недостаточно средств для снятия наличных. " + "Ваш доступный лимит " + accounts.accountBalance);
        } else {
            int currentBalance = accounts.getAccountBalance();
            int newBalance = currentBalance - money;
            accounts.setAccountBalance(newBalance);
            System.out.println(accounts.accountName + " Деньги успешно сняты, " + "ваш баланс " + accounts.accountBalance + " руб.");

        }
    }
}
