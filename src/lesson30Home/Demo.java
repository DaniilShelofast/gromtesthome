package lesson30Home;

public class Demo {
    public static void main(String[] args) throws Exception {
        Customer customer1 = new Customer("rrr", "rrr", "rrr", 100);
        Customer customer2 = new Customer("ooo", "ooo", "ooo", 110);

        FirmDAO.add(customer1);
        FirmDAO.add(customer2);
        FirmDAO.update(new Customer("ooo", "ooo", "ooo", 2000));
        System.out.println(FirmDAO.getFirms());
    }
}
