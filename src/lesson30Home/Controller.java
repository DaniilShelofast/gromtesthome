package lesson30Home;


import java.util.ArrayList;
import java.util.Collection;

public class Controller {


    public static Collection<Project> projectsByEmployee(Employee employee) throws Exception {


        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (emp.equals(employee)) {
                return emp.getProjects();
            }
        }
        throw new Exception("error : ");
    }


    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {

        ArrayList<Employee> list = new ArrayList<>();
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

    public static ArrayList<Employee> employeesWithoutProject() {

        ArrayList<Employee> list = new ArrayList<>();
        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee.getProjects().isEmpty()) {
                list.add(employee);
            }
        }
        return list;
    }

    public static ArrayList<Employee> employeesByTeamLead(Employee lead) {
        //список подчиньоних для заданого керівника(по всім проектам, у яких він руководить)
        ArrayList<Employee> list = new ArrayList<>();


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

    public ArrayList<Employee> teamLeadsByEmployee(Employee employee) {
        ArrayList<Employee> list = new ArrayList<>();
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


    public ArrayList<Employee> employeesByProjectEmployee(Employee employee) {
        ArrayList<Employee> list = new ArrayList<>();
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

    public ArrayList<Customer> projectsByCustomer(Customer customer) {
        //список проектів. виповняємих для замовника

        return null;
    }

    public Customer employeesByCustomerProject(Customer customer) {

        return null;
    }

}
