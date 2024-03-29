package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import static lesson35.service.SessionUtils.isAdminAuthorized;
import static lesson35.service.SessionUtils.isAuthorized;
import static lesson35.service.ValidationUtils.checkContentAndNull;


public class HotelService {

    private final HotelDAO hotelDAO = new HotelDAO();

    public Hotel findHotelByCity(String city) throws Exception {
        isAuthorized();
        for (Hotel hotel : hotelDAO.readAll()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public Hotel findHotelByName(String name) throws Exception {
        isAuthorized();
        for (Hotel hotel : hotelDAO.readAll()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }


    public void addHotel(Hotel hotel) throws Exception {
        isAdminAuthorized();
        validateHotel(hotel);
        hotelDAO.addObjectToFile(hotel);
    }

    public void deleteHotel(long idHotel) throws Exception {
        isAdminAuthorized();
        hotelDAO.findObject(idHotel);
        hotelDAO.deleteObjectFromFile(idHotel);
    }

    private void validateHotel(Hotel hotel) throws Exception {
        if (checkContentAndNull(hotel.getName()) || checkContentAndNull(hotel.getCity()) || checkContentAndNull(hotel.getCountry()) || checkContentAndNull(hotel.getStreet())) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }
    }
}
