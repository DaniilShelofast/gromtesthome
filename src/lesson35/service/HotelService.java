package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import java.util.LinkedList;

import static lesson35.dao.HotelDAO.readFileTextHotel;
import static lesson35.dao.HotelDAO.recordObjectHotel;

public class HotelService {

    public static void addHotel(Hotel hotel) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();
        checkIdHotel(hotel.getId());
        hotelDAO.addObjectTo(hotel);
    }

    public static void deleteHotel(long idHotel) {
        HotelDAO.deleteHotel(idHotel);
    }

    public static Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : recordObjectHotel(readFileTextHotel())) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : recordObjectHotel(readFileTextHotel())) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    private static boolean checkIdHotel(long id) throws Exception {
        LinkedList<Hotel> hotels = recordObjectHotel(readFileTextHotel());
        for (Hotel hotel : hotels) {
            if (hotel != null && hotel.getId() == id) {
                throw new BadRequestException("Error : a hotel with such an ID already exists");
            }
        }
        return true;
    }

    public static Hotel findIdHotel(long idHotel) throws Exception {
        for (Hotel hotel : recordObjectHotel(readFileTextHotel())) {
            if (hotel.getId() == idHotel) {
                return hotel;
            }
        }
        throw new Exception("Error : the data is incorrect, the hotel with this ID does not exist");
    }
}
