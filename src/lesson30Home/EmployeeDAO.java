package lesson30Home;

import java.util.Date;
import java.util.LinkedList;

public class EmployeeDAO {
    private static final LinkedList<Employee> employees = new LinkedList<>();

    public EmployeeDAO() {

        Employee employee1 = new Employee("rrr", "rrr", new Date(), Position.ANALYST, getEmployees().element().getDepartment());
        Employee employee2 = new Employee("ttt", "ttt", new Date(), Position.DESIGNER, getEmployees().element().getDepartment());

        employees.add(employee1);
        employees.add(employee2);
    }

    public static LinkedList<Employee> getEmployees() {

        return employees;
    }


}
