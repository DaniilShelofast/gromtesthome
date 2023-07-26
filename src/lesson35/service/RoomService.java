package lesson35.service;

import lesson35.dao.RoomDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.LinkedList;
import java.util.List;


public class RoomService {

    public final RoomDAO roomDAO = new RoomDAO();

    public List<Room> findRooms(Filter filter) throws Exception {
        List<Room> list = new LinkedList<>();
        for (Room room : roomDAO.readAll()) {
            if (checkRoom(room, filter)) {
                list.add(room);
            }
        }
        return list;
    }

    public void addRoom(Room room) throws Exception {
        validateRoom(room);
        roomDAO.addObjectToFile(room);
    }

    public void deleteRoom(long idRoom) throws Exception {
        roomDAO.findObject(idRoom);
        roomDAO.deleteObjectFromFile(idRoom);
    }

    private boolean checkRoom(Room room, Filter filter) {
        return room.getNumberOfGuests() == filter.getNumberOfGuests() && room.getPrice() >= filter.getPrice() && room.isBreakfastIncluded() == filter.isBreakfastIncluded()
                && room.isPetsAllowed() == filter.isPetsAllowed() && room.getDateAvailableFrom().toString().equals(filter.getDateAvailableFrom().toString())
                && room.getHotel().getCity().equals(filter.getCity())
                && room.getHotel().getCountry().equals(filter.getCountry())
                && room.getHotel().getId() == filter.getHotel().getId();
    }

    private void validateRoom(Room room) throws Exception {
        roomDAO.findObject(room.getHotel().getId());
        if (room.getNumberOfGuests() == 0 || room.getNumberOfGuests() <= 0 || room.getPrice() == 0 || room.getPrice() <= 0
                || room.getDateAvailableFrom() == null || roomDAO.findObject(room.getHotel().getId()) == null) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }
    }

}
