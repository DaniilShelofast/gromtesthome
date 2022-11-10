package lesson19Home;

public class Controller {


    public static void put(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null ) {
                storage.getFiles()[i] = file;
            }
        }
        formatCheck(storage, file);
        checkId(storage, file);
        checkSizeStorage(storage, file);
        freeSpace(storage);

    }

    private static boolean checkId(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() != file.getId()) {
                throw new Exception(" ID inappropriate!");
            }
        }
        return true;
    }

    private static boolean formatCheck(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (storage.getFormatsSupported()[i] != null && storage.getFormatsSupported()[i].equals(file.getFormat())) {
                return true;
            }
        }
        throw new Exception("Format inappropriate!");
    }

    private static boolean checkSizeStorage(Storage storage, File file) throws Exception {
        long sumaFiles = 0;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) {
                sumaFiles += storage.getFiles()[i].getSize();
            }
        }
        long value = storage.getStorageSize() - sumaFiles;
        if (value <= file.getSize()) {
            throw new Exception("Size inappropriate!");
        }
        return true;
    }

    private static boolean freeSpace(Storage storage) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
               return true;
            }
        }
         throw new Exception("not freely");

    }


    public static void delete(Storage storage, File file) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && file.getId() == storage.getFiles()[i].getId()) {
                storage.getFiles()[i] = null;

            }
        }
    }

}
