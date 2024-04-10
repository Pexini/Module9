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

    public void addMoney(int toAccountsNumber, int money) {
        Accounts toAccountNumber = getAccounts(toAccountsNumber);
        if (toAccountNumber != null) {
            int currentBalance = toAccountNumber.getAccountBalance();
            int newBalance = currentBalance + money;
            toAccountNumber.setAccountBalance(newBalance);
            System.out.println(toAccountNumber.accountName + " Деньги успешно приняты, " + "ваш баланс " + newBalance + " руб.");
        }
    }

    public void withdrawMoney(int fromAccountsNumber, int money) {
        Accounts fromAccount = getAccounts(fromAccountsNumber);
        if (fromAccount != null) {
            if (fromAccount.accountBalance >= money) {
                int newBalance = fromAccount.accountBalance - money;
                fromAccount.setAccountBalance(newBalance);
                System.out.println(fromAccountsNumber + " Деньги успешно сняты, " + "ваш баланс " + newBalance);
            } else {
                System.out.println(fromAccountsNumber + " Недостаточно средств для снятия наличных. " + "Ваш доступный лимит " + fromAccount.getAccountBalance());
            }
        } else {
            System.out.println("Счет не найден");
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
        }
        if (!found) {
            System.out.println("Аккаунта не найденно");

        }
    }
}



