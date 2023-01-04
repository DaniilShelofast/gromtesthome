package lesson30.task1;



public class USBank extends Bank {
    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployees, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {//отримати ліміт виведення коштів
        if (getCurrency() == Currency.USA)
            return 1000;
        return 1200;

    }

    @Override
    public int getLimitOfFunding() {//отримати ліміт фінансування
        if (getCurrency() ==Currency.EUR) {
            return 10000;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public double getMonthlyRate() { //отримати місячну ставку
        if (getCurrency() == Currency.EUR)
            return 0.02;
        else
            return 0.01;

    }

    @Override
    public double getCommissions(int amount) {//отримувати комісійні, сума
        if (getCurrency() == Currency.USA) {
            if (amount <= 1000)
                return 0.05;
            else
                return 0.07;
        } else {
            if (amount <= 1000)
                return 0.06;
            else
                return 0.08;

        }

    }
}
