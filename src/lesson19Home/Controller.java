package lesson19Home;

import java.util.Arrays;

public class Controller {
    public static void main(String[] args) {


        File file = new File(122, "abc", "txt", 128);
        String[] formatsSupported = new String[1];
        formatsSupported[0] = "txt";
        File[] files = new File[0];
        Storage storage = new Storage(33, files, formatsSupported, "USA", 128);
        put(storage, file);


        System.out.println(Arrays.toString(storage.getFiles()));
    }

    public static void put(Storage storage, File file) {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null || checkId(storage, file) && formatCheck(storage, file) && checkSizeStorage(storage, file) && freeSpace(storage)) {
                storage.getFiles()[i] = file;

            }
        }
    }

    private static boolean checkId(Storage storage, File file) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == file.getId()) {
                return false;
            }
        }
        return true;
    }

    private static boolean formatCheck(Storage storage, File file) {
        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (storage.getFormatsSupported()[i] != null && storage.getFormatsSupported()[i] != file.getFormat()) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkSizeStorage(Storage storage, File file) {
        if (storage.getStorageSize() != file.getSize()) {
            return false;
        }
        return true;
    }

    public static boolean freeSpace(Storage storage) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                return true;
            }
        }
        return false;
    }


    public static void delete(Storage storage, File file) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && file.getId() == storage.getFiles()[i].getId()) {
                storage.getFiles()[i] = null;

            }
        }
    }

}
