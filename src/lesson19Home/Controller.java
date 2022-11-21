package lesson19Home;

public class Controller {


    public static void put(Storage storage, File file) throws Exception {

        checkId(storage, file);
        formatCheck(storage, file);
        checkSizeStorage(storage, file);
        freeSpace(storage);
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                break;

            }

        }

    }

    public static void delete(Storage storage, File file) {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i].getId() == file.getId() && storage.getFiles()[i].getName().equals(file.getName())) {
                storage.getFiles()[i] = null;
                break;

            }
        }
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        File file = null;
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (storageFrom.getFiles()[i] != null && storageFrom.getFiles()[i].getId() == id) {
                file = storageFrom.getFiles()[i];
                break;
            }
        }

        checkId(storageTo, file);
        formatCheck(storageTo, file);
        checkSizeStorage(storageTo, file);
        freeSpace(storageTo);

        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if ( storageTo.getFiles()[i] == null) {
                storageTo.getFiles()[i] = file;


            }
        }

        for (int j = 0; j < storageFrom.getFiles().length; j++) {
            if (file != null && storageFrom.getFiles()[j].getId() == file.getId() && storageFrom.getFiles()[j].getName().equals(file.getName())) {
                storageFrom.getFiles()[j] = null;


            }
        }

    }


    private static boolean checkId(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (file != null && storage.getFiles()[i] != null && storage.getFiles()[i].getId() != file.getId()) {
                throw new Exception(" ID inappropriate!");
            }
        }
        return true;
    }

    private static boolean formatCheck(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat() != null && storage.getFormatsSupported()[i] != null && storage.getFormatsSupported()[i].equals(file.getFormat())) {
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
        if (file != null && value <= file.getSize()) {
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
        throw new Exception("Not freely..!");

    }


}


