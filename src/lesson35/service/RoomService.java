package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.dao.RoomDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.*;

import java.util.LinkedList;
import java.util.List;

import static lesson35.model.Session.loggedInUser;
import static lesson35.service.ValidationUtils.areEqual;


public class RoomService {

    public final RoomDAO roomDAO = new RoomDAO();
    public final HotelDAO hotelDAO = new HotelDAO();

    public List<Room> findRooms(Filter filter) throws Exception {
        if (loggedInUser != null && loggedInUser.getUserType() == UserType.ADMIN || loggedInUser != null && loggedInUser.getUserType() == UserType.USER) {
            List<Room> rooms = new LinkedList<>();
            for (Room room : roomDAO.readAll()) {
                if (checkFilter(room, filter)) {
                    rooms.add(room);
                }
            }
            return rooms;
        } else {
            throw new BadRequestException("error, you need to log in to your account first, then you can use search.");
        }
    }

    public void addRoom(Room room) throws Exception {
        if (loggedInUser != null && loggedInUser.getUserType() == UserType.ADMIN) {
            validateRoom(room);
            roomDAO.addObjectToFile(room);
        }
        throw new BadRequestException("error: the user is not an admin.");
    }

    public void deleteRoom(long idRoom) throws Exception {
        if (loggedInUser != null && loggedInUser.getUserType() == UserType.ADMIN) {
            roomDAO.findObject(idRoom);
            roomDAO.deleteObjectFromFile(idRoom);
        }
        throw new BadRequestException("error: the user is not an admin.");
    }

    private void validateRoom(Room room) throws Exception {
        if (room.getNumberOfGuests() <= 0 || room.getPrice() <= 0 || room.getDateAvailableFrom() == null || room.getHotel() == null) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }
        hotelDAO.findObject(room.getHotel().getId());
    }

    private boolean checkFilter(Room room, Filter filter) {
        Hotel roomHotel = room.getHotel();
        return areEqual(filter.getNumberOfGuests(), room.getNumberOfGuests()) &&
                areEqual(filter.getPrice(), room.getPrice()) &&
                areEqual(filter.isBreakfastIncluded(), room.isBreakfastIncluded()) &&
                areEqual(filter.isPetsAllowed(), room.isPetsAllowed()) &&
                areEqual(filter.getDateAvailableFrom(), room.getDateAvailableFrom()) &&
                areEqual(filter.getCountry(), roomHotel.getCountry()) &&
                areEqual(filter.getCity(), roomHotel.getCity()) &&
                areEqual(filter.getHotel(), roomHotel.getName());
    }
}
