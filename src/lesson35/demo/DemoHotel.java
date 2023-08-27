package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.controller.UserController;
import lesson35.model.Hotel;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        HotelController hotelController = new HotelController();
        UserController userController = new UserController();
        Hotel hotel = new Hotel(1, "ooo", "ggg", "ccc", "ppp");
        Hotel hotel1 = new Hotel("null", "eee", "eee", "ddd");
       // userController.login("eee", "eee");
        //System.out.println(hotelController.findHotelByName("null"));
        //System.out.println(hotelController.findHotelByCity("Lviv"));
        //hotelController.deleteHotel(53);
        hotelController.addHotel(hotel1);

    }
}
