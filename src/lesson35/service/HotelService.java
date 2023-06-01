package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.model.Hotel;

public class HotelService {

    private static final HotelDAO hotelDAO = new HotelDAO();

    public static Hotel findHotelByName(String name) throws Exception {
        return HotelDAO.findHotelByName(name);
    }

    public static Hotel findHotelByCity(String city) throws Exception {
        return HotelDAO.findHotelByCity(city);
    }
}
