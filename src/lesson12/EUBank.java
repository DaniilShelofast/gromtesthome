package lesson12;

public class EUBank extends Bank {
    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployees, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USA)
            return 2000;
        return 2200;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.EUR) {
            return 20000;
        }
        return 10000;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.EUR)
            return 0.01;
        else
            return Integer.MAX_VALUE;
    }

    @Override
    public double getCommissions(int amount) {
        if (getCurrency() == Currency.USA) {
            if (1000 <= amount)
                return 0.05;
            else
                return 0.7;

        } else {
            if (1000 <= amount)
                return 0.02;
            else
                return 0.04;
        }
    }
}
