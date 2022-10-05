package lesson14;

import java.util.Objects;

public class Demo {
    private int id;
    private String name;
    private String companyName;

    public Demo(int id, String name, String companyName) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return Objects.equals(name, demo.name) && Objects.equals(companyName, demo.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, companyName);
    }
}
