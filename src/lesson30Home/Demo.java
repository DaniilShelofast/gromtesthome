package lesson30Home;


import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        Department department1 = new Department(DepartmentType.ANALYSTS);
        Department department2 = new Department(DepartmentType.MANAGEMENT);
        Customer customer1 = new Customer("rrr", "ccc", "eee", 100);
        Customer customer2 = new Customer("test", "test", "test", 50);
        Customer customer3 = new Customer("X", "X", "test", 50);
        Project project1 = new Project("sss", customer1);
        Project project2 = new Project("test", customer2);
        Project project3 = new Project("www", customer1);

        Employee employee = new Employee("rrr", "ppp", new Date(105, 5, 4), Position.LEAD_DESIGNER, department1);
        Employee employee2 = new Employee("hhh", "ttt", new Date(105, 5, 7), Position.FINANCE, department1);
        Employee employee3 = new Employee("sss", "lll", new Date(105, 3, 1), Position.MANAGER, department1);
        Employee employee4 = new Employee("nnn", "aaa", new Date(105, 2, 5), Position.TEAM_LEAD, department2);
        Employee employee5 = new Employee("ooo", "vvv", new Date(105, 1, 2), Position.ANALYST, department2);
        Employee employee6 = new Employee("ggg", "iii", new Date(105, 3, 6), Position.DESIGNER, department2);
        employee.getProjects().add(project1);
        //employee.getProjects().add(project2);
        employee2.getProjects().add(project1);
        employee3.getProjects().add(project1);
        employee4.getProjects().add(project2);
        employee5.getProjects().add(project2);
        employee6.getProjects().add(project2);

        System.out.println(Controller.projectsByEmployee(employee));

    }
}
