package lesson33;

public class Demo {
    public static void main(String[] args) {
        ReadWriteFile.readFile("C:\\Users\\User\\Desktop/test.txt");
        ReadWriteFile.writeFile("C:\\Users\\User\\Desktop/test1.txt");
        ReadWriteFile.writeToFileFromConsole("C:\\Users\\User\\Desktop/test1.txt");
        ReadWriteFile.readFileByConsolePath();
    }
}
