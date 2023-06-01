package lesson34;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) throws Exception {
        transferSentences("C:\\Users\\User\\Desktop/test.txt", "C:\\Users\\User\\Desktop/test1.txt", "hello");
    }

    public static void transferSentences(String fileFrom, String fileTo, String keyword) throws Exception {
        validate(fileFrom, fileTo);

        Map<Integer, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        String line;
        line = readFile(fileFrom);

        Pattern pattern = Pattern.compile("[^\\.]+\\.");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            String sentence = matcher.group();
            if (sentence.contains(keyword) && sentence.length() > 10) {
                map.put(matcher.start(), sentence);
            } else {
                list.add(sentence);
            }
        }

        try (BufferedWriter writerTo = new BufferedWriter(new FileWriter(fileTo, true))) {
            for (String m : map.values()) {
                writerTo.append(m.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writerFrom = new BufferedWriter(new FileWriter(fileFrom))) {
            for (String l : list) {
                writerFrom.append(l.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileFrom) {
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileFrom))) {
            String s;
            while ((s = reader.readLine()) != null) {
                line += s + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
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
