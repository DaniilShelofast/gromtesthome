package lesson10Home;

import java.util.Date;

public abstract class Order {
    public String itemName;
    public Date dateCreated;

    public Date dateConfirmed;

    public Date dateShipped;

    public String shipFromCity;

    public String shipToCity;
    public int basePrice;
    public double totalPrice;
    public Customer customerOwner;

    public Order(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwner) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipFromCity = shipFromCity;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwner = customerOwner;
    }

    abstract void validateOwned();


    abstract void calculatePrice();


    abstract void confirmShipping();


}
