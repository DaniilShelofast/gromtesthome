package lesson30Home;

import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounder;
    private Collection<Department> departments;
    private Collection<Customer> customers;

    public Firm(Date dateFounder, Collection<Department> departments, Collection<Customer> customers) {
        this.dateFounder = dateFounder;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounder() {
        return dateFounder;
    }

    public void setDateFounder(Date dateFounder) {
        this.dateFounder = dateFounder;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

}
