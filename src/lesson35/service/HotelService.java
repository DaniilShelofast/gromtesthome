package lesson35.service;

import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import static lesson35.dao.HotelDAO.hotelDAO;


public class HotelService {

    public static final HotelService hotelService = new HotelService();

    public  Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : hotelDAO.readAll()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public  Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : hotelDAO.readAll()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public  void addHotel(Hotel hotel) throws Exception {
        hotelDAO.verify(hotel.getId());
        hotelDAO.addObjectToFile(hotel);
    }

    public  void deleteHotel(long idHotel) throws Exception {
        hotelDAO.findObject(idHotel);
        hotelDAO.deleteObjectFromFile(idHotel);
    }


}
