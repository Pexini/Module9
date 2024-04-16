package Middle.MyBank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Accounts(1245, "Синицин В.Ф", 5000));
        bank.addAccount(new Accounts(1246, "Филипов А.У", 0));
        bank.addAccount(new Accounts(1247, "Сорокин П.М", 12_000));


        bank.TransferMoney(1245, 1000, 1246);


        bank.checkAllAccountsBalance();

        bank.checkCurrentBalance(1246);
        bank.checkCurrentBalance(12);

        bank.addMoney(1246, 7000);
        bank.addMoney(1246, -1_000_00);
        bank.checkAllAccountsBalance();

        bank.withdrawMoney(1246, -500);
        bank.checkAllAccountsBalance();

    }


}
