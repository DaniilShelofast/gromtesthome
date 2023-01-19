package lesson30Home;

import java.util.ArrayList;

public class CustomerDAO {
    private static ArrayList<Customer> customers = new ArrayList<>();

    public CustomerDAO() {
        Customer customer1 = new Customer("qqq", "qqq", "qqq", 100);
        Customer customer2 = new Customer("ooo", "ooo", "ooo", 100);

        customers.add(customer1);
        customers.add(customer2);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
