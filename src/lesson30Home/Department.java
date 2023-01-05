package lesson30Home;

import java.util.Collection;

public class Department {

    private static DepartmentType departmentType;
    private static Collection<Employee> employees;


    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }
}
