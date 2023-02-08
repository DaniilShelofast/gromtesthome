package lesson30Home;

import java.util.Date;
import java.util.LinkedList;

public class EmployeeDAO {
    private static final LinkedList<Employee> employees = new LinkedList<>();

    public EmployeeDAO() {
        Customer customer1 = new Customer("rrr", "ccc", "eee", 100);
        Customer customer2 = new Customer("test", "test", "test", 50);
        Customer customer3 = new Customer("test", "test", "ooo", 150);

        Project project1 = new Project("sss", customer1);
        Project project2 = new Project("test", customer2);
        Project project3 = new Project("test", customer3);
        Department department1 = new Department(DepartmentType.ANALYSTS);
        Department department2 = new Department(DepartmentType.MANAGEMENT);

        Employee employee = new Employee("rrr", "ppp", new Date(105, 5, 4), Position.TEAM_LEAD, department1);
        Employee employee2 = new Employee("hhh", "ttt", new Date(105, 5, 7), Position.FINANCE, department1);
        Employee employee3 = new Employee("sss", "lll", new Date(105, 3, 1), Position.MANAGER, department1);
        Employee employee4 = new Employee("nnn", "aaa", new Date(105, 2, 5), Position.TEAM_LEAD, department2);
        Employee employee5 = new Employee("ooo", "vvv", new Date(105, 1, 2), Position.ANALYST, department2);
        Employee employee6 = new Employee("ggg", "iii", new Date(105, 3, 6), Position.DESIGNER, department2);

        employee.getProjects().add(project1);
        employee2.getProjects().add(project1);
        employee3.getProjects().add(project1);
        employee4.getProjects().add(project2);
        employee5.getProjects().add(project2);
        employee6.getProjects().add(project2);

        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);


    }

    public static Employee searchEmployee(Employee employee) throws Exception {

        for (Employee e : getEmployees()) {
            if (e.equals(employee)) {
                return e;
            }
        }
        throw new Exception("error : not found in the database.");
    }

    public static Employee searchEmployeeAndProject(Employee employee) throws Exception {

        for (Employee e : getEmployees()) {
            if (e.equals(employee)) {
                for (Project project : ProjectDAO.getProjects()) {
                    if (e.getProjects().contains(project)) {
                        return e;
                    }
                }
            }
        }
        throw new Exception("error : not found in the database.");
    }


    public static LinkedList<Employee> getEmployees() {

        return employees;
    }


}
