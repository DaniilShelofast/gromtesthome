package lesson30Home;

import java.util.ArrayList;

public class CustomerDAO {
    private static final ArrayList<Customer> customers = new ArrayList<>();

    public CustomerDAO() {
        Customer customer1 = new Customer("rrr", "ccc", "eee", 100);
        Customer customer2 = new Customer("test", "test", "test", 50);

        customers.add(customer1);
        customers.add(customer2);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
