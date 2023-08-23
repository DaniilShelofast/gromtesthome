package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.UserType;

import static lesson35.model.Session.loggedInUser;
import static lesson35.service.ValidationUtils.checkContentAndNull;


public class HotelService {

    public final HotelDAO hotelDAO = new HotelDAO();

    public Hotel findHotelByCity(String city) throws Exception {
        if (loggedInUser != null && loggedInUser.getUserType() == UserType.ADMIN || loggedInUser != null && loggedInUser.getUserType() == UserType.USER) {
            for (Hotel hotel : hotelDAO.readAll()) {
                if (hotel.getCity().equals(city)) {
                    return hotel;
                }
            }
        } else {
            throw new BadRequestException("error, you need to log in to your account first, then you can use search.");
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public Hotel findHotelByName(String name) throws Exception {
        if (loggedInUser != null && loggedInUser.getUserType() == UserType.ADMIN || loggedInUser != null && loggedInUser.getUserType() == UserType.USER) {
            for (Hotel hotel : hotelDAO.readAll()) {
                if (hotel.getName().equals(name)) {
                    return hotel;
                }
            }
        } else {
            throw new BadRequestException("error, you need to log in to your account first, then you can use search.");
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public void addHotel(Hotel hotel) throws Exception {
        if (loggedInUser != null && loggedInUser.getUserType() == UserType.ADMIN) {
            validateHotel(hotel);
            hotelDAO.addObjectToFile(hotel);
        }
        throw new BadRequestException("error: the user is not an admin.");
    }

    public void deleteHotel(long idHotel) throws Exception {
        if (loggedInUser != null && loggedInUser.getUserType() == UserType.ADMIN) {
            hotelDAO.findObject(idHotel);
            hotelDAO.deleteObjectFromFile(idHotel);
        }
        throw new BadRequestException("error: the user is not an admin.");
    }

    private void validateHotel(Hotel hotel) throws Exception {
        if (checkContentAndNull(hotel.getName()) || checkContentAndNull(hotel.getCity()) || checkContentAndNull(hotel.getCountry()) || checkContentAndNull(hotel.getStreet())) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }
    }
}
