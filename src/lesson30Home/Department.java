package lesson30Home;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class Department {

    private DepartmentType departmentType;
    private Collection<Employee> employees;

    public Department(DepartmentType departmentType) {
        this.departmentType = departmentType;
        this.employees = new LinkedList<>();
    }


    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentType=" + departmentType +
                ", employees=" + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentType == that.departmentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentType);
    }
}
