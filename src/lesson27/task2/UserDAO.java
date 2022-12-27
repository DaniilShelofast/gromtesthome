package lesson27.task2;


import java.util.ArrayList;
import java.util.LinkedList;


public class UserDAO {

    static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static LinkedList<String> getUserNames() {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] userNames = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null) {
                userNames[i] = users.get(i).getName();
            }
        }
        return linkedList;
    }

    public static LinkedList<Long> getUserIds() {
        LinkedList<Long> linkedList = new LinkedList<>();
        long[] it = new long[users.size()];
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null) {
                it[i] = users.get(i).getId();
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
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) == null) {
                    users.add(user);

                    return linkedList;
                }
            }
            return null;
        }

    }


    public static ArrayList<User> upDate(User user) {
        ArrayList<User> arrayList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null && user.getId() == users.get(i).getId()) {
                users.add(user);
                return arrayList;
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
