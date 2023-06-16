package lesson35;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneralDAO {


    @SuppressWarnings("undchecked")
    public static <T extends WriteToFile> void addObjectToFile(T t, String pathFile, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile, append))) {
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
