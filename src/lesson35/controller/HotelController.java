package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;


public class HotelController {

    public final HotelService hotelService = new HotelService();

    public Hotel findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }

    public void addHotel(Hotel hotel) throws Exception {
        hotelService.addHotel(hotel);
    }

    public void deleteHotel(long idHotel) throws Exception {
        hotelService.deleteHotel(idHotel);
    }

}
