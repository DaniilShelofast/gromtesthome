package lesson35.service;

import lesson35.dao.RoomDAO;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.LinkedList;
import java.util.List;


public class RoomService {

    public static List<Room> findRooms(Filter filter) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        List<Room> list = new LinkedList<>();
        for (Room room : roomDAO.readAll()) {
            if (checkRoom(room, filter)) {
                list.add(room);
            }
        }
        return list;
    }

    public static void addRoom(Room room) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        roomDAO.verify(room.getId());
        roomDAO.addObjectToFile(room);
    }

    public static void deleteRoom(long idRoom) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        roomDAO.findObject(idRoom);
        roomDAO.deleteObjectFromFile(idRoom);
    }

    private static boolean checkRoom(Room room, Filter filter) {
        return room.getNumberOfGuests() == filter.getNumberOfGuests() && room.getPrice() >= filter.getPrice() && room.isBreakfastIncluded() == filter.isBreakfastIncluded()
                && room.isPetsAllowed() == filter.isPetsAllowed() && room.getDateAvailableFrom().toString().equals(filter.getDateAvailableFrom().toString())
                && room.getHotel().getCity().equals(filter.getCity())
                && room.getHotel().getCountry().equals(filter.getCountry())
                && room.getHotel().getId() == filter.getHotel().getId();
    }
}
