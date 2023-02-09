package lesson30Home;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    private static final Set<Department> departments = new HashSet<>();

    static {
        Department department1 = new Department(DepartmentType.DESIGNERS);
        Department department2 = new Department(DepartmentType.ANALYSTS);

        Employee employee = new Employee("nnn", "aaa", new Date(105, 2, 5), Position.TEAM_LEAD, null);
        Employee employee1 = new Employee("ooo", "vvv", new Date(105, 1, 2), Position.ANALYST, null);
        Employee employee2 = new Employee("ggg", "iii", new Date(105, 3, 6), Position.DESIGNER, null);
        department2.getEmployees().add(employee);
        department2.getEmployees().add(employee1);
        department2.getEmployees().add(employee2);

        departments.add(department1);
        departments.add(department2);

    }

    public static Department searchDepartment(DepartmentType departmentType) throws Exception {
        for (Department department : getDepartments()) {
            if (department.getDepartmentType().equals(departmentType)) {
                return department;
            }
        }
        throw new Exception("error : this department does not exist.");
    }

    public static Set<Department> getDepartments() {
        return departments;
    }

}
