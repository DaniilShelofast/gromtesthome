package lesson10.polyexamle;

public class User extends Human {

    public User(String name) {
        super(name);
    }

    @Override
    void run() {
        super.run();
        System.out.println("User class is called...");
    }

}
