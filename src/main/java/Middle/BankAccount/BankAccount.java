package Middle.BankAccount;

public class BankAccount {
    private int balance;

    public BankAccount(int balanse) {
        this.balance = balanse;
    }

    public void pop(int money) { // Положить деньги на счет
        balance += money;
        System.out.println("Деньги успешно приняты, " + "ваш баланс " + balance + " руб.");
    }

    public void push(int money) { //  Вывести деньги со счета
        if (money <= balance){
            balance -= money;
            System.out.println("Деньги успешно отправленны, " + " ваш баланс " + balance + " руб.");
        }else {
            System.out.println("Недостаточно средств на счету, " + "ваш баланс - "  + balance + " руб.");
        }
    }
}
