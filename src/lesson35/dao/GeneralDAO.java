package lesson35.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneralDAO {

    public static <T extends WriteToFile> void addObjectToFile(T t, String pathFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile, true))) {
            File line = new File(pathFile);
            if (line.length() == 0) {
                writer.write(t.toFileString());
            } else {
                writer.newLine();
                writer.write(t.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
