package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import java.util.LinkedList;

public class HotelService {

    public static Hotel findHotelByName(String name) throws Exception {
        return HotelDAO.findHotelByName(name);
    }

    public static Hotel findHotelByCity(String city) throws Exception {
        return HotelDAO.findHotelByCity(city);
    }

    public static void addHotel(Hotel hotel,boolean append) throws Exception {
        findHotelById(hotel.getId());
        HotelDAO.addHotel(hotel,append);
    }

    public static void deleteHotel(long idHotel) {
        HotelDAO.deleteHotel(idHotel);
    }

    private static boolean findHotelById(long id) throws Exception {
        LinkedList<Hotel> hotels = HotelDAO.readHotels();
        for (Hotel hotel : hotels) {
            if (hotel != null && hotel.getId() == id) {
                throw new BadRequestException("Error : a hotel with such an ID already exists");
            }
        }
        return true;
    }

}
