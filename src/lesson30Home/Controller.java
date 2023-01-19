package lesson30Home;


import java.util.ArrayList;
import java.util.Collection;

public class Controller {


    public static Collection<Project> projectsByEmployee(Employee employee) throws Exception {


        for (Employee emp : EmployeeDAO.getEmployees()) {
            if (!emp.equals(employee)) {
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

        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee.getProjects() == lead) {
                list.add(employee);
            }
        }
        return list;

    }


    public Employee teamLeadsByEmployee(Employee employee) {
        return null;
    }

    public Employee employeesByProjectEmployee(Employee employee) {
        return null;
    }

    public ArrayList<Customer> projectsByCustomer(Customer customer) {
        //список проектів. виповняємих для замовника

        return null;
    }

    public Customer employeesByCustomerProject(Customer customer) {

        return null;
    }

}
