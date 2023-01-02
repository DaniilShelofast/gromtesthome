package lesson28.task2;

import lesson28.task1.Capability;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {

    @Override

    public int compare(Capability o1, Capability o2) {
        System.out.println("compareTo is used.");

        if (!o1.getChannelName().equals(o2.getChannelName())) {

            return o1.getChannelName().compareTo(o2.getChannelName());

        } else if (!o1.getFingerprint().equals(o2.getFingerprint())) {

            return o1.getFingerprint().compareTo(o2.getFingerprint());

        } else if (o1.getDateCreated().getTime() >= o2.getDateCreated().getTime()) {
            return -1;

        } else if (o1.getDateCreated().getTime() == o2.getDateCreated().getTime() || o1.getDateCreated().getTime() != o2.getDateCreated().getTime()) {
            return 0;

        } else
            return 1;

    }
}




