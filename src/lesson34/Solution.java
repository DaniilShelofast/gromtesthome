package lesson34;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Solution {

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {
        FileUtils.copyFile(new File(fileFromPath), new File(fileToPath));
    }

    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        writerToFile(fileToPath, readFromFile(fileFromPath));
        deleteTextFile(fileFromPath);
    }

    public static void transferSentences(String fileFromPath, String fileToPath, String wordToCheck) throws Exception {
        validate(fileFromPath, fileToPath);

        String fileFrom;
        fileFrom = String.valueOf(readFromFile(fileFromPath));

        String[] string = fileFrom.split("\\.");
        fileFrom = "";
        for (String s : string) {
            if (s.length() > 10 && s.contains(wordToCheck)) {
                writerToFile(fileToPath, s + ".");
            } else {
                fileFrom += s + ".";
            }
        }
        overwritingFile(fileFromPath, fileFrom);
    }

    private static void overwritingFile(String string, String fileFrom) {
        try (BufferedWriter remainingWriter = new BufferedWriter(new FileWriter(string))) {
            remainingWriter.write(fileFrom);
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }

    private static String readFromFile(String path) {
        String string = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                string += line + "\n";
            }

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException ioException) {
            System.err.println("Reading from file " + path + " failed");
        }
        return string;
    }

    private static void writerToFile(String path, String contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }
    }

    private static void deleteTextFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("");
        } catch (IOException e) {
            System.out.println("Error.");
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
