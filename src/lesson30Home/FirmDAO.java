package lesson30Home;


import java.util.Date;
import java.util.LinkedList;

public class FirmDAO {

    private static final LinkedList<Firm> firms = new LinkedList<>();


    private FirmDAO() {

        Firm firm1 = new Firm(new Date());
        Firm firm2 = new Firm(new Date(100, 15, 10));
        firms.add(firm1);
        firms.add(firm2);
    }

    public LinkedList<Firm> getFirms() {
        return firms;
    }

}