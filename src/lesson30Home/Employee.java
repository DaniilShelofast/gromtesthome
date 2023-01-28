package lesson30Home;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired ;
    private Position position;
    private Department department;
    private Collection<Project> projects;

    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = new Date(105, 5, 4);
        this.position = position;
        this.department = department;
        this.projects = new LinkedList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(dateHired, employee.dateHired) && position == employee.position && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateHired, position, department);
    }
}