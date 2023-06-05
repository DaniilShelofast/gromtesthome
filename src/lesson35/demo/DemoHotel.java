package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.dao.HotelDAO;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        HotelController controller = new HotelController();
        HotelDAO dao = new HotelDAO();
        System.out.println(HotelController.findHotelByCity("Lviv"));
        System.out.println(HotelController.findHotelByName("Maximus hotel"));
        System.out.println("-------");
        System.out.println();

    }
}
