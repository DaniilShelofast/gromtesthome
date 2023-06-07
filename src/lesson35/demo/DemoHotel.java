package lesson35.demo;

import lesson35.controller.HotelController;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        System.out.println(HotelController.findHotelByCity("Lviv"));
        System.out.println("-------");
        System.out.println(HotelController.findHotelByName("Hotel ukraine"));
        System.out.println("-------");


    }
}
