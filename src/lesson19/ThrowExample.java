package lesson19;

public class ThrowExample {
    private static String[] array = {"test", "test2", "test3",null, "test4", "test5"};

    public static void main(String[] args) {
        useOfTestMethod();

    }

    private static void test() throws Exception {
        for (String element : array) {
            if (element == null)
                throw new Exception(" null is detected");
        }
        System.out.println("done");
    }

    private static void useOfTestMethod() {
        try {
            test();
        } catch (Exception e) {
            System.err.println("error:" + e.getMessage());
        }

    }
}


