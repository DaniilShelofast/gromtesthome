package lesson27.task2;

import java.util.ArrayList;
import java.util.LinkedList;

//
public class UserDAO {

    public static ArrayList<User> findById(long id) throws Exception {
        User user1 = new User(1, "User1", "one");
        User user2 = new User(2, "User2", "one");
        User user3 = new User(3, "User3", "one");

        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        for (User user : list) {
            if (user != null && user.getId() == id) {

                return list;
            }
        }
        throw new Exception("User with id: " + id + " not found");
    }


    public static void delete(long id) {
        LinkedList<User> list = new LinkedList<>();
        User user1 = new User(1, "User1", "one");
        User user2 = new User(2, "User2", "one");
        User user3 = new User(3, "User3", "one");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && id == list.get(i).getId()) {
                list.remove(i);
            }
        }
    }

    public static ArrayList<User> upDate(User user) throws Exception {

        User user1 = new User(1, "User1", "one");
        User user2 = new User(2, "User2", "one");
        User user3 = new User(3, "User3", "one");

        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && user.getId() == list.get(i).getId()) {
                list.add(user);

                return list;
            }
        }
        throw new Exception("Unexpected error");
    }

    public static LinkedList<User> saveUser(User user) throws Exception {
        LinkedList<User> list = new LinkedList<>();
        User user1 = new User(1, "User1", "one");
        User user2 = new User(2, "User2", "one");
        User user3 = new User(3, "User3", "one");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        ArrayList<User> findById = findById(user.getId());
        if (findById != null) {
            throw new Exception("Can`t save null user");
        } else {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == null) {
                    list.add(user);
                    return list;
                }
            }
            throw new Exception("Not space to save user with id: " + user.getId());
        }

    }
}
