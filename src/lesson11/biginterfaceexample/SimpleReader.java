package lesson11.biginterfaceexample;

public class SimpleReader implements Readable {
    @Override
    public void readFilesFromStorage(Storage storage) {
        for (File file : storage.getFiles()) {
            if (file != null) {
                System.out.println(file.getName());

            } else {
                System.out.println(file);
            }
        }


    }


}
