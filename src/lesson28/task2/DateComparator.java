package lesson28.task2;

import lesson28.task1.Capability;

import java.util.Comparator;


public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability capability1, Capability capability2) {
        System.out.println("time.");
        if (capability1.getDateCreated().equals(capability2.getDateCreated())) {
            return capability1.getDateCreated().compareTo(capability2.getDateCreated());
        }

        return 0;
    }
}
