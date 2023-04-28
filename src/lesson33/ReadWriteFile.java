package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFile {

    public static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Reading from file" + path + "failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }

    public static void writeFile(String path) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("TTT");
            bufferedWriter.append("\n");
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }

    public static void writeToFileFromConsole(String path) {
        System.out.println("Enter file content to write in the file: ");

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(path);
        } catch (IOException e) {
            System.err.println("File with path " + path + " not found.");
            return;
        }
        BufferedWriter writer = new BufferedWriter(fileWriter);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            while (!(line = reader.readLine()).equals("wr")) {
                writer.append(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Can`t write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(writer);
        }
    }

    public static void readFileByConsolePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter file path to read : ");
        String path = scanner.nextLine();
        readFile(path);
    }
}
