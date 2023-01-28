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


        Employee employee1 = new Employee("rrr", "ppp", new Date(105, 5, 4), Position.MANAGER, department1);
        Employee employee2 = new Employee("hhh", "ttt", new Date(105, 5, 7), Position.DESIGNER, department2);
        Employee employee3 = new Employee("sss", "lll", new Date(105, 5, 1), Position.TEAM_LEAD, department2);
        employee1.getProjects().add(project1);
        employee2.getProjects().add(project2);
        employee3.getProjects().add(project2);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);


    }

    public static LinkedList<Employee> getEmployees() {

        return employees;
    }


}
