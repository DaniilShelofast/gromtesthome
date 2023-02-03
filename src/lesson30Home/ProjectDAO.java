package lesson30Home;

import java.util.ArrayList;

public class ProjectDAO {

    private static ArrayList<Project> projects = new ArrayList<>();

    public ProjectDAO() {
        Customer customer1 = new Customer("rrr", "ccc", "eee", 100);
        Customer customer2 = new Customer("test", "test", "test", 50);

        Project project1 = new Project("sss", customer1);
        Project project2 = new Project("test", customer2);
        Project project3 = new Project("www", customer1);
        projects.add(project1);
        projects.add(project2);
       // projects.add(project3);

    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }
}
