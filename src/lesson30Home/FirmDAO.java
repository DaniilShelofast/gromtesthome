package lesson30Home;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FirmDAO {

    private static final Set<Firm> firms = new HashSet<>();


    private FirmDAO() {

        Firm firm1 = new Firm(new Date(121, 10, 15));
        Firm firm2 = new Firm(new Date(100, 15, 10));
        firms.add(firm1);
        firms.add(firm2);
    }

    public Set<Firm> getFirms() {
        return firms;
    }

}