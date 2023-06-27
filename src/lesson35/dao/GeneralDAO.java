package lesson35.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class GeneralDAO<T> {

    private LinkedList<T> readFile;

    public void setReadFile(LinkedList<T> readFile) {
        this.readFile = readFile;
    }

    public void addObjectToFile(T t, String path) {
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

    public void deleteObjectFromFile(long id, String path) throws Exception {
        LinkedList<T> objects = readFile;
        objects.removeIf(objectId -> (((WriteToFile) objectId).id()) == id);
        try (BufferedWriter ignore = new BufferedWriter(new FileWriter(path, false))) {
            for (T o : objects) {
                addObjectToFile(o, path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
