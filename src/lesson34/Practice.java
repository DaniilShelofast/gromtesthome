package lesson34;

import java.io.*;

public class Practice {
    public static void main(String[] args) throws Exception {
        copyFileContent("C:\\Users\\User\\Desktop/test.txt", "C:\\Users\\User\\Desktop/test1.txt");
    }

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        writerToFile(fileToPath, readFromFile(fileFromPath));
    }

    private static StringBuffer readFromFile(String path) {

        StringBuffer buffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }
            buffer.replace((buffer.length() - 1), buffer.length(), "");

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException ioException) {
            System.err.println("Reading from file " + path + " failed");
        }
        return buffer;
    }

    private static void writerToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append(contentToWrite);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist ");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permissions to read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileFrom + " does not have permissions to written");
        }
    }
}
