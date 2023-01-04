package lesson30Home;

import java.util.Collection;

public class Department {

    private DepartmentType departmentType;
    private Collection<Employee> employees;

    public Department(DepartmentType departmentType, Collection<Employee> employees) {
        this.departmentType = departmentType;
        this.employees = employees;
    }


}
