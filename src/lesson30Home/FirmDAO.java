package lesson30Home;


import java.util.Date;


public class FirmDAO {

    private static Firm firms;

    static {
        Firm firmLogistics = new Firm(new Date(121, 10, 15));
        Firm firmDesign = new Firm(new Date(100, 15, 10));

    }

    public static Firm getFirms() {
        return firms;
    }
}