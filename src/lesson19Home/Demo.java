package lesson19Home;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        File file = new File(122, "abc", "txt", 12);
        String[] formatsSupported = new String[1];
        formatsSupported[0] = "txt";
        File[] files = new File[2];
        Storage storage = new Storage(122, files, formatsSupported, "USA", 120);
        Controller.put(storage, file);
        System.out.println(Arrays.toString(storage.getFiles()));
        Controller.delete(storage,file);
        System.out.println(Arrays.toString(storage.getFiles()));


    }
}
