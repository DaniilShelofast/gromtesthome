package lesson10Home;

import java.util.Date;

public class FurnitureOrder extends Order {

    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwner, String name, String city, String gender, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwner);
        this.furnitureCode = furnitureCode;
    }

    @Override
    void validateOwned() {

        if (customerOwner == null) {
            dateShipped = new Date();
        }

    }

    @Override
    void confirmShipping() {
        if ((shipFromCity == "Kyiv" || shipFromCity == "Lviv") && (shipToCity != null) && (basePrice >= 500) && (customerOwner.getName() != "Test")) {
            dateConfirmed = new Date();
        }

    }

    @Override
    void calculatePrice() {


        if (totalPrice < 5000) {
            double commissionDel = basePrice * 0.05;
            totalPrice = basePrice + commissionDel;
        } else {
            double commissionMin = basePrice * 0.02;
            totalPrice = basePrice + commissionMin;
        }
    }

}
