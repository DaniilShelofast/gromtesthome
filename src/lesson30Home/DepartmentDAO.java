package lesson30Home;


import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    private static final Set<Department> departments = new HashSet<>();


    public DepartmentDAO() {
        Department department1 = new Department(DepartmentType.DESIGNERS);
        Department department2 = new Department(DepartmentType.ANALYSTS);

        departments.add(department1);
        departments.add(department2);


    }

    public static Set<Department> getDepartments() {
        return departments;
    }

}
