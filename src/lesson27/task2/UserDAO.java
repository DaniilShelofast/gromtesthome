package lesson27.task2;


import java.util.ArrayList;
import java.util.Arrays;


public class UserDAO {
    public static void main(String[] args) {

        User user1 = new User(1001, "Oleg", "one");
        User user2 = new User(1651, "Sasha", "one");

        System.out.println(save(user1));
        System.out.println(save(user2));
        System.out.println(getUsers());


    }

    final static ArrayList<User> users = new ArrayList<>();


    public static ArrayList<User> getUsers() {
        return users;
    }

    public static String[] getUserNames() {

        String[] userNames = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null) {
                userNames[i] = users.get(i).getName();
            }
        }
        return userNames;
    }

    public static long[] getUserIds() {

        long[] it = new long[users.size()];
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null) {
                it[i] = users.get(i).getId();
            }
        }
        return it;
    }

    public static String getUserNameById(long id) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (User it : users) {
            if (id == it.getId()) {

                return it.getName();
            }
        }
        return null;
    }

    public static ArrayList<User> getUserByName(String name) {

        for (User it : users) {
            if (name.equals(it.getName())) {

                return users;
            }
        }
        return null;
    }

    public static ArrayList<User> getUserById(long id) {

        for (User it : users) {
            if (id == it.getId()) {

                return users;
            }
        }
        return null;
    }

    public static ArrayList<User> getUserBySessionId(String sessionId) {

        for (User it : users) {
            if (sessionId.equals(it.getSessionId())) {
                return users;
            }
        }
        return null;
    }


    public static ArrayList<User> findById(long id) {

        for (User it : users) {
            if (it != null && id == it.getId()) {
                return users;
            }
        }
        return null;
    }


    public static ArrayList<User> save(User user) {

        ArrayList<User> findById = findById(user.getId());
        if (findById != null) {
            return null;
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) == null) {
                    users.add(user);

                    return users;
                }
            }
            return null;
        }
    }


    public static ArrayList<User> upDate(User user) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null && user.getId() == users.get(i).getId()) {
                users.add(user);
                return users;
            }

        }
        return null;
    }

    public static void delete(long id) {


        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null && id == users.get(i).getId()) {
                users.remove(i);
            }
        }
    }
}
