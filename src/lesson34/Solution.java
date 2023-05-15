package lesson34;

import java.io.*;

public class Solution {
    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        writerToFile(fileToPath, readFromFile(fileFromPath));
        delete(fileFromPath);
    }

    public static StringBuffer transferSentences(String fileFromPath, String fileToPath, String wordToCheck) throws Exception {
        validate(fileFromPath, fileToPath);
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileFromPath))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToPath))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuffer.append(line);
                }

                String strings = stringBuffer.toString();
                String[] string = strings.split("\\.");
                stringBuffer.setLength(0);
                for (String s : string) {
                    if (s.length() > 10 && s.contains(wordToCheck)) {
                        writer.append(s).append(".");
                        writer.newLine();
                    } else {
                        stringBuffer.append(s).append(".");
                    }
                }

                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileFromPath))) {
                    bufferedWriter.append(stringBuffer.toString());
                } catch (IOException e) {
                    System.out.println("Error.");
                }
            } catch (IOException e) {
                System.out.println("Error.");
            }
        } catch (IOException e) {
            System.out.println("Error.");
        }
        return stringBuffer;
    }

    private static StringBuffer readFromFile(String path)  {

        StringBuffer buffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }
            buffer.replace((buffer.length() - 1), buffer.length(), " ");

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException ioException) {
            System.err.println("Reading from file " + path + " failed");
        }
        return buffer;
    }

    private static void writerToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }
    }

    private static void delete(String path) throws Exception {
        PrintWriter p = new PrintWriter(path);
        p.close();
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
