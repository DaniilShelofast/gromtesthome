package lesson25;

public class User extends IdEntity {
    private long id;
    private String name;

    public User(long id, String name) throws Exception {

        if (name.length() > 7) {
            throw new Exception("error : many symbol! existence impossible " + name);
        }

        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
