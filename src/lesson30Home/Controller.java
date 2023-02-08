package lesson30Home;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static lesson30Home.EmployeeDAO.searchEmployee;

public class Controller {

    public static Collection<Project> projectsByEmployee(Employee employee) throws Exception {

        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (emp.equals(employee)) {
                return emp.getProjects();
            }
        }
        throw new Exception("error : Project list not found, this employee. ");
    }

    public static LinkedList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        LinkedList<Employee> list = new LinkedList<>();

        for (Department department : DepartmentDAO.getDepartments()) {
            if (department.getDepartmentType().equals(departmentType)) {

                for (Employee emp : department.getEmployees()) {
                    if (emp.getProjects().isEmpty()) {
                        list.add(emp);
                    }
                }
            }
        }
        return list;
    }

    public static LinkedList<Employee> employeesWithoutProject() {
        LinkedList<Employee> list = new LinkedList<>();

        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee.getProjects().isEmpty()) {
                list.add(employee);
            }
        }
        return list;
    }

    public static LinkedList<Employee> employeesByTeamLead(Employee lead) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        checkPosition(lead);

        Employee e = null;
        for (Employee employee : EmployeeDAO.getEmployees()) {
            e = employee;
        }

        if (e == null) {
            throw new Exception("error : check the employee data.");
        }

        for (Employee l : EmployeeDAO.getEmployees()) {
            if (!l.equals(e)) {

                if (l.getProjects().containsAll(e.getProjects())) {
                    list.add(l);
                }
            }
        }
        return list;
    }

    public static LinkedList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        checkEmployee(employee);
        checkNotLeads(employee);

        for (Employee index : EmployeeDAO.getEmployees()) {
            if (index.getPosition() == Position.TEAM_LEAD) {
                for (Project project : index.getProjects()) {
                    if (index.getProjects().contains(project)) {
                        list.add(index);
                    }
                }
            }
        }
        return list;
    }


    public static LinkedList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();


        Employee e = null;
        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (emp.equals(employee)) {
                for (Project project : ProjectDAO.getProjects()) {
                    if (emp.getProjects().contains(project)) {
                        e = emp;
                        break;
                    }
                }
            }
        }

        if (e == null) {
            throw new Exception("error : the required employee was not found.");
        }

        checkProject(e);
        checkEmployee(e);

        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (!emp.equals(e)) {
                if (emp.getProjects().containsAll(e.getProjects())) {
                    list.add(emp);
                }
            }
        }
        return list;
    }

    public static LinkedList<Project> projectsByCustomer(Customer customer) throws Exception {
        LinkedList<Project> list = new LinkedList<>();

        checkCustomer(customer);

        for (Project project : ProjectDAO.getProjects()) {
            if (project.getCustomer().equals(customer)) {
                list.add(project);
            }
        }
        return list;
    }

    public static LinkedList<Employee> employeesByCustomerProject(Customer customer) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        checkCustomer(customer);

        for (Project project : ProjectDAO.getProjects()) {
            if (project.getCustomer().equals(customer)) {
                for (Employee employee : EmployeeDAO.getEmployees()) {
                    if (employee.getProjects().contains(project)) {
                        list.add(employee);
                    }
                }
            }
        }
        return list;
    }

    private static boolean checkEmployee(Employee employee) throws Exception {
        for (Employee e : EmployeeDAO.getEmployees()) {
            if (e.equals(employee)) {
                return true;
            }
        }
        throw new Exception("error : this employee does not exist in this list.");
    }

    private static boolean checkPosition(Employee lead) throws Exception {
        if (lead.getPosition() == Position.TEAM_LEAD) {
            return true;
        }
        throw new Exception("error : this employee is not a leader on this project.");
    }

    private static boolean checkNotLeads(Employee employee) throws Exception {
        if (employee.getPosition() == Position.DESIGNER || employee.getPosition() == Position.DEVELOPER || employee.getPosition() == Position.FINANCE
                || employee.getPosition() == Position.ANALYST || employee.getPosition() == Position.MANAGER || employee.getPosition() == Position.LEAD_DESIGNER) {
            return true;
        }
        throw new Exception("error : this employee is a manager.");
    }

    private static boolean checkProject(Employee employee) throws Exception {
        if (!employee.getProjects().isEmpty()) {
            return true;
        }
        throw new Exception("error : the project does not exist. ");
    }

    private static boolean checkCustomer(Customer customer) throws Exception {
        for (Customer c : CustomerDAO.getCustomers()) {
            if (c.equals(customer)) {
                return true;
            }
        }
        throw new Exception("error : the client does not have in the database.");
    }
}
