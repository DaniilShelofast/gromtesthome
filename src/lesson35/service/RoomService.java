package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.dao.RoomDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.util.LinkedList;
import java.util.List;

import static lesson35.service.SessionUtils.isAdminAuthorized;
import static lesson35.service.SessionUtils.isAuthorized;
import static lesson35.service.ValidationUtils.areEqual;


public class RoomService {

    public final RoomDAO roomDAO = new RoomDAO();
    public final HotelDAO hotelDAO = new HotelDAO();

    public List<Room> findRooms(Filter filter) throws Exception {
        isAuthorized();
        List<Room> rooms = new LinkedList<>();
        for (Room room : roomDAO.readAll()) {
            if (checkFilter(room, filter)) {
                rooms.add(room);
            }
        }
        return rooms;
    }

    public void addRoom(Room room) throws Exception {
        isAdminAuthorized();
        validateRoom(room);
        roomDAO.addObjectToFile(room);
    }

    public void deleteRoom(long idRoom) throws Exception {
        isAdminAuthorized();
        roomDAO.findObject(idRoom);
        roomDAO.deleteObjectFromFile(idRoom);

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
