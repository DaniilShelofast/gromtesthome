package lesson30Home;


import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    private static final Set<Department> departments = new HashSet<>();

    static {
        Department department1 = new Department(DepartmentType.DESIGNERS);
        Department department2 = new Department(DepartmentType.ANALYSTS);

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
