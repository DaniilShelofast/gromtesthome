package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.model.Hotel;

public class HotelService {

    private static final HotelDAO dao = new HotelDAO();

    public static Hotel findHotelByName(String name) throws Exception {
        return dao.findHotelByName(name);
    }

    public static Hotel findHotelByCity(String city) throws Exception {
        return dao.findHotelByCity(city);
    }
}
