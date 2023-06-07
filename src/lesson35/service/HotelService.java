package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.model.Hotel;

public class HotelService {

    public static Hotel findHotelByName(String name) throws Exception {
        return HotelDAO.findHotelByName(name);
    }

    public static Hotel findHotelByCity(String city) throws Exception {
        return HotelDAO.findHotelByCity(city);
    }

    public static void addHotel(Hotel hotel) throws Exception {
        HotelDAO.addHotel(hotel);
    }

    public static void deleteHotel(long idHotel) {
        HotelDAO.deleteHotel(idHotel);
    }
}
