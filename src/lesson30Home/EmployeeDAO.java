package lesson30Home;

import java.util.Date;
import java.util.LinkedList;

public class EmployeeDAO {
    private static final LinkedList<Employee> employees = new LinkedList<>();

    public EmployeeDAO() {
        Project project1 = new Project("eee", new Customer("eee", "eee", "eee", 100));
        Project project2 = new Project("test", new Customer("test", "test", "test", 50));

        Department department1 = new Department(DepartmentType.ANALYSTS);
        Department department2 = new Department(DepartmentType.MANAGEMENT);

        Employee employee1 = new Employee("rrr", "ppp", new Date(105, 5, 4), Position.ANALYST, department1);
        Employee employee4 = new Employee("nnn", "aaa", new Date(105, 2, 5), Position.TEAM_LEAD, department1);
        Employee employee2 = new Employee("hhh", "ttt", new Date(105, 5, 7), Position.FINANCE, department2);
        Employee employee3 = new Employee("sss", "lll", new Date(105, 3, 1), Position.TEAM_LEAD, department2);

        employee1.getProjects().add(project1);
        employee4.getProjects().add(project1);
        employee2.getProjects().add(project1);
        employee3.getProjects().add(project1);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);


    }

    public static LinkedList<Employee> getEmployees() {

        return employees;
    }


}
