package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;


public class HotelService {


    public static Hotel findHotelByCity(String city) throws Exception {
        HotelDAO dao = new HotelDAO();
        for (Hotel hotel : dao.map(dao.readAll())) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static Hotel findHotelByName(String name) throws Exception {
        HotelDAO dao = new HotelDAO();
        for (Hotel hotel : dao.map(dao.readAll())) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static void addHotel(Hotel hotel) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();
        hotelDAO.verify(hotel.getId());
        hotelDAO.addObjectToFile(hotel);
    }

    public static void deleteHotel(long idHotel) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();
        hotelDAO.findIdObject(idHotel);
        hotelDAO.deleteObjectFromFile(idHotel);
    }


}
