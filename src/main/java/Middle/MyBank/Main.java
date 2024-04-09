package Middle.MyBank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Accounts(1245, "Синицин В.Ф", 5000));
        bank.addAccount(new Accounts(1246, "Филипов А.У", 0));
        bank.addAccount(new Accounts(1247, "Сорокин П.М", 12_000));

        bank.addMoney(new Accounts(1245, "Синицин В.Ф", 5000), 500);

        bank.withdrawMoney(new Accounts(1247, "Сорокин П.М", 12_000), 6000);
        bank.withdrawMoney(new Accounts(1247, "Сорокин П.М", 6_000), 7000);

        bank.transferMoney(new Accounts(1245, "Синицин В.Ф", 5000),
                300, new Accounts(1246, "Филипов А.У", 0));

        bank.checkAllAccountsBalance();
    }


}
