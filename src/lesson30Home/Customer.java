package lesson30Home;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return monthlyPay == customer.monthlyPay && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, country, monthlyPay);
    }
}
