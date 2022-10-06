package lesson15Home;

public class Demo {
    public static void main(String[] args) {
        User[] user = new User[7];
        user[0] = new User(1, "Nazar", "one");
        user[1] = new User(3, "Ann", "two");
        user[2] = new User(5, "Denis", "one");
        user[3] = new User(12, "test", "one");
        user[4] = new User(1, "Igor", "one");
        user[5] = new User(1, "Nazar", "one");

        UserRepository userRepository = new UserRepository(user);

        System.out.println(user[0].equals(user[1]));
        System.out.println(user[0].equals(user[2]));
        System.out.println(user[0].equals(user[3]));
        System.out.println(user[0].equals(user[4]));
        System.out.println(user[0].equals(user[5]));
        System.out.println(userRepository.upDate(new User(1, "Igor", "two")));
        System.out.println(userRepository.save(new User(12, "Artem", "one")));
        System.out.println(userRepository.findById(3));
        System.out.println(user[0].equals(user[5]));

    }
}
