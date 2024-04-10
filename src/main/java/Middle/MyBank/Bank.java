package Middle.MyBank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int balance;
    private List<Accounts> accounts = new ArrayList<>();

    public void addAccount(Accounts account) {
        accounts.add(account);
    }

    public Accounts getAccounts(int accountNomber) {
        for (Accounts account : accounts) {
            if (account.getAccountNumber() == accountNomber) {
                return account;
            }
        }
        return null;
    }


    public void transferMoney(int fromAccountNumber, int money, int toAccountNumber) {
        Accounts fromAccount = getAccounts(fromAccountNumber);
        Accounts toAccount = getAccounts(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getAccountNumber() >= money) {
                int newBalanceFrom = fromAccount.getAccountBalance() - money;
                int newBalanceTo = toAccount.getAccountBalance() + money;

                fromAccount.setAccountBalance(newBalanceFrom);
                toAccount.setAccountBalance(newBalanceTo);
                System.out.println("Деньги успешно переведены " + "Ваш баланс составляет " + newBalanceFrom);

            } else {
                System.out.println(fromAccount.accountName + " Недостаточно средств для снятия перевода. Ваш доступный лимит " + fromAccount.getAccountBalance());
            }
        } else {
            System.out.println("Счет не найден");
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

    public void checkAllAccountsBalance() {
        System.out.println("Баланс всех счетов: ");
        for (Accounts account : accounts) {
            System.out.println("Имя владельца " + account.accountName + " " + account.accountNumber + " " + account.accountBalance);
        }
    }

    public void checkCurrentBalance(int accountNumber) {
        boolean found = false;
        for (Accounts account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.println("Баланс для " + accountNumber + " равен " + account.getAccountBalance());
                found = true;
                break;
            }
            if (!found) {
                System.out.println("Такого аккаунта не найденно");
            }
        }
    }

}

