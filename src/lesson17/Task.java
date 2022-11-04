package lesson17;

import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        VideoStorage videoStorage = new VideoStorage();
        String[] videoNames = {"test1", "test2", "test3", "test4", "test5", "test6"};
        videoStorage.setFiles(videoNames);

        System.out.println("Start printing name...");

        printerTwo(videoStorage);

        System.out.println("Done");
    }

    public static void printer(Storage storage) {
        String[] names = storage.getFiles();
        try {
            System.out.println("5th name is" + names[4]);
        } catch (Exception e) {
            System.err.println("5th name can not be found..");
            //System.err.println(e.getMessage());
        }

    }

    public static void printerTwo(Storage storage) {
        String[] names = storage.getFiles();
        for (int i = 0; i < names.length; i++)
            if (names[i].equals(names[4])) {
                System.out.println("5th name is " + names[4]);
            } else {

                System.err.println("5th name can not be found..");

            }


    }
}
