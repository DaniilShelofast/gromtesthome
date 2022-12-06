package lesson19Home;

import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;


    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public void addFile(File file) {
        for (int i = 0; i < getFiles().length; i++) {
            if (getFiles()[i] == null) {
                getFiles()[i] = file;
                break;
            }
        }
    }

    public void delete(File file) {
        for (int i = 0; i < getFiles().length; i++) {
            if (getFiles()[i] != null && getFiles()[i].equals(file)) {
                getFiles()[i] = null;
                break;

            }
        }
    }

    public long calculateUsedSize() {
        long sumaFileSize = 0;
        for (File f : getFiles()) {
            if (f != null) {
                sumaFileSize += f.getSize();
            }
        }
        return sumaFileSize;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public void setFormatsSupported(String[] formatsSupported) {
        this.formatsSupported = formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(long storageSize) {
        this.storageSize = storageSize;
    }


    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", files=" + Arrays.toString(files) +
                ", formatsSupported=" + Arrays.toString(formatsSupported) +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageSize=" + storageSize +
                '}';
    }
}
