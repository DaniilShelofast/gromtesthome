package lesson30Home;

import java.util.Collection;
import java.util.LinkedList;

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
        checkEmployee(lead);

        for (Employee teamLead : EmployeeDAO.getEmployees()) {
            if (!teamLead.equals(lead)) {
                for (Project pr : teamLead.getProjects()) {
                    if (teamLead.getProjects().contains(pr)) {
                        list.add(teamLead);

                    }
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
            if (index.getPosition() == Position.TEAM_LEAD || index.getPosition() == Position.LEAD_DESIGNER) {
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

        checkEmployee(employee);
        checkProject(employee);

        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (!emp.equals(employee)) {
                if (emp.getProjects().containsAll(employee.getProjects())) {
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
        if (lead.getPosition() == Position.TEAM_LEAD || lead.getPosition() == Position.LEAD_DESIGNER) {
            return true;
        }
        throw new Exception("error : this employee is not a leader on this project.");
    }

    private static boolean checkNotLeads(Employee employee) throws Exception {
        if (employee.getPosition() == Position.DESIGNER || employee.getPosition() == Position.DEVELOPER || employee.getPosition() == Position.FINANCE
                || employee.getPosition() == Position.ANALYST || employee.getPosition() == Position.MANAGER) {
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

   /* private static boolean checkProjectCustomer(Customer customer) throws Exception {
        for (Project project : ProjectDAO.getProjects()) {
            if (project.getCustomer().equals(customer)) {
                return true;
            }
        }
        throw new Exception("error : the client has no projects.");
    }*/


}
