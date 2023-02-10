package lesson30Home;

import java.util.Collection;
import java.util.LinkedList;

import static lesson30Home.DepartmentDAO.searchDepartment;
import static lesson30Home.EmployeeDAO.*;

public class Controller {

    public static Collection<Project> projectsByEmployee(Employee employee) throws Exception {

        Employee e = searchEmployee(employee);
        return e.getProjects();

    }

    public static LinkedList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        Department d = searchDepartment(departmentType);

        for (Employee e : d.getEmployees()) {
            if (e.getProjects().isEmpty()) {
                list.add(e);
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

        if (lead.getPosition() != Position.TEAM_LEAD) {
            throw new Exception("error : this employee is not a leader on this project.");
        }

        Employee l = searchEmployee(lead);

        for (Employee e : EmployeeDAO.getEmployees()) {
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

    public static LinkedList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        checkEmployee(employee);

        if (employee.getPosition() == Position.TEAM_LEAD) {
            throw new Exception("error : this employee is a manager.");
        }

        Employee e = searchEmployee(employee);

        for (Employee l : EmployeeDAO.getEmployees()) {
            if (!l.equals(e) && l.getPosition() == Position.TEAM_LEAD) {
                for (Project p : e.getProjects()){
                    if (l.getProjects().contains(p)){
                        list.add(l);
                    }
                }
            }
        }
        return list;
    }


    public static LinkedList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        LinkedList<Employee> list = new LinkedList<>();

        Employee e = searchEmployee(employee);

        checkProject(e);

        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (!emp.equals(e) && emp.getProjects().containsAll(e.getProjects())) {
                list.add(emp);
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
