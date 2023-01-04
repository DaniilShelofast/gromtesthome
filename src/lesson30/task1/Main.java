package lesson30.task1;


public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 44445554);
        User user = new User(100, "Denis", 12200, 40, "GMD", 1500, usBank);
        User user2 = new User(111, "Max", 12200, 40, "GMD", 1500, usBank);
        Bank euBank = new EUBank(1221, "ECB", Currency.EUR, 120, 1500, 1, 453424566);
        User user3 = new User(102, "Iryna", 13200, 40, "GMD", 1500, euBank);
        User user4 = new User(101, "Ann", 15600, 40, "GMD", 1500, euBank);
        Bank chinaBank = new ChinaBank(6545, "ICBC", Currency.USA, 2000, 1700, 1, 88888888);
        User user5 = new User(102, "Igor", 55500, 5, "GMD", 1600, chinaBank);
        User user6 = new User(102, "Maryna", 130, 10, "GMD", 1400, chinaBank);
        BankSystem bankSystem = new UkrainianBankSystem();

        //------------------  зняти і поповнити
       /* bankSystem.withdraw(user, 150);
        System.out.println(user.getBalance());
        bankSystem.fund(user, 150);
        System.out.println(user.getBalance());*/

        //------------------ трансфер
        /*User toUser = new User(100, "Denis", 12200, 40, "GMD", 1500, usBank);
        User fromUser = new User(111, "Max", 12200, 40, "GMD", 1500, usBank);
        bankSystem.transferMoney(fromUser, toUser, 150);
        System.out.println(fromUser.getBalance());
        System.out.println(toUser.getBalance());*/


        //------------------ зарплата
        //bankSystem.paySalary(user);
        //System.out.println(user.getBalance());


    }
}
