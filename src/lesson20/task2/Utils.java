package lesson20.task2;

public class Utils {
    private final static int LimitTransactionsPerDayCount = 10;
    private final static int LimitTransactionsPerDayAmount = 100;
    private final static int LimitSimpleTransactionAmount = 40;
    private final static String[] cities = {"Kiev", "Odessa"};

    public static int getLimitTransactionsPerDayCount() {
        return LimitTransactionsPerDayCount;
    }

    public static int getLimitTransactionsPerDayAmount() {
        return LimitTransactionsPerDayAmount;
    }

    public static int getLimitSimpleTransactionAmount() {
        return LimitSimpleTransactionAmount;
    }

    public static String[] getCities() {
        return cities;
    }
}
