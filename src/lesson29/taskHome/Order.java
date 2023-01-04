package lesson29.taskHome;

import java.util.Objects;

public class Order {

    private long id;
    private int price;
    private String currency;
    private String itemName;
    private String shopIdentification;

    public Order(long id, int price, String currency, String itemName, String shopIdentification) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentification = shopIdentification;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getItemName() {
        return itemName;
    }

    public String getShopIdentification() {

        return shopIdentification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(itemName, order.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", itemName='" + itemName + '\'' +
                ", shopIdentification='" + shopIdentification + '\'' +
                '}';
    }

}
