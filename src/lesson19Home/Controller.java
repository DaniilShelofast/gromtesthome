package lesson19Home;

public class Controller {


    public static void put(Storage storage, File file) throws Exception {

        checkIdFile(storage, file);
        formatCheckFile(storage, file);
        checkSizeStorageFile(storage, file);
        freeSpaceFile(storage, file);

        storage.addFile(file);

    }


    public static void delete(Storage storage, File file) throws Exception {
        checkDeleteFile(storage, file);

        storage.delete(file);
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        File file = null;
        for (File f : storageFrom.getFiles()) {
            if (storageFrom.getFiles() != null && f.getId() == id) {
                file = f;
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

        storageTo.addFile(file);

        storageFrom.delete(file);

    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        checkIdStorageTo(storageFrom, storageTo);
        formatCheckStorageTo(storageFrom, storageTo);
        checkSizeStorageTo(storageFrom, storageTo);
        freeSpaceStorageTo(storageFrom, storageTo);

        for (int i = 0; i < storageFrom.getFiles().length; i++) {

            storageTo.addFile(storageFrom.getFiles()[i]);
        }

        for (int i = 0; i < storageFrom.getFiles().length; i++) {

            storageFrom.delete(storageFrom.getFiles()[i]);
        }

    }


    private static boolean checkIdFile(Storage storage, File file) throws Exception {
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == file.getId()) {
                throw new Exception("error : ID inappropriate " + file.getId() + " before this " + storage.getId());
            }
        }
        return true;
    }

    private static boolean formatCheckFile(Storage storage, File file) throws Exception {
        for (String fileFormat : storage.getFormatsSupported()) {
            if (fileFormat != null && fileFormat.equals(file.getFormat())) {
                return true;
            }
        }
        throw new Exception("error : format inappropriate " + file.getId() + " before this " + storage.getId());
    }


    private static boolean checkSizeStorageFile(Storage storage, File file) throws Exception {
        long sumaFiles = 0;
        for (File f : storage.getFiles()) {
            if (f != null) {
                sumaFiles += f.getSize();
            }
        }
        long value = storage.getStorageSize() - sumaFiles;
        if (value <= file.getSize()) {
            throw new Exception(" error : size inappropriate " + file.getId() + " before this " + storage.getId());
        }
        return true;
    }

    private static boolean freeSpaceFile(Storage storage, File file) throws Exception {
        for (File f : storage.getFiles()) {
            if (f == null) {
                return true;
            }
        }
        throw new Exception("error : not freely " + file.getId() + " before this " + storage.getId());
    }

    private static boolean checkDeleteFile(Storage storage, File file) throws Exception {
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == file.getId() && f.getName().equals(file.getName())) {
                return true;
            }
        }
        throw new Exception("error : cannot be deleted, there is no file with this ID " + file.getId() + " from storage " + storage.getId());
    }

    private static boolean checkIdStorageTo(Storage storageFrom, Storage storageTo) throws Exception {

        for (File fromFile : storageFrom.getFiles()) {
            for (File toFile : storageTo.getFiles()) {
                if (fromFile != null && toFile != null && fromFile.getId() == toFile.getId()) {
                    throw new Exception("error :these files corresponds ID,the transfer is invalid. " + storageTo.getId());
                }
            }
        }
        return true;
    }

    private static boolean formatCheckStorageTo(Storage storageFrom, Storage storageTo) throws Exception {

        for (File fromFile : storageFrom.getFiles()) {
            for (String toFormatFile : storageTo.getFormatsSupported()) {
                if (toFormatFile != null && fromFile != null && !fromFile.getFormat().equals(toFormatFile)) {
                    throw new Exception("error : the format of these files is not appropriate,the transfer is invalid. " + storageTo.getId());
                }
            }
        }
        return true;
    }

    private static boolean checkSizeStorageTo(Storage storageFrom, Storage storageTo) throws Exception {

        long valueTo = storageTo.getStorageSize() - storageTo.calculateUsedSize();

        if (storageFrom.calculateUsedSize() <= valueTo) {
            return true;
        }
        throw new Exception("error :size is not enough,the transfer is invalid. " + storageTo.getId());
    }

    private static boolean freeSpaceStorageTo(Storage storageFrom, Storage storageTo) throws Exception {
        int add = 0;
        for (File fromFile : storageFrom.getFiles()) {
            if (fromFile != null) {
                add++;
            }
        }
        int increaseEmpty = 0;
        for (File to : storageTo.getFiles()) {
            if (to == null) {
                increaseEmpty++;
            }
        }

        if (add <= increaseEmpty) {
            return true;
        }

        throw new Exception("error :there is no free space, the transfer is invalid. " + storageTo.getId());
    }

}



