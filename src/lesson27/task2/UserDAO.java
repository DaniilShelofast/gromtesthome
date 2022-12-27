package lesson27.task2;

import lesson22.repository.User;

import java.util.ArrayList;
import java.util.LinkedList;

//
public class UserDAO {

    private final static User[] users = new User[10];

    public static User[] getUsers() {

        return users;
    }


    public static LinkedList<String> getUserNames() {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] userNames = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                userNames[i] = users[i].getName();
            }
        }
        return linkedList;
    }

    public static LinkedList<Long> getUserIds() {
        LinkedList<Long> linkedList = new LinkedList<>();
        long[] it = new long[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                it[i] = users[i].getId();
            }
        }
        return linkedList;
    }

    public static ArrayList<String> getUserNameById(long id) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (User it : users) {
            if (id == it.getId()) {

                return arrayList;
            }
        }
        return null;
    }

    public static ArrayList<User> getUserByName(String name) {
        ArrayList<User> arrayList = new ArrayList<>();
        for (User it : users) {
            if (name.equals(it.getName())) {

                return arrayList;
            }
        }
        return null;
    }

    public static ArrayList<User> getUserById(long id) {
        ArrayList<User> arrayList = new ArrayList<>();
        for (User it : users) {
            if (id == it.getId()) {

                return arrayList;
            }
        }
        return null;
    }

    public static ArrayList<User> getUserBySessionId(String sessionId) {
        ArrayList<User> arrayList = new ArrayList<>();
        for (User it : users) {
            if (sessionId.equals(it.getSessionId())) {
                return arrayList;
            }
        }
        return null;
    }


    public static ArrayList<User> findById(long id) {
        ArrayList<User> arrayList = new ArrayList<>();
        for (User it : users) {
            if (it != null && id == it.getId()) {
                return arrayList;
            }
        }
        return null;
    }


    public static LinkedList<User> save(User user) {
        LinkedList<User> linkedList = new LinkedList<>();

        ArrayList<User> findById = findById(user.getId());
        if (findById != null) {
            return null;
        } else {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return linkedList;
                }
            }
            return null;
        }

    }


    public static ArrayList<User> upDate(User user) {
        ArrayList<User> arrayList = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && user.getId() == users[i].getId()) {
                users[i] = user;
                return arrayList;
            }

        }
        return null;
    }

    public static void delete(long id) {


        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && id == users[i].getId()) {
                users[i] = null;
            }
        }
    }
}
