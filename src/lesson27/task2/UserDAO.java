package lesson27.task2;

import java.util.ArrayList;
import java.util.LinkedList;
//
public class UserDAO {

    public static ArrayList<User> findById(long id) throws Exception {

        ArrayList<User> list = new ArrayList<>();
        for (User it : list) {
            if (it != null && it.getId() == id) {
                return list;
            }
        }

        throw new Exception("User with id: " + id + " not found");
    }

    public static void delete(long id) {
        LinkedList<User> list = new LinkedList<>();


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && id == list.get(i).getId()) {
                list.remove(i);
            }
        }
    }

    public static ArrayList<User> upDate(User user) throws Exception {
        ArrayList<User> list = new ArrayList<>();
        //list.add(user); -- як тільки так написав пропадає жовтий колір з циклу.

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
