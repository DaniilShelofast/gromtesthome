package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import java.util.LinkedList;

import static lesson35.dao.HotelDAO.readFileText;
import static lesson35.dao.HotelDAO.recordObject;

public class HotelService {

    public static Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : recordObject(readFileText())) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : recordObject(readFileText())) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static void addHotel(Hotel hotel,boolean append) throws Exception {
        findHotelById(hotel.getId());
        HotelDAO.addHotel(hotel,append);
    }

    public static void deleteHotel(long idHotel) {
        HotelDAO.deleteHotel(idHotel);
    }

    private static boolean findHotelById(long id) throws Exception {
        LinkedList<Hotel> hotels = recordObject(readFileText());
        for (Hotel hotel : hotels) {
            if (hotel != null && hotel.getId() == id) {
                throw new BadRequestException("Error : a hotel with such an ID already exists");
            }
        }
        return true;
    }

}
