package lesson30Home;

import java.util.LinkedList;

public class DepartmentDAO {
    static LinkedList<Employee> employees = new LinkedList<>();

    public LinkedList<Employee> getEmployees() {
        return employees;
    }


    public static Employee add(Employee employee) {

        employees.add(employee);

        return employee;
    }

    public static Employee update(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employee.getFirstName().equals(employees.get(i).getFirstName()) && employee.getLastName().equals(employees.get(i).getLastName()) && employee.getPosition().equals(employees.get(i).getPosition())) {
                employees.set(i, employee);
                return employee;
            }
        }
        return null;
    }

    public static void delete(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employee.getFirstName().equals(employees.get(i).getFirstName()) && employee.getLastName().equals(employees.get(i).getLastName()) && employee.getPosition().equals(employees.get(i).getPosition())) {
                employees.remove(i);
            }
        }

    }
}
