package lesson35.controller;

import lesson35.model.Hotel;

import static lesson35.service.HotelService.hotelService;

public class HotelController {

    public static Hotel findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public static Hotel findHotelByCity(String city) throws Exception {

        return hotelService.findHotelByCity(city);
    }

    public static void addHotel(Hotel hotel) throws Exception {
        hotelService.addHotel(hotel);
    }

    public static void deleteHotel(long idHotel) throws Exception {
        hotelService.deleteHotel(idHotel);
    }
}
