package lesson30Home;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


import static lesson30Home.DepartmentDAO.searchDepartment;
import static lesson30Home.EmployeeDAO.*;
import static lesson30Home.CustomerDAO.findCustomer;
import static lesson30Home.ProjectDAO.getProjects;

public class Controller {

    public static Collection<Project> projectsByEmployee(Employee employee) throws Exception {
        Employee foundEmployee = searchEmployee(employee);
        return foundEmployee.getProjects();

    }


    public static Collection<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        Department department = searchDepartment(departmentType);
        return findEmployeeWithoutProject(department.getEmployees());
    }


    public static Collection<Employee> employeesWithoutProject() {
        return findEmployeeWithoutProject(getEmployees());
    }


    public static Collection<Employee> employeesByTeamLead(Employee lead) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        if (lead.getPosition() != Position.TEAM_LEAD) {
            throw new Exception("error : this employee is not a leader on this project.");
        }

        Employee team = searchEmployee(lead);
        for (Employee employee : getEmployees()) {
            if (!employee.equals(team) && !Collections.disjoint(team.getProjects(), employee.getProjects())) {
                list.add(employee);
            }
        }
        return list;
    }

    public static Collection<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        if (employee.getPosition() == Position.TEAM_LEAD) {
            throw new Exception("error : this employee is a manager.");
        }

        Employee foundEmployee = searchEmployee(employee);
        for (Employee lead : getEmployees()) {
            if (!lead.equals(foundEmployee) && lead.getPosition() == Position.TEAM_LEAD && !Collections.disjoint(foundEmployee.getProjects(), lead.getProjects())) {
                list.add(lead);
            }
        }
        return list;
    }


    public static LinkedList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();
        Employee foundEmployee = searchEmployee(employee);
        for (Employee e : getEmployees()) {
            if (!e.equals(foundEmployee) && e.getProjects().containsAll(foundEmployee.getProjects())) {
                list.add(e);
            }
        }
        return list;
    }

    public static Collection<Project> projectsByCustomer(Customer customer) throws Exception {
        return foundCustomer(customer);
    }

    public static Collection<Employee> employeesByCustomerProject(Customer customer) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();
        for (Employee employee : getEmployees()) {
            if (employee.getProjects().containsAll(foundCustomer(customer))) {
                list.add(employee);
            }
        }
        return list;
    }

    private static Collection<Employee> findEmployeeWithoutProject(Collection<Employee> employees) {
        Collection<Employee> list = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee.getProjects().isEmpty()) {
                list.add(employee);
            }
        }
        return list;
    }

    private static Collection<Project> foundCustomer(Customer customer) throws Exception {
        Collection<Project> list = new LinkedList<>();
        Customer foundCustomer = findCustomer(customer);
        for (Project project : getProjects()) {
            if (project.getCustomer().equals(foundCustomer)) {
                list.add(project);
            }
        }
        return list;
    }
}
