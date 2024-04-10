package Hard.MyBank;

import java.util.ArrayList;
import java.util.List;

public class MyBank {
    private static final int MAX_BANK_BALANCE = 1000;
    private int currentBalance;
    private  boolean isEnable;
    private List<Accounts> accounts;

    public MyBank() {
        this.currentBalance = 0;
        this.isEnable = true;
        this.accounts = new ArrayList<>();
    }

    public void add(Accounts accounts){
        if (isEnable && currentBalance + accounts.getAccountBalance() <= MAX_BANK_BALANCE){
            this.accounts.add(accounts);
            currentBalance += accounts.getAccountBalance();
            System.out.println("Новый аккаунт добавлен " + " общий баланс в банке " + currentBalance);
        }else {
            System.out.println("Невозможно добавить новый аккаунт " + accounts.getAccountName() + ", с балансом " + accounts.getAccountBalance() + ". Это превысит допустимый лимит банка. " + "Сейчас в банке " + currentBalance + "руб");
        }
    }

}
