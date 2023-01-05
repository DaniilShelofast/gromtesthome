package lesson30Home;

import java.util.Collection;

public class Department {

    private DepartmentType departmentType;
    private static Collection<Employee> employees;

    public Department(DepartmentType departmentType) {
        this.departmentType = departmentType;

    }


    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }
}
