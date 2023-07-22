package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;


public class HotelService {

    public final HotelDAO hotelDAO = new HotelDAO();

    public Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : hotelDAO.readAll()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : hotelDAO.readAll()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public void addHotel(Hotel hotel) throws Exception {
        dataValidation(hotel);
        hotelDAO.addObjectToFile(hotel);
    }

    public void deleteHotel(long idHotel) throws Exception {
        hotelDAO.findObject(idHotel);
        hotelDAO.deleteObjectFromFile(idHotel);
    }

    private void dataValidation(Hotel hotel) throws Exception {
        if (hotel.getName().equals("") || hotel.getCity().equals("") || hotel.getStreet().equals("") || hotel.getCountry().equals("") ||
                hotel.getName().equals(" ") || hotel.getCity().equals(" ") || hotel.getStreet().equals(" ") || hotel.getCountry().equals(" ")) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }
    }

}
