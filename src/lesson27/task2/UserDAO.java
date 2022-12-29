package lesson27.task2;

import java.util.ArrayList;


public class UserDAO {


    static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<String> getUserNames() {

        ArrayList<String> userNamesList = new ArrayList<>();


        for (User user : users) {
            if (user != null) {
                userNamesList.add(user.getName());
            }
        }
        return userNamesList;
    }

    public static ArrayList<Long> getUserIds() {

        ArrayList<Long> userLongsList = new ArrayList<>();

        for (User user : users) {
            if (user != null) {
                userLongsList.add(user.getId());
            }
        }
        return userLongsList;
    }

    public static String getUserNameById(long id) {

        for (User it : users) {
            if (id == it.getId()) {

                return it.getName();
            }
        }
        return null;
    }

    public static User getUserByName(String name) {

        for (User it : users) {
            if (name.equals(it.getName())) {

                return it;
            }
        }
        return null;
    }

    public static User getUserById(long id) {

        for (User it : users) {
            if (id == it.getId()) {

                return it;
            }
        }
        return null;
    }

    public static User getUserBySessionId(String sessionId) {

        for (User it : users) {
            if (sessionId.equals(it.getSessionId())) {

                return it;
            }
        }
        return null;
    }


    public static User findById(long id) {

        for (User it : users) {
            if (it != null && id == it.getId()) {

                return it;
            }
        }
        return null;
    }


    public static User save(User user) throws Exception {

        User findById = findById(user.getId());

        if (findById != null) {
            throw new Exception("error : user already exists " + user.getId() + " . change it or contact support");
        }

        users.add(user);

        return user;
    }


    public static User update(User user) throws Exception {

        for (int i = 0; i < users.size(); i++) {
            if (user.getId() == users.get(i).getId()) {
                users.set(i, user);

                return user;
            }

        }
        throw new Exception("error: " + user.getId() + " not correct, try to change ID.");
    }

    public static void delete(long id) throws Exception {

        users.removeIf(user -> id == user.getId());


    }

}
