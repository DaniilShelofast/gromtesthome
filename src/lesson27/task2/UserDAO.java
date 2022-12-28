package lesson27.task2;

import java.util.ArrayList;


public class UserDAO {
    public static void main(String[] args) {

        User user1 = new User(4, "Oleg", "one");
        User user2 = new User(9, "Sasha", "two");
        User user3 = new User(4, "Max", "two");
        User user4 = new User(5, "Daryna", "one");

        save(user1);
        save(user2);
        save(user3);
        save(user4);

        delete(4);
        System.out.println(getUsers());
        System.out.println(upDate(new User(5, "test", "test")));
        System.out.println(getUsers());
        System.out.println("-----------");

        System.out.println(getUserIds());
        System.out.println(getUserNames());


    }

    static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<String> getUserNames() {

        ArrayList<String> userName = new ArrayList<>(users.size());

        for (User user : users) {
            if (user != null) {
                userName.add(user.getName());
            }
        }
        return userName;
    }

    public static ArrayList<Long> getUserIds() {

        ArrayList<Long> it = new ArrayList<>(users.size());

        for (User user : users) {
            if (user != null) {
                it.add(user.getId());
            }
        }
        return it;
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


    public static User save(User user) {

        User findById = findById(user.getId());
        users.add(new User(user.getId(), user.getName(), user.getSessionId()));

        if (findById != null) {
            return null;
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) == null) {
                    users.add(user);

                    return user;
                }
            }
        }
        return null;
    }


    public static User upDate(User user) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null && user.getId() == users.get(i).getId()) {
                users.add(user);

                return user;
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
