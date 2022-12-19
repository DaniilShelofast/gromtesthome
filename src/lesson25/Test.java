package lesson25;

public class Test extends IdEntity {
    private long id;
    private String name;

    public Test(long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
