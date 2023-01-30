package lesson30Home;


import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Customer customer = new Customer("test", "test", "test", 100);
        Department department1 = new Department(DepartmentType.ANALYSTS);
        Department department2 = new Department(DepartmentType.MANAGEMENT);

        Employee employee1 = new Employee("rrr", "ppp", new Date(105, 5, 4), Position.DEVELOPER, department1);
        Employee employee2 = new Employee("hhh", "ttt", new Date(105, 5, 7), Position.FINANCE, department1);
        Employee employee3 = new Employee("sss", "lll", new Date(105, 3, 1), Position.MANAGER, department1);
        Employee employee4 = new Employee("nnn", "aaa", new Date(105, 2, 5), Position.FINANCE, department2);
        Employee employee5 = new Employee("ooo", "vvv", new Date(105, 1, 2), Position.ANALYST, department2);
        Employee employee6 = new Employee("ggg", "iii", new Date(105, 3, 6), Position.DESIGNER, department2);
        Project project = new Project("te", customer);


        System.out.println(Controller.employeesByProjectEmployee(employee1));

    }
}
