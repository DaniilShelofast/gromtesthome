package lesson15;

public class Demo {
    public static void main(String[] args) {
        File file1 = new File(111, "home/Document/test", "jpg");
        File file2 = new File(111, "home/Document/image", "php");
        File file3 = new File(111, "home/Document/test", "jpg");
        File someFile = file1;

        System.out.println(file1.equals(file2));
        System.out.println(file1.equals(file3));

        System.out.println(file1.equals(someFile));

        User user = new User(1000);
        System.out.println(file1.equals(user));
    }
}
