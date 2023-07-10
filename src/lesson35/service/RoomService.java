package lesson35.service;

import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.LinkedList;
import java.util.List;

import static lesson35.dao.RoomDAO.roomDAO;


public class RoomService {

    public final static RoomService roomService = new RoomService();

    public  List<Room> findRooms(Filter filter) throws Exception {
        List<Room> list = new LinkedList<>();
        for (Room room : roomDAO.readAll()) {
            if (checkRoom(room, filter)) {
                list.add(room);
            }
        }
        return list;
    }

    public  void addRoom(Room room) throws Exception {
        roomDAO.verify(room.getId());
        roomDAO.addObjectToFile(room);
    }

    public  void deleteRoom(long idRoom) throws Exception {
        roomDAO.findObject(idRoom);
        roomDAO.deleteObjectFromFile(idRoom);
    }

    private  boolean checkRoom(Room room, Filter filter) {
        return room.getNumberOfGuests() == filter.getNumberOfGuests() && room.getPrice() >= filter.getPrice() && room.isBreakfastIncluded() == filter.isBreakfastIncluded()
                && room.isPetsAllowed() == filter.isPetsAllowed() && room.getDateAvailableFrom().toString().equals(filter.getDateAvailableFrom().toString())
                && room.getHotel().getCity().equals(filter.getCity())
                && room.getHotel().getCountry().equals(filter.getCountry())
                && room.getHotel().getId() == filter.getHotel().getId();
    }
}
