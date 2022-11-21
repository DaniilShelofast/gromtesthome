package lesson19Home;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        String[] formatsSupported = new String[1];
        formatsSupported[0] = "txt";
        File file = new File(11, "dfd", "txt", 3);

        File[] filesFrom = new File[3];
        filesFrom[0] = new File(101, "abc", "txt", 2);

        File[] filesTo = new File[3];
        filesTo[0] = new File(10, "ccc", "txt", 21);

        Storage storageFrom = new Storage(87, filesFrom, formatsSupported, "USA", 1000);
        Storage storageTo = new Storage(1200, filesTo, formatsSupported, "USA", 1200);


        Test.transferFile(storageTo, storageFrom, storageFrom.getId());


        System.out.println(Arrays.toString(storageFrom.getFiles()));
        System.out.println(Arrays.toString(storageTo.getFiles()));
    }
}

