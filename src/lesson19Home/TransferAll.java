package lesson19Home;

public class TransferAll {


    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        checkId(storageFrom, storageTo);
        formatCheck(storageFrom, storageTo);
        checkSizeStorage(storageFrom, storageTo);
        freeSpace(storageFrom, storageTo);

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
                if (storageFrom.getFiles()[i] != null && storageTo.getFiles()[j] != null && storageFrom.getFiles()[i] == storageTo.getFiles()[j]) {
                    storageFrom.getFiles()[i] = null;
                    break;
                }
            }
        }


    }

    private static boolean checkId(Storage storageFrom, Storage storageTo) throws Exception {

        for (int j = 0; j < storageFrom.getFiles().length; j++) {
            for (int i = 0; i < storageTo.getFiles().length; i++) {
                if (storageFrom.getFiles()[j] != null && storageTo.getFiles()[i] != null && storageFrom.getFiles()[j].getId() == storageTo.getFiles()[i].getId()) {
                    throw new Exception(" ID inappropriate!");
                }
            }
        }
        return true;
    }

    private static boolean formatCheck(Storage storageFrom, Storage storageTo) throws Exception {
        int add = 0;
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            for (int j = 0; j < storageTo.getFormatsSupported().length; j++) {
                if (storageTo.getFormatsSupported()[j] != null && storageFrom.getFiles()[i] != null && storageFrom.getFiles()[i].getFormat() != storageTo.getFormatsSupported()[j]) {
                    throw new Exception("Format inappropriate!");

                }
            }

        }

        return true;
    }

    private static boolean checkSizeStorage(Storage storageFrom, Storage storageTo) throws Exception {
        long sumaFilesFrom = 0;
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (storageFrom.getFiles()[i] != null) {
                sumaFilesFrom += storageFrom.getFiles()[i].getSize();
            }
        }
        long sumaFilesTo = 0;
        for (int j = 0; j < storageTo.getFiles().length; j++) {
            if (storageTo.getFiles()[j] != null) {
                sumaFilesTo += storageTo.getFiles()[j].getSize();
            }
        }

        long valueTo = storageTo.getStorageSize() - sumaFilesTo;

        if (sumaFilesFrom <= valueTo) {
            return true;
        }
        throw new Exception("Size inappropriate!");
    }

    private static boolean freeSpace(Storage storageFrom, Storage storageTo) throws Exception {
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

        throw new Exception("Not freely..!");
    }
}
