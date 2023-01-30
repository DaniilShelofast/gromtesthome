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
        //список працівників, виконуючи роботу на тих самих проєктах, що і заданий працівник.

        checkEmployee(employee);
        checkNotLeads(employee);

        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (!emp.equals(employee)) {

                for (Project project : emp.getProjects()){
                    if (emp.getProjects().contains(project)){
                        list.add(emp);
                    }
                }
            }
        }
        return list;
    }

    public LinkedList<Project> projectsByCustomer(Customer customer) throws Exception {
        //перелік проєктів для замовника.
        LinkedList<Project> list = new LinkedList<>();

        for (Customer cus : CustomerDAO.getCustomers()) {
            if (cus.equals(customer)) {

                for (Project project : ProjectDAO.getProjects()) {
                    if (project.getCustomer().equals(cus)) {
                        list.add(project);
                        return list;
                    }
                }
            }
        }
        throw new Exception("error");
    }

    public LinkedList<Employee> employeesByCustomerProject(Customer customer) throws Exception {
        //список працівників,участвующий в проектах,виконуючи для замовника
        LinkedList<Employee> list = new LinkedList<>();

        for (Customer custom : CustomerDAO.getCustomers()) {
            if (custom.equals(customer)) {

                for (Project project : ProjectDAO.getProjects()) {
                    if (project.getCustomer().equals(custom)) {
                        for (Employee employee : EmployeeDAO.getEmployees()) {
                            if (employee.getProjects().contains(project)) {
                                list.add(employee);
                                return list;
                            }
                        }
                    }
                }
            }
        }
        throw new Exception("error");
    }

    private static boolean checkEmployee(Employee employee) throws Exception {
        for (Employee employee1 : EmployeeDAO.getEmployees()) {
            if (employee1.equals(employee)) {
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

}
