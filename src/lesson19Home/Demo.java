package lesson19Home;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

      /*  String[] formatsSupported = new String[1];
        formatsSupported[0] = "txt";
        File[] files = new File[3];
        files[0] = new File(146, "ccc", "txt", 3);
        files[1] = new File(14, "ccc", "txt", 2);
        files[2] = new File(1, "ccc", "txt", 2);

        File file = new File(14, "ccc", "txt", 2);
        Storage storage = new Storage(87, files, formatsSupported, "USA", 1000);
        // Controller.put(storage, file);
        //System.out.println(Arrays.deepToString(storage.getFiles()));
        Controller.delete(storage, file);
        System.out.println(Arrays.deepToString(storage.getFiles()));*/
        /*File file = new File(11, "cg", "txt", 2);
        File[] filesFrom = new File[4];
        filesFrom[0] = new File(10, "abc", "txt", 2);
        filesFrom[1] = new File(11, "cg", "txt", 1);
        filesFrom[2] = new File(111, "cg", "txt", 2);

        File[] filesTo = new File[4];
        filesTo[0] = new File(101, "ccc", "txt", 21);


        Storage storageFrom = new Storage(87, filesFrom, formatsSupported, "USA", 1000);
        Storage storageTo = new Storage(1200, filesTo, formatsSupported, "USA", 1200);

        //Controller.transferFile(storageFrom, storageTo, file.getId());
        Controller.transferAll(storageFrom, storageTo);

        System.out.println(Arrays.toString(storageFrom.getFiles()));
        System.out.println(Arrays.toString(storageTo.getFiles()));*/
    }
}

