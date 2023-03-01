package lesson30Home;

import java.util.HashSet;
import java.util.Set;

public class CustomerDAO {
    private static final Set<Customer> customers = new HashSet<>();

    static {
        Customer customer1 = new Customer("rrr", "ccc", "eee", 100);
        Customer customer2 = new Customer("test", "test", "test", 50);

        customers.add(customer1);
        customers.add(customer2);
    }

    public static Customer findCustomer(Customer customer) throws Exception {
        for (Customer c : getCustomers()) {
            if (c.equals(customer)) {
                return c;
            }
        }
        throw new Exception("error : the client does not have in the database.");
    }

    public static Set<Customer> getCustomers() {
        return customers;
    }
}
