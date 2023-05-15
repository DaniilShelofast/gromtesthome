package lesson34;



import java.io.*;

public class ReadWriteFile {


    public static void readFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException ioException) {
            System.err.println("Reading from file " + path + " failed");
        }
    }

    public static void writeFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path,true))) {
            bufferedWriter.append("TTT");
            bufferedWriter.append("\n");
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }
    }
}
