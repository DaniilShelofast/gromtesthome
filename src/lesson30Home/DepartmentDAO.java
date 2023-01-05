package lesson30Home;

import java.util.LinkedList;

public class DepartmentDAO {
    private static final LinkedList<Department> departments = new LinkedList<>();


    public DepartmentDAO() {
        Department department1 = new Department(DepartmentType.DESIGNERS);
        Department department2 = new Department(DepartmentType.ANALYSTS);

        departments.add(department1);
        departments.add(department2);
    }

    public static LinkedList<Department> getEmployees() {
        return departments;
    }

}
