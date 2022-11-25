package lesson19Home;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        String[] formatsSupported = new String[1];
        formatsSupported[0] = "txt";
        // File file = new File(10, "dfd", "txt", 2);

        File[] filesFrom = new File[4];
        filesFrom[0] = new File(10, "abc", "txt", 2);
        filesFrom[1] = new File(11, "cg", "txt", 1);
        filesFrom[2] = new File(113, "cg", "txt", 13);

        File[] filesTo = new File[4];
        filesTo[0] = new File(101, "ccc", "txt", 21);


        Storage storageFrom = new Storage(87, filesFrom, formatsSupported, "USA", 1000);
        Storage storageTo = new Storage(1200, filesTo, formatsSupported, "USA", 1200);

        // Controller.transferFile(storageFrom, storageTo, file.getId());
        TransferAll.transferAll(storageFrom, storageTo);

        System.out.println(Arrays.toString(storageFrom.getFiles()));
        System.out.println(Arrays.toString(storageTo.getFiles()));
    }
}

