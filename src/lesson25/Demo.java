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

    }

}
