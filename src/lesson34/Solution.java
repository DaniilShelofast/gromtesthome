package lesson34;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Solution {


    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {
        FileUtils.copyFile(new File(fileFromPath), new File(fileToPath));
    }

    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        writerToFile(fileToPath, readFromFile(fileFromPath), true);
        writerToFile(fileFromPath, "", false);
    }

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        writerToFile(fileToPath, readFromFile(fileFromPath), true);
    }

    public static void transferSentences(String fileFromPath, String fileToPath, String wordToCheck) throws Exception {
        validate(fileFromPath, fileToPath);

        String fileFrom;
        fileFrom = readFromFile(fileFromPath);

        String[] string = fileFrom.split("\\.");
        fileFrom = "";
        for (String s : string) {
            if (s.length() > 10 && s.contains(wordToCheck)) {
                writerToFile(fileToPath, s + ".", true);
            } else {
                fileFrom += s + ".";
            }
        }
        writerToFile(fileFromPath, fileFrom, false);
    }

    private static void writerToFile(String path, String contentToWrite, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            File line = new File(path);
            if (line.length() == 0) {
                bufferedWriter.append(contentToWrite);
            } else {
                bufferedWriter.newLine();
                bufferedWriter.append(contentToWrite);
            }
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }


    private static String readFromFile(String path) {
        StringBuilder string = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                string.append(line).append("\n");
            }
            if (!string.isEmpty()) {
                string.replace(string.length() - 1, string.length(), "");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException ioException) {
            System.err.println("Reading from file " + path + " failed");
        }
        return string.toString();
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
