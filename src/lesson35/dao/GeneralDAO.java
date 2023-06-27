package lesson35.dao;

import java.io.*;
import java.util.LinkedList;

public class GeneralDAO<T> {

    private LinkedList<T> readFile;
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public void setReadFile(LinkedList<T> readFile) {
        this.readFile = readFile;
    }

    public void addObjectToFile(T t) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            File file = new File(path);
            if (file.length() == 0) {
                writer.write(((WriteToFile) t).toFileString());
            } else {
                writer.newLine();
                writer.write(((WriteToFile) t).toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteObjectFromFile(long id) throws Exception {
        LinkedList<T> objects = readFile;
        objects.removeIf(objectId -> (((WriteToFile) objectId).id()) == id);
        try (BufferedWriter ignore = new BufferedWriter(new FileWriter(path, false))) {
            for (T o : objects) {
                addObjectToFile(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> readFileText() {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
