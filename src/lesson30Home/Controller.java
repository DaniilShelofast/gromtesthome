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
        LinkedList<Employee> employees = new LinkedList<>();

        if (lead.getPosition() != Position.TEAM_LEAD) {
            throw new Exception("error : this employee is not a leader on this project.");
        }

        Employee foundLead = searchEmployee(lead);
        for (Employee employee : getEmployees()) {
            if (!employee.equals(foundLead) && !Collections.disjoint(foundLead.getProjects(), employee.getProjects())) {
                employees.add(employee);
            }
        }
        return employees;
    }

    public static Collection<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        LinkedList<Employee> teamLeads = new LinkedList<>();

        if (employee.getPosition() == Position.TEAM_LEAD) {
            throw new Exception("error : this employee is a manager.");
        }

        Employee foundEmployee = searchEmployee(employee);
        for (Employee lead : getEmployees()) {
            if (!lead.equals(foundEmployee) && lead.getPosition() == Position.TEAM_LEAD && !Collections.disjoint(foundEmployee.getProjects(), lead.getProjects())) {
                teamLeads.add(lead);
            }
        }
        return teamLeads;
    }


    public static LinkedList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        LinkedList<Employee> employees = new LinkedList<>();
        Employee foundEmployee = searchEmployee(employee);
        for (Employee e : getEmployees()) {
            if (!e.equals(foundEmployee) && e.getProjects().containsAll(foundEmployee.getProjects())) {
                employees.add(e);
            }
        }
        return employees;
    }

    public static Collection<Project> projectsByCustomer(Customer customer) throws Exception {
        return findProjectsByCustomer(customer);
    }

    public static Collection<Employee> employeesByCustomerProject(Customer customer) throws Exception {
        LinkedList<Employee> employees = new LinkedList<>();

        Collection<Project> customerProjects = findProjectsByCustomer(customer);
        for (Employee employee : getEmployees()) {
            if (!Collections.disjoint(employee.getProjects(), customerProjects)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    private static Collection<Employee> findEmployeeWithoutProject(Collection<Employee> employees) {
        Collection<Employee> employeesWithoutProjects = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee.getProjects().isEmpty()) {
                employeesWithoutProjects.add(employee);
            }
        }
        return employeesWithoutProjects;
    }

    private static Collection<Project> findProjectsByCustomer(Customer customer) throws Exception {
        Collection<Project> projects = new LinkedList<>();
        Customer foundCustomer = findCustomer(customer);
        for (Project project : getProjects()) {
            if (project.getCustomer().equals(foundCustomer)) {
                projects.add(project);
            }
        }
        return projects;
    }
}
