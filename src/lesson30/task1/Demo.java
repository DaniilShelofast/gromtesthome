package lesson30.task1;

public class Demo {
    public static void main(String[] args) throws Exception {
        Bank euBank = new EUBank(1221, "ECB", Currency.EUR, 120, 1500, 1, 453424566);
        User user = new User(100, "Denis", 12200, 40, "GMD", 1500, euBank);

        UkrainianBankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user,100);

        Thread.sleep(2000);

        bankSystem.withdraw(user,10);
        System.out.println(bankSystem.getTransactions());
    }
}
