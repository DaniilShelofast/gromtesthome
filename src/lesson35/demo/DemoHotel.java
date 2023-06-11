package lesson35.demo;

import lesson35.controller.HotelController;

import java.util.Random;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        HotelController.deleteHotel(2);

    }
}
