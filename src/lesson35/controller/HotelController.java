package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class HotelController {

    private static HotelService hotelService = new HotelService();

    public static Hotel findHotelByName(String name) throws Exception {
        return HotelService.findHotelByName(name);
    }
    public static Hotel findHotelByCity(String city) throws Exception {
        return HotelService.findHotelByCity(city);
    }
}
