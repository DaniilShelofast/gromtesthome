package lesson20.task2;

public class Utils {
    private int LimitTransactionsPerDayCount = 10;
    private int LimitTransactionsPerDayAmount = 100;
    private int LimitSimpleTransactionAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionsPerDayCount() {
        return LimitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return LimitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return LimitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
