package lesson30Home;

import java.util.Date;


public class Demo {
    public static void main(String[] args) throws Exception {

        Customer customer = new Customer("test", "test", "test", 100);
        Department department1 = new Department(DepartmentType.MANAGEMENT);
        Employee employee1 = new Employee("rrr", "rrr", new Date(105, 5, 4), Position.TEAM_LEAD, department1);
        Employee employee2 = new Employee("aaa", "aaa", new Date(105, 5, 4), Position.DESIGNER, department1);
        Project project = new Project("te", customer);

        System.out.println(Controller.employeesByTeamLead(employee2));
        System.out.println(Controller.employeesByTeamLead(employee1));


    }
}
