package lesson10Home;

import java.util.Date;

public class ElectronicsOrder extends Order {

    private int guaranteeMonths;



    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwner, String name, String city, String gender, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwner);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    void confirmShipping() {

        if (customerOwner == null) {
            dateShipped = new Date();
        }

    }


    @Override
    void validateOwned() {

        if (checkCity(shipFromCity) && checkCity(shipToCity) && basePrice >= 100 && (customerOwner.getGender() == "Woman")) {
             dateConfirmed = new Date();
        }
    }

    private boolean checkCity(String shipFromCity) {
        return shipFromCity == "Kyiv" || shipFromCity == "Odessa" || shipFromCity == "Kharkiv" || shipFromCity == "Dnepr";
    }


    @Override
    void calculatePrice() {
        double deliveryMax = basePrice * 0.15;
        double deliveryMin = basePrice * 0.10;


        if (shipToCity != "Kyiv" && shipToCity != "Odessa") {
            totalPrice = basePrice + deliveryMax;
        } else {
            totalPrice = basePrice + deliveryMin;
        }

        if (totalPrice >= 1000) {
            double sale = totalPrice * 0.05;
            totalPrice = totalPrice - sale;
        }


    }
}
