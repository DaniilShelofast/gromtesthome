package lesson19Home;

public class File {

    long id;
    String name;
    String format;
    long size;

    public File(long id, String name, String format, long size) {
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;

        try {
            more(name);
        } catch (Exception e) {
            System.err.println("up to ten characters" + name);
        }
    }
    private static boolean more(String name) {
        if (name.length() >= 10) {
            name = name.substring(0, 10);
            checkSymbol(name);
            return false;
        }
        return true;
    }
    private static boolean checkSymbol(String name) {
        char[] chars = name.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }
}
