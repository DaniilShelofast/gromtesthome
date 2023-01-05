package lesson30Home;

import java.util.LinkedList;

public class FirmDAO {

    static LinkedList<Customer> firms = new LinkedList<>();

    public static LinkedList<Customer> getFirms() {
        return firms;
    }

    public static Customer add(Customer customer) {

        firms.add(customer);

        return customer;
    }


    public static Customer update(Customer customer) throws Exception {

        for (int i = 0; i < firms.size(); i++) {
            if (customer.getCountry().equals(firms.get(i).getCountry()) && customer.getFirstName().equals(firms.get(i).getFirstName()) && customer.getLastName().equals(firms.get(i).getLastName())) {
                firms.set(i, customer);

                return customer;
            }

        }
        return null;

    }

    public static void delete(Customer customer) {

        for (int i = 0; i < firms.size(); i++) {
            if (customer.getCountry().equals(firms.get(i).getCountry()) && customer.getFirstName().equals(firms.get(i).getFirstName()) && customer.getLastName().equals(firms.get(i).getLastName())) {
                firms.remove(i);
            }
        }
    }


}
