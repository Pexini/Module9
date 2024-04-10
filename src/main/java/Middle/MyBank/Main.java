package Middle.MyBank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Accounts(1245, "Синицин В.Ф", 5000));
        bank.addAccount(new Accounts(1246, "Филипов А.У", 0));
        bank.addAccount(new Accounts(1247, "Сорокин П.М", 12_000));


        bank.transferMoney(1245, 1000, 1246);
        bank.transferMoney(1247, 300, 1246);
        bank.transferMoney(1246, 5000, 1245);

        bank.checkAllAccountsBalance();

        bank.checkCurrentBalance(1246);
        bank.checkCurrentBalance(12);

        bank.addMoney(1246, 7000);
        bank.checkAllAccountsBalance();

        bank.withdrawMoney( 1246, 500);
        bank.checkAllAccountsBalance();

    }


}
