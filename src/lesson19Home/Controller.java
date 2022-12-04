package lesson19Home;

public class Controller {


    public static void put(Storage storage, File file) throws Exception {

        checkIdFile(storage, file);
        formatCheckFile(storage, file);
        checkSizeStorageFile(storage, file);
        freeSpaceFile(storage, file);
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                break;
            }

        }

    }
//
    public static void delete(Storage storage, File file) throws Exception {
        checkDeleteFile(storage, file);

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file) && storage.getFiles()[i].getName().equals(file.getName())) {
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

        if (file == null) {
            throw new Exception("error : the required file was not found! " + file);
        }

        checkIdFile(storageTo, file);
        formatCheckFile(storageTo, file);
        checkSizeStorageFile(storageTo, file);
        freeSpaceFile(storageTo, file);

        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if (storageTo.getFiles()[i] == null) {
                storageTo.getFiles()[i] = file;
                break;
            }

        }

        for (int j = 0; j < storageFrom.getFiles().length; j++) {
            if (storageFrom.getFiles()[j].equals(file) && storageFrom.getFiles()[j].getName().equals(file.getName())) {
                storageFrom.getFiles()[j] = null;
                break;
            }
        }

    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        checkIdStorageTo(storageFrom, storageTo);
        formatCheckStorageTo(storageFrom, storageTo);
        checkSizeStorageTo(storageFrom, storageTo);
        freeSpaceStorageTo(storageFrom, storageTo);

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            for (int j = 0; j < storageTo.getFiles().length; j++) {
                if (storageTo.getFiles()[j] == null) {
                    storageTo.getFiles()[j] = storageFrom.getFiles()[i];
                    break;
                }
            }
        }

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            for (int j = 0; j < storageTo.getFiles().length; j++) {
                if (storageFrom.getFiles()[i] != null && storageTo.getFiles()[j] != null) {
                    storageFrom.getFiles()[i] = null;
                    break;
                }
            }
        }


    }


    private static boolean checkIdFile(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == file.getId()) {
                throw new Exception("error : ID inappropriate " + file.getId() + " before this " + storage.getId());
            }
        }
        return true;
    }

    private static boolean formatCheckFile(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (storage.getFormatsSupported()[i] != null && storage.getFormatsSupported()[i].equals(file.getFormat())) {
                return true;
            }
        }
        throw new Exception("error : format inappropriate " + file.getId() + " before this " + storage.getId());
    }


    private static boolean checkSizeStorageFile(Storage storage, File file) throws Exception {
        long sumaFiles = 0;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) {
                sumaFiles += storage.getFiles()[i].getSize();
            }
        }
        long value = storage.getStorageSize() - sumaFiles;
        if (value <= file.getSize()) {
            throw new Exception(" error : size inappropriate " + file.getId() + " before this " + storage.getId());
        }
        return true;
    }

    private static boolean freeSpaceFile(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                return true;
            }
        }
        throw new Exception("error : not freely " + file.getId() + " before this " + storage.getId());
    }

    private static boolean checkDeleteFile(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == file.getId()) {

                return true;
            }
        }
        throw new Exception("error : cannot be deleted, there is no file with this ID " + file.getId() + " from storage " + storage.getId());
    }

    private static boolean checkIdStorageTo(Storage storageFrom, Storage storageTo) throws Exception {

        for (int j = 0; j < storageFrom.getFiles().length; j++) {
            for (int i = 0; i < storageTo.getFiles().length; i++) {
                if (storageFrom.getFiles()[j] != null && storageTo.getFiles()[i] != null && storageFrom.getFiles()[j].getId() == storageTo.getFiles()[i].getId()) {
                    throw new Exception("error :these files corresponds ID,the transfer is invalid. " + storageTo.getId());
                }
            }
        }
        return true;
    }

    private static boolean formatCheckStorageTo(Storage storageFrom, Storage storageTo) throws Exception {

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            for (int j = 0; j < storageTo.getFormatsSupported().length; j++) {
                if (storageTo.getFormatsSupported()[j] != null && storageFrom.getFiles()[i] != null && !storageFrom.getFiles()[i].getFormat().equals(storageTo.getFormatsSupported()[j])) {
                    throw new Exception("error : the format of these files is not appropriate,the transfer is invalid. " + storageTo.getId());

                }
            }

        }

        return true;
    }

    private static boolean checkSizeStorageTo(Storage storageFrom, Storage storageTo) throws Exception {

        storageFrom.calculateUsedSize();

        long sumaFilesTo = 0;
        for (int j = 0; j < storageTo.getFiles().length; j++) {
            if (storageTo.getFiles()[j] != null) {
                sumaFilesTo += storageTo.getFiles()[j].getSize();
            }
        }

        long valueTo = storageTo.getStorageSize() - sumaFilesTo;

        if (storageFrom.calculateUsedSize() <= valueTo) {
            return true;
        }
        throw new Exception("error :size is not enough,the transfer is invalid. " + storageTo.getId());
    }

    private static boolean freeSpaceStorageTo(Storage storageFrom, Storage storageTo) throws Exception {
        int add = 0;
        for (int j = 0; j < storageFrom.getFiles().length; j++) {
            if (storageFrom.getFiles()[j] != null) {
                add++;
            }
        }
        int increaseEmpty = 0;
        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if (storageTo.getFiles()[i] == null) {
                increaseEmpty++;
            }
        }

        if (add <= increaseEmpty) {
            return true;
        }

        throw new Exception("error :there is no free space, the transfer is invalid. " + storageTo.getId());
    }

}



