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

    public static LinkedList<Employee> employeesByTeamLead(Employee lead) {
        //список подчиньоних для заданого керівника(по всім проектам, у яких він руководить)
        LinkedList<Employee> list = new LinkedList<>();

        for (Employee teamLead : EmployeeDAO.getEmployees()) {
            if (teamLead.equals(lead)) {

                for (Employee emp : EmployeeDAO.getEmployees()) {
                    if (!emp.getPosition().equals(teamLead.getPosition())) {
                        for (Project pr : teamLead.getProjects()) {
                            if (emp.getProjects().contains(pr)) {

                                list.add(emp);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public LinkedList<Employee> teamLeadsByEmployee(Employee employee) {
        LinkedList<Employee> list = new LinkedList<>();
        //список лідів для працівника( у всіх проектах у яких він працює )
        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (emp.equals(employee)) {

                for (Employee e : EmployeeDAO.getEmployees()) {
                    if (!e.equals(emp)) {
                        for (Project project : emp.getProjects()) {
                            if (e.getProjects().contains(project)) {

                                list.add(e);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }


    public LinkedList<Employee> employeesByProjectEmployee(Employee employee) {
        LinkedList<Employee> list = new LinkedList<>();
        //список працівників,працюючи на тих самих проектах,що заданий працівник.

        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (emp.equals(employee)) {

                for (Employee employees : EmployeeDAO.getEmployees()) {
                    for (Project project : emp.getProjects()) {
                        if (employees.getProjects().contains(project)) {
                            list.add(employee);
                        }
                    }
                }
            }
        }
        return list;
    }

    public LinkedList<Project> projectsByCustomer(Customer customer) {
        //список проектів. виповняємих для замовника
        LinkedList<Project> list = new LinkedList<>();

        for (Customer cus : CustomerDAO.getCustomers()) {
            if (cus.equals(customer)) {

                for (Project project : ProjectDAO.getProjects()) {
                    if (project.getCustomer().equals(cus)) {
                        list.add(project);
                    }
                }
            }
        }
        return list;
    }

    public LinkedList<Employee> employeesByCustomerProject(Customer customer) {
        //список працівників,участвующий в проектах,виконуючи для замовника
        LinkedList<Employee> list = new LinkedList<>();

        for (Customer custom : CustomerDAO.getCustomers()) {
            if (custom.equals(customer)) {

                for (Project project : ProjectDAO.getProjects()) {
                    if (project.getCustomer().equals(custom)) {
                        for (Employee employee : EmployeeDAO.getEmployees()) {
                            if (employee.getProjects().contains(project)) {
                                list.add(employee);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

}
