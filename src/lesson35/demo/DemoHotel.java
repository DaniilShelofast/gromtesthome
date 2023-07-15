package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;

public class DemoHotel {
    public static void main(String[] args) throws Exception {

        Hotel hotel = new Hotel(1, "ooo", "ggg", "ccc", "ppp");
        Hotel hotel1 = new Hotel("fff","fff","fff","fff");
        HotelController.addHotel(hotel1);
        //HotelController.deleteHotel(53);

    }
}
