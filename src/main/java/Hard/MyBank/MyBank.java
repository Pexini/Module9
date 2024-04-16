package Hard.MyBank;

import java.util.ArrayList;
import java.util.List;

public class MyBank {
    private static final int MAX_BANK_BALANCE = 1000;
    private int currentBalance;
    private boolean isEnable;
    private List<Accounts> accounts;

    public MyBank() {
        this.currentBalance = 0;
        this.isEnable = true;
        this.accounts = new ArrayList<>();
    }

    private boolean isPositiveAmount(int amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: неверная сумма! Сумма должна быть положительной!");
            return false;
        }
        return true;
    }

    public Accounts getAccount(int accountNumber) {
        for (Accounts account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }


    public void add(Accounts accounts) {
        if (isEnable && currentBalance + accounts.getAccountBalance() <= MAX_BANK_BALANCE) {
            this.accounts.add(accounts);
            currentBalance += accounts.getAccountBalance();
            System.out.println("Новый аккаунт добавлен " + " общий баланс в банке " + currentBalance);
        } else {
            System.out.println("Невозможно добавить новый аккаунт " + accounts.getAccountName() + ", с балансом " + accounts.getAccountBalance() + ". Это превысит допустимый лимит банка. " + "Сейчас в банке " + currentBalance + "руб");
        }
    }

    public boolean transferMoney(int fromAccountNumber, int money, int toAccountNumber) {
        if (!isPositiveAmount(money)) {
            return false;
        }
        Accounts fromAccount = getAccount(fromAccountNumber);
        Accounts toAccount = getAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdrawTransfer(money)) {
                toAccount.depositTransfer(money);
                System.out.println("Уважаемый " + fromAccount.getAccountName() + ", деньги в сумме " + money + " успешно отправленны. Ваш текущий баланс составляет " + fromAccount.getAccountBalance());
                return true;
            } else {
                System.out.println("Уважаемый " + fromAccount.getAccountName() + " Перевод " + money + " запрещен! Превышен лимит, сумма вашего баланса составляет " + fromAccount.getAccountBalance());
            }
        } else {
            System.out.println("Счет не найден");
        }
        return false;
    }

    public boolean addMoney(int toAccountsNumber, int money) {
        if (!isPositiveAmount(money)) {
            return false;
        }
        Accounts toAccountNumber = getAccount(toAccountsNumber);
        if (toAccountNumber == null) {
            System.out.println("Счет не найден");
            return false;
        }
        if (currentBalance + money > MAX_BANK_BALANCE) {
            System.out.println("Операция невозможна, превышен лимит банка.");
            return false;
        }
        if (toAccountNumber.depositTransfer(money)) {
            int newBalance = toAccountNumber.getAccountBalance();
            System.out.println(toAccountNumber.getAccountName() + " Ваши деньги в сумме " + money + " приняты, текущий баланс  равен " + newBalance);
            return true;
        } else {
            System.out.println(toAccountNumber.getAccountName() + " Невозможно положитьт данную сумму, " + money + " возможная сумма для внесения " + (MAX_BANK_BALANCE - currentBalance));
            return false;
        }

    }

    public void checkCurrentBankBalance() {
        int totalBalance = 0;
        System.out.println("Баланс всех счетов в банке:");
        for (Accounts account : accounts) {
            System.out.println("Имя владельца " + account.getAccountName() + " " + account.getAccountNumber() + " " + account.getAccountBalance());
        totalBalance += account.getAccountBalance();
        }
            System.out.println(" Итого в банке = " + totalBalance + " руб");

    }

    public boolean withdrawMoney(int fromAccountsNumber, int money) {
        if (!isPositiveAmount(money)) {
            return false;
        }
        Accounts toAccountNumber = getAccount(fromAccountsNumber);
        if (toAccountNumber == null) {
            System.out.println("Счет не найден");
            return false;
        }

        if (toAccountNumber.withdrawTransfer(money)) {
            int newBalance = toAccountNumber.getAccountBalance();
            System.out.println(toAccountNumber.getAccountName() + " Ваши деньги в сумме " + money + " сняты, текущий баланс  равен " + newBalance);
            return true;
        } else {
            System.out.println(toAccountNumber.getAccountName() + " Невозможно снять данную сумму, " + money + " возможная сумма для снятия " + (toAccountNumber.getAccountBalance()));
            return false;
        }

    }



}

