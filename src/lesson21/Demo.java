package lesson21;

public class Demo {
    public static void main(String[] args) throws Exception {
        Company company = new Company(100, "Nokia");
        Company.setLicence("GTP999");
        System.out.println(Company.getLicence());

        Company company1 = new Company(9, "Test");
        System.out.println(Company.getLicence());

        Company.setLicence("TTT11");

        System.out.println(Company.getLicence());
        System.out.println(Company.getLicence());


    }
}
