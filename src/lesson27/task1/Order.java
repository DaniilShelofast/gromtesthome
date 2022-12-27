package lesson27.task1;

public class Order {

    private long id;
    private int price;
    private String currency;
    private String itemName;
    private String shopIdentifier;

    public Order(long id, int price, String currency, String itemName, String shopIdentifier) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentifier = shopIdentifier;
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

    public String getShopIdentifier() {
        return shopIdentifier;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", itemName='" + itemName + '\'' +
                ", shopIdentifier='" + shopIdentifier + '\'' +
                '}';
    }
}
