package lesson10.polyexamle;

public class Child extends Human {

    public Child(String name) {
        super(name);
    }

    @Override
    void run() {
        super.run();
        System.out.println("Child class is called...");
    }

}
