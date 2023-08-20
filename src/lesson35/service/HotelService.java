package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.User;
import lesson35.model.UserType;

import static lesson35.service.UserService.loggedInUser;
import static lesson35.service.ValidationUtils.checkContentAndNull;


public class HotelService {

    public final HotelDAO hotelDAO = new HotelDAO();

    public Hotel findHotelByCity(String city) throws Exception {
        User user = loggedInUser;
        if (user.getUserType() == null) {
            throw new BadRequestException("Error...");
        }

        for (Hotel hotel : hotelDAO.readAll()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public Hotel findHotelByName(String name) throws Exception {
        User user = loggedInUser;
        if (user.getUserType() != UserType.ADMIN || user.getUserType() != UserType.USER) {
            throw new BadRequestException("Error...");
        }

        for (Hotel hotel : hotelDAO.readAll()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public void addHotel(Hotel hotel) throws Exception {
        User user = loggedInUser;
        if (user.getUserType() != UserType.ADMIN) {
            throw new BadRequestException("error: the user is not an admin.");
        }

        validateHotel(hotel);
        hotelDAO.addObjectToFile(hotel);
    }

    public void deleteHotel(long idHotel) throws Exception {
        User user = loggedInUser;
        if (user.getUserType() != UserType.ADMIN) {
            throw new BadRequestException("error: the user is not an admin.");
        }

        hotelDAO.findObject(idHotel);
        hotelDAO.deleteObjectFromFile(idHotel);
    }

    private void validateHotel(Hotel hotel) throws Exception {
        if (checkContentAndNull(hotel.getName()) || checkContentAndNull(hotel.getCity()) || checkContentAndNull(hotel.getCountry()) || checkContentAndNull(hotel.getStreet())) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }
    }

}
