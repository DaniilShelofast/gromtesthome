package lesson21;

public class Company {
    private int numberOfEmployees;
    private String name;
    private static String licence;
    private static int maxNumberOfEmployees;

    static {
        System.out.println("Code block is called");
        init();

    }


    public Company(int numberOfEmployees, String name) throws Exception {
        if (numberOfEmployees > maxNumberOfEmployees)
            throw new Exception("Company can have max " + maxNumberOfEmployees + " employees");

        this.numberOfEmployees = numberOfEmployees;
        this.name = name;
    }

    public static void validate() throws Exception {
        if (!licence.equals("TTT111"))
            throw new Exception("Wrong licence " + licence);

    }

    private static void init() {
        maxNumberOfEmployees = 100;
    }

    public static void setLicence(String licence) {
        Company.licence = licence;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public static String getLicence() {
        return licence;
    }

    public static int getMaxNumberOfEmployees() {
        return maxNumberOfEmployees;
    }

 /*   private static class Test {


    }*/
}
