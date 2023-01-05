package lesson30Home;


import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounder;
    private Collection<Department> departments;
    private Collection<Customer> customers;


    public Firm(Date dateFounder) {
        this.dateFounder = dateFounder;
        this.departments = departments;
        this.customers = customers;
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
