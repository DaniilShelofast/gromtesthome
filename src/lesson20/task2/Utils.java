package lesson20.task2;

public class Utils {
    private static int LimitTransactionsPerDayCount = 10;
    private static int LimitTransactionsPerDayAmount = 100;
    private static int LimitSimpleTransactionAmount = 40;
    private static String[] cities = {"Kiev", "Odessa"};

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
