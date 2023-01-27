package lesson30Home;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class Firm {
    private Date dateFounder;
    private Collection<Department> departments;
    private Collection<Customer> customers;


    public Firm(Date dateFounder) {
        this.dateFounder = dateFounder;
        this.departments = new LinkedList<>();
        this.customers = new LinkedList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Firm firm = (Firm) o;
        return Objects.equals(dateFounder, firm.dateFounder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateFounder);
    }
}

