package lesson10Home;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customerOwner = new Customer("Ann" , "Odessa", "Woman");

        ElectronicsOrder electronicsOrder = new ElectronicsOrder("TV", new Date(),"Odessa", "Kyiv", 11234,customerOwner, "Denis", "Kharkiv","Man", 12);
        electronicsOrder.confirmShipping();
        electronicsOrder.validateOwned();
        electronicsOrder.calculatePrice();

       /* FurnitureOrder furnitureOrder = new FurnitureOrder("TV", new Date(), "Dnepr", "Odessa", 40000000, customerOwner, "Ann", "Odessa", "Woman", "wardrobe");
        furnitureOrder.confirmShipping();
        furnitureOrder.calculatePrice();
        furnitureOrder.validateOwned();*/
    }


}
