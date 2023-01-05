package lesson30Home;

import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounder;
    private static   Collection<Department> departments;
    private static Collection<Customer> customers;


    public Firm(Date dateFounder) {
        this.dateFounder = dateFounder;

    }

    public Date getDateFounder() {
        return dateFounder;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }
}
