package lesson30Home;

import java.util.Collection;
import java.util.LinkedList;


import static lesson30Home.DepartmentDAO.searchDepartment;
import static lesson30Home.EmployeeDAO.*;
import static lesson30Home.CustomerDAO.findCustomer;

public class Controller {

    public static Collection<Project> projectsByEmployee(Employee employee) throws Exception {

        Employee e = searchEmployee(employee);
        return e.getProjects();

    }

    public static Collection<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {

        Department d = searchDepartment(departmentType);

        return findEmployeeWithoutProject(d.getEmployees());
    }

    public static Collection<Employee> employeesWithoutProject() throws Exception {

        return findEmployeeWithoutProject(getEmployees());
    }

    public static Collection<Employee> employeesByTeamLead(Employee lead) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        if (lead.getPosition() != Position.TEAM_LEAD) {
            throw new Exception("error : this employee is not a leader on this project.");
        }

        Employee l = searchEmployee(lead);
        for (Employee e : getEmployees()) {
            if (!e.equals(l)) {
                for (Project p : l.getProjects()) {
                    if (e.getProjects().contains(p)) {
                        list.add(e);
                        break;
                    }
                }
            }
        }
        return list;
    }

    public static Collection<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        if (employee.getPosition() == Position.TEAM_LEAD) {
            throw new Exception("error : this employee is a manager.");
        }

        Employee e = searchEmployee(employee);

        for (Employee l : EmployeeDAO.getEmployees()) {
            if (!l.equals(e) && l.getPosition() == Position.TEAM_LEAD) {
                for (Project p : e.getProjects()) {
                    if (l.getProjects().contains(p)) {
                        list.add(l);
                        break;
                    }
                }
            }
        }
        return list;
    }


    public static LinkedList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        Employee e = searchEmployee(employee);

        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (!emp.equals(e) && emp.getProjects().containsAll(e.getProjects())) {
                list.add(emp);
            }
        }
        return list;
    }

    public static LinkedList<Project> projectsByCustomer(Customer customer) throws Exception {
        LinkedList<Project> list = new LinkedList<>();

        Customer c = findCustomer(customer);

        for (Project project : ProjectDAO.getProjects()) {
            if (project.getCustomer().equals(c)) {
                list.add(project);
            }
        }
        return list;
    }

    public static LinkedList<Employee> employeesByCustomerProject(Customer customer) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        Customer c = findCustomer(customer);

        for (Project project : ProjectDAO.getProjects()) {
            if (project.getCustomer().equals(c)) {
                for (Employee employee : EmployeeDAO.getEmployees()) {
                    if (employee.getProjects().contains(project)) {
                        list.add(employee);
                    }
                }
            }
        }
        return list;
    }

    private static Collection<Employee> findEmployeeWithoutProject(Collection<Employee> employees) {
        Collection<Employee> list = new LinkedList<>();

        for (Employee e : employees) {
            if (e.getProjects().isEmpty()) {
                list.add(e);
            }
        }
        return list;
    }

}
