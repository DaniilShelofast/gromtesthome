package lesson30.task1;



public class ChinaBank extends Bank {
    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployees, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USA)
            return 100;
        return 150;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.EUR) {
            return 5000;
        }
        return 10000;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.USA) {
            return 0.01;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public double getCommissions(int amount) {
        if (getCurrency() == Currency.USA) {
            if (1000 <= amount)
                return 0.03;
            else
                return 0.05;
        } else {
            if (1000 <= amount)
                return 0.10;
            else
                return 0.11;

        }
    }
}