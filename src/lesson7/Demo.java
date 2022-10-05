package lesson7;

import lesson6.Car;
import lesson6.DbConnector;
import lesson6.Deal;
import lesson6.User;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();
        User user2 = new User();
        Car car = new Car(1000, 2015, "Anton");
        DbConnector dbConnector = new DbConnector();

    }

    public  Deal createDeal(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {

        return new Deal(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");

    }

    public  Deal createDealAndCallMethods(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        Deal deal1 = new Deal(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");

        deal1.confirmOrder();
        deal1.checkPrice();
        deal1.isValidType();

        return  deal1;
    }



}



