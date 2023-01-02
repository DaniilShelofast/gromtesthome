package lesson28.task2;

import lesson28.task1.Capability;

import java.util.ArrayList;
import java.util.Date;


public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "a", "l", true, new Date());
        Capability capability2 = new Capability(1002, "a", "l", true, new Date(109, 7, 4, 11, 15, 0));
        Capability capability3 = new Capability(1003, "a", "l", true, new Date(107, 5, 4, 12, 15, 0));
        Capability capability4 = new Capability(1004, "a", "l", true, new Date());
        ArrayList<Capability> capabilities = new ArrayList<>();

        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        System.out.println(capabilities);
        System.out.println("--");
        capabilities.sort(new FullComparator());

        System.out.println(capabilities);
        System.out.println("--");


    }
}
