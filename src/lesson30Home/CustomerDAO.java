package lesson30Home;

import java.util.ArrayList;
import java.util.LinkedList;

import static lesson30Home.ProjectDAO.getProjects;

public class CustomerDAO {
    private static final LinkedList<Customer> customers = new LinkedList<>();

    public CustomerDAO() {
        Customer customer1 = new Customer("rrr", "ccc", "eee", 100);
        Customer customer2 = new Customer("test", "test", "test", 50);

        customers.add(customer1);
        customers.add(customer2);
    }

    public static LinkedList<Customer> getCustomers() {
        return customers;
    }
}
