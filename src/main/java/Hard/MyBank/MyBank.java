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
    public Accounts getAccount (int accountNumber){
        for (Accounts account : accounts){
            if (account.getAccountNumber() == accountNumber){
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

    public void transferMoney(int fromAccountNumber, int money, int toAccountNumber) {
        Accounts fromAccount = getAccount(fromAccountNumber);
        Accounts toAccount = getAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null){
            if (fromAccount.getAccountBalance() >= money){
                int newBalanceFrome = fromAccount.getAccountBalance() - money;
                int newBalanceto = toAccount.getAccountBalance() + money;
                fromAccount.setAccountBalance(newBalanceFrome);
                toAccount.setAccountBalance(newBalanceto);
                System.out.println("Уважаемый " + fromAccount.getAccountName() +  ", деньги в сумме " + money + " успешно отправленны. Ваш текущий баланс составляет " + newBalanceFrome);
            }else {
                System.out.println("Уважаемый " + fromAccount.getAccountName() +  " Перевод " + money +  " запрещен! Превышен лимит, сумма вашего баланса составляет " + fromAccount.getAccountBalance());
            }
        }else {
            System.out.println("Счет не найден");
        }

    }
}
