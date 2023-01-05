package lesson30Home;

import java.util.Collection;
import java.util.LinkedList;

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
}
