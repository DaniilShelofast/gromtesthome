package lesson23;

public class Demo {
    public static void main(String[] args) {
        Validator validator1 = new Validator("test");
        System.out.println(validator1.getCheckCount());

        Validator validator2 = new Validator("company");
        System.out.println(validator2.getCheckCount());
    }
}
