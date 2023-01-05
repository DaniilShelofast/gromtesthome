package lesson30Home;

import java.util.Date;
import java.util.LinkedList;

public class EmployeeDAO {
    private static final LinkedList<Employee> employees = new LinkedList<>();

    public EmployeeDAO() {
        Department department = new Department(DepartmentType.ANALYSTS);
        Employee employee1 = new Employee("rrr", "rrr", new Date(), Position.ANALYST, department);

        Department department2 = new Department(DepartmentType.DESIGNERS);
        Employee employee2 = new Employee("ttt", "ttt", new Date(), Position.DESIGNER, department2);

        employees.add(employee1);
        employees.add(employee2);
    }

    public static LinkedList<Employee> getEmployees() {

        return employees;
    }


}
