package lesson30Home;

import java.util.LinkedList;

public class DepartmentDAO {
    static LinkedList<Department> departments = new LinkedList<>();

    public LinkedList<Department> getEmployees() {
        return departments;
    }

    public DepartmentDAO() {
        Department department1 = new Department(DepartmentType.DESIGNERS);
        Department department2 = new Department(DepartmentType.ANALYSTS);

        departments.add(department1);
        departments.add(department2);
    }
}
