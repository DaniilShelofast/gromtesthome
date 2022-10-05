package lesson9.User;

public class UserRepository {


    private User[] users;

    public UserRepository(User[] users) {

        this.users = users;
    }

    public User[] getUsers() {

        return users;
    }


    public String[] getUserNames() {
        String[] userNames = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                userNames[i] = users[i].getName();
            }
        }
        return userNames;
    }

    public long[] getUserIds() {
        long[] it = new long[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                // users[i].getName();
                it[i] = users[i].getId();
            }
        }
        return it;
    }

    public String getUserNameById(long id) {
        for (User it : users) {
            if (id == it.getId()) {
                return it.getName();
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        for (User it : users) {
            if (name == it.getName()) {

                return it;
            }
        }
        return null;
    }

    public User getUserById(long id) {
        for (User it : users) {
            if (id == it.getId()) {
                return it;
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User it : users) {
            if (sessionId == it.getSessionId()) {
                return it;
            }
        }
        return null;

    }


    public User findById(long id) {
        for (User it : users) {
            if (it != null && id == it.getId()) {
                return it;
            }
        }
        return null;
    }


    public User save(User user) {

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


    public User upDate(User user) {

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && user.getId() == users[i].getId()) {
                users[i] = user;
                return user;
            }


        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && id == users[i].getId()) {
                users[i] = null;
            }
        }

    }

}
