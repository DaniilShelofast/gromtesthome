package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class HotelController {

    public static final HotelService hotelService = new HotelService();

    public static Hotel findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public static Hotel findHotelByCity(String city) throws Exception {

        return hotelService.findHotelByCity(city);
    }
}
