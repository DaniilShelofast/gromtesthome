package lesson30Home;

import java.util.ArrayList;

public class ProjectDAO {

    private static ArrayList<Project> projects = new ArrayList<>();

    public ProjectDAO() {
        Project project1 = new Project("eee", new Customer("eee", "eee", "eee", 100));
        Project project2 = new Project("qqq", new Customer("qqq", "qqq", "qqq", 100));

        projects.add(project1);
        projects.add(project2);

    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }
}
