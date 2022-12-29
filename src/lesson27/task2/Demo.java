package lesson27.task2;


public class Demo {
    public static void main(String[] args) throws Exception {

        User user1 = new User(4, "Oleg", "one");
        User user2 = new User(9, "Sasha", "two");
        //User user3 = new User(4, "Max", "two");
        User user4 = new User(5, "Daryna", "one");

        UserDAO.save(user1);
        UserDAO.save(user2);
        UserDAO.save(user4);

        UserDAO.delete(9);
        System.out.println(UserDAO.getUsers());


    }

}
