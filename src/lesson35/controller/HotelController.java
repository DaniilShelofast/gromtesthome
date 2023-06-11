package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class HotelController {


    public static Hotel findHotelByName(String name) throws Exception {
        return HotelService.findHotelByName(name);
    }

    public static Hotel findHotelByCity(String city) throws Exception {

        return HotelService.findHotelByCity(city);
    }

    public static void addHotel(Hotel hotel, boolean append) throws Exception {
        HotelService.addHotel(hotel, append);
    }

    public static void deleteHotel(long idHotel) {
        HotelService.deleteHotel(idHotel);
    }
}
