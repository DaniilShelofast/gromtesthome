package lesson28.task2;

import lesson28.task1.Capability;

import java.util.Comparator;

public class IsActiveComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability capability1, Capability capability2) {
        if (capability1.isActive() && !capability2.isActive()) {
            return -1;
        } else if (capability1.isActive() && capability2.isActive() || !capability1.isActive() && !capability2.isActive()) {
            return 0;
        } else
            return 1;
    }
}
