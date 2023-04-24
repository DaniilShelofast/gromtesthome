package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) throws InterruptedException {
        readFile("C:\\Users\\User\\Desktop/test.txt");
        writeFile("C:\\Users\\User\\Desktop/test1.txt");
    }

    private static void readFile(String path) {
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

    private static void writeFile(String path) throws InterruptedException {
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
}
