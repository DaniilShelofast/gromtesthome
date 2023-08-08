package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.dao.RoomDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.LinkedList;
import java.util.List;


public class RoomService {

    public final RoomDAO roomDAO = new RoomDAO();
    public final HotelDAO hotelDAO = new HotelDAO();

    public List<Room> findRooms(Filter filter) throws Exception {
        List<Room> rooms = new LinkedList<>();

        if (checkNull(filter)) {
            return roomDAO.readAll();
        } else {
            for (Room room : roomDAO.readAll()) {
                if (checkFilter(room, filter)) {
                    rooms.add(room);
                }
            }
        }
        return rooms;
    }

    public void addRoom(Room room) throws Exception {
        validateRoom(room);
        roomDAO.addObjectToFile(room);
    }

    public void deleteRoom(long idRoom) throws Exception {
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
        return (areEqual(filter.getNumberOfGuests(), room.getNumberOfGuests())) &&
                (areEqual(filter.getPrice(), room.getPrice())) &&
                (areEqual(filter.isBreakfastIncluded(), room.isBreakfastIncluded())) &&
                (areEqual(filter.isPetsAllowed(), room.isPetsAllowed())) &&
                (areEqual(filter.getDateAvailableFrom(), room.getDateAvailableFrom())) &&
                (areEqual(filter.getCountry(), room.getHotel().getCountry())) &&
                (areEqual(filter.getCity(), room.getHotel().getCity())) &&
                (areEqual(filter.getHotel(), room.getHotel().getName()));
    }

    private boolean checkNull(Filter filter) {
        return filter.getNumberOfGuests() == null && filter.getPrice() == null && filter.isBreakfastIncluded() == null && filter.isPetsAllowed() == null &&
                filter.getDateAvailableFrom() == null && filter.getCountry() == null && filter.getCity() == null && filter.getHotel() == null;
    }

    public boolean areEqual(Object filter, Object room) {
        return filter == null || filter.equals(room);
    }
}
