package lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

    public static User[] getUsers() {

        return users;
    }


    public static String[] getUserNames() {
        String[] userNames = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                userNames[i] = users[i].getName();
            }
        }
        return userNames;
    }

    public static long[] getUserIds() {
        long[] it = new long[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                it[i] = users[i].getId();
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
            if (sessionId == it.getSessionId()) {
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
        if (findById != null) {
            return null;
        } else {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
            return null;
        }

    }


    public static User upDate(User user) {

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && user.getId() == users[i].getId()) {
                users[i] = user;
                return user;
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
