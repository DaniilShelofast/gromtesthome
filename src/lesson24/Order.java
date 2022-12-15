package lesson24;

public class Order {
    private String type;
    private String city;

    public Order(String type, String city) {
        this.type = type;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Order{" +
                "type='" + type + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
