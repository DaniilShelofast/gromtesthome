package lesson28.task2;

import lesson28.task1.Capability;

import java.util.Comparator;


public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability capability1, Capability capability2) {
        System.out.println("compareTo is used.");
        if (capability1.getDateCreated().getTime() >= capability2.getDateCreated().getTime()) {
            return -1;
        } else if (capability1.getDateCreated().getTime() == capability2.getDateCreated().getTime() || capability1.getDateCreated().getTime() != capability2.getDateCreated().getTime()) {
            return 0;
        } else
            return 1;


    }
}
