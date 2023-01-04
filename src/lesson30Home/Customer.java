package lesson30Home;

public class Customer {
    private String firstName;
    private String lastName;
    private String country;
    private int monthlyPay;

    public Customer(String firstName, String lastName, String country, int monthlyPay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", monthlyPay=" + monthlyPay +
                '}';
    }
}
