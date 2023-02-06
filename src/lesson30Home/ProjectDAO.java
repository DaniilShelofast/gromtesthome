package lesson30Home;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ProjectDAO {

    private static Set<Project> projects = new HashSet<>();

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



    public static Set<Project> getProjects() {
        return projects;
    }
}
