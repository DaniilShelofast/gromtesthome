package lesson25;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        GeneralDAO<User> userDAO = new GeneralDAO<>();
        User user = new User(2, "test");
        userDAO.save(user);

        User user2 = new User(1, "test2");
        userDAO.save(user2);
        System.out.println(Arrays.deepToString(userDAO.getAll()));
        System.out.println(" ");//-----------------------------------------------------------------
        GeneralDAO<Order> orderDAO = new GeneralDAO<>();
        Order order = new Order(12);
        orderDAO.save(order);

        Order order2 = new Order(11);
        orderDAO.save(order2);
        System.out.println(Arrays.deepToString(orderDAO.getAll()));
        System.out.println(" ");//-----------------------------------------------------------------
        GeneralDAO<Test> testDAO = new GeneralDAO<>();
        Test test = new Test(12, "test");
        testDAO.save(test);

        Test test2 = new Test(1, "test2");
        testDAO.save(test2);
        System.out.println(Arrays.deepToString(testDAO.getAll()));
    }

}
