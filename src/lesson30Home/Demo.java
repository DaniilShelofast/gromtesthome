package lesson30Home;

import java.util.Date;


public class Demo {
    public static void main(String[] args) throws Exception {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Customer customer = new Customer("test", "test", "tets", 100);
        Department department1 = new Department(DepartmentType.MANAGEMENT);
        Employee employee1 = new Employee("rrr", "rrr", new Date(), Position.MANAGER, department1);
        Project project = new Project("tets", customer);
        Controller.employeesByTeamLead(employee1);
        System.out.println(EmployeeDAO.getEmployees());


    }
}
