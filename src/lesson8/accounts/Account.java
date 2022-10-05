package lesson8.accounts;

public class Account {
    String bankName;
    String ownerName;
    int moneyAmount;

    public Account(String bankName, String ownerName, int moneyAmount) {
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.moneyAmount = moneyAmount;
    }

    void depositMoney(int amount) {
        moneyAmount += amount;
    }

    void depositMoney(){
        moneyAmount += 1000;
        System.out.println("deposit was successful");
    }

    void changerOwnerName(String newOwnerName) {
        ownerName = newOwnerName;
    }
}
