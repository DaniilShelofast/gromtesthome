package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;

import java.util.Random;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        Hotel hotel = new Hotel(randomNumber, "ooo", "ggg", "ccc", "ppp");
        HotelController.addHotel(hotel);
        HotelController.deleteHotel(47);

    }
}
