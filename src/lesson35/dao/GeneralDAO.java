package lesson35.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneralDAO<T> {

    public String path;

    public void setPath(String path) {
        this.path = path;
    }

    public void addObjectTo(T t) {
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

}
