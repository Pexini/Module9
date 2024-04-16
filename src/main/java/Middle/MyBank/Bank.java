package Middle.MyBank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int balance;
    private List<Accounts> accounts = new ArrayList<>();

    public void addAccount(Accounts account) {
        accounts.add(account);
    }

    public Accounts getAccounts(int accountNumber) {
        for (Accounts account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private boolean isPositiveAmount(int amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть положительной.");
            return false;
        }
        return true;
    }

    public void addMoney(int toAccountsNumber, int money) {
        if (!isPositiveAmount(money)) {
            return;
        }
        Accounts toAccountNumber = getAccounts(toAccountsNumber);
        if (toAccountNumber != null) {
            int currentBalance = toAccountNumber.getAccountBalance();
            int newBalance = currentBalance + money;
            toAccountNumber.setAccountBalance(newBalance);
            System.out.println(toAccountNumber.getAccountName() + " Деньги успешно приняты, " + "ваш баланс " + newBalance + " руб.");
        }
    }

    public void withdrawMoney(int fromAccountsNumber, int money) {
        if (!isPositiveAmount(money)) {
            return;
        }
        Accounts fromAccount = getAccounts(fromAccountsNumber);
        if (fromAccount != null) {
            if (fromAccount.getAccountBalance() >= money) {
                int newBalance = fromAccount.getAccountBalance() - money;
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
            System.out.println("Имя владельца " + account.getAccountName() + " " + account.getAccountNumber() + " " + account.getAccountBalance());
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

    public boolean TransferMoney(int fromAccountNumber, int money, int toAccountNumber) {
        Accounts fromAccount = getAccounts(fromAccountNumber);
        Accounts toAcount = getAccounts(toAccountNumber);
        if (!isPositiveAmount(money)) {
            return false;
        }
        if (fromAccount != null && toAcount != null) {
            if (fromAccount.withdrawTransfer(money)) {
                toAcount.depositTransfer(money);
                System.out.println("Перевод выполнен успешно.");
                return true;
            } else {
                System.out.println("Недостаточно средств для перевода.");
            }
        } else {
            System.out.println("Счет не найден.");
        }
        return false;
    }

}






