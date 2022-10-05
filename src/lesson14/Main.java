package lesson14;

public class Main {
    public static void main(String[] args) {
        Demo user = new Demo(111, "Vadim", "Meta");
        Demo userTwo = new Demo(11, "Ann", "Meta");


        System.out.println(user.equals(userTwo));
        user.setName("Ann");
        System.out.println(user.equals(userTwo));
        System.out.println(user.hashCode() == userTwo.hashCode());


    }
}
