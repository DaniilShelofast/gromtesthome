package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;

import static lesson35.dao.GeneralDAO.generatedID;

public class DemoHotel {
    public static void main(String[] args) throws Exception {

        Hotel hotel = new Hotel(generatedID(), "ooo", "ggg", "ccc", "ppp");
        HotelController.addHotel(hotel);
        //HotelController.deleteHotel(53);

    }
}
