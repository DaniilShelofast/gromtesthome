package lesson30Home;

import java.util.LinkedList;

public class Controller {

    private static final LinkedList<Project> employees = new LinkedList<>();

    public Employee projectsByEmployee(Employee employee) {
        Customer customer = new Customer("eee","eee","eee",100);
        Project project = new Project("rrr",customer);
        employees.add(project);
        return employee;
    }

    public DepartmentType employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        return null;
    }

    public Employee employeesWithoutProject() {
        return null;
    }

    public Employee employeesByTeamLead(Employee lead) {
        return null;
    }

    public Employee teamLeadsByEmployee(Employee employee) {
        return null;
    }

    public Employee employeesByProjectEmployee(Employee employee) {
        return null;
    }

    public Customer projectsByCustomer(Customer customer) {
        return null;
    }

    public Customer employeesByCustomerProject(Customer customer) {
        return null;
    }

}
