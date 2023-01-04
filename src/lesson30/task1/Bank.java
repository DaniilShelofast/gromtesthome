package lesson30.task1;



public abstract class Bank {
    private long id;
    private String bankCountry;
    //банк країни
    private Currency currency;
    // валюта
    private int numberOfEmployees;
    // кількість працівників
    private double avrSalaryOfEmployees;
    // заробітна плата співробітників
    private long rating;
    // рейтинг
    private long totalCapital;
    // загальний капітал


    public Bank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployees, long rating, long totalCapital) {
        this.id = id;
        this.bankCountry = bankCountry;
        this.currency = currency;
        this.numberOfEmployees = numberOfEmployees;
        this.avrSalaryOfEmployees = avrSalaryOfEmployees;
        this.rating = rating;
        this.totalCapital = totalCapital;
    }


    public abstract int getLimitOfWithdrawal();//отримати ліміт виведення коштів

    public abstract int getLimitOfFunding();//отримати ліміт фінансування

    public abstract double getMonthlyRate();//отримати місячну ставку

    public abstract double getCommissions(int amount);//отримувати комісійні, сума

    public double moneyPaidMonthlyForSalary() { //гроші виплачуються щомісяця на зарплату
        return numberOfEmployees * avrSalaryOfEmployees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getAvrSalaryOfEmployees() {
        return avrSalaryOfEmployees;
    }

    public void setAvrSalaryOfEmployees(double avrSalaryOfEmployees) {
        this.avrSalaryOfEmployees = avrSalaryOfEmployees;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(long totalCapital) {
        this.totalCapital = totalCapital;
    }
}