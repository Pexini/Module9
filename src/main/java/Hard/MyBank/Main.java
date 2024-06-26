package Hard.MyBank;

public class Main {
    public static void main(String[] args) {
        MyBank bank = new MyBank();

        Accounts accounts = new Accounts(1257, "Синицин В.А", 300);
        Accounts accounts1 = new Accounts(1258, "Пушкин С.А", 400);
        Accounts accounts2 = new Accounts(1259, "Кузницов Т.П", 250);
        Accounts accounts3 = new Accounts(1260, "Кутузов Ш.А", 150);
        Accounts accounts4 = new Accounts(1261, "Васнецов У.М", 150);
        Accounts accounts5 = new Accounts(1263, "Ковалев А.М", 500);

        bank.add(accounts2);
        bank.add(accounts1);
        bank.add(accounts);


        bank.transferMoney(1257, 200, 1258);
        System.out.println();

        bank.transferMoney(1257, -200, 1259);
        System.out.println();


        bank.transferMoney(1258, 1400, 1259);
        System.out.println();

        bank.transferMoney(12, 400, 1258);
        System.out.println();

        bank.addMoney(1257, 30);
        bank.addMoney(1259, -30);
        System.out.println();
        bank.addMoney(1259, 2000);
        System.out.println();
        System.out.println();
        bank.addMoney(129, 2000);
        System.out.println();
        bank.checkCurrentBankBalance();



        bank.withdrawMoney(1258, 1400);



        bank.checkCurrentBankBalance();
    }
}
