package lesson35.service;

import lesson35.dao.RoomDAO;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.awt.*;

public class RoomService {

    public static List findRooms(Filter filter) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        List rooms = new List();
        for (Room room : roomDAO.recordObject(roomDAO.readFileText())) {
            if (room.getNumberOfGuests() == filter.getNumberOfGuests() && room.getPrice() == filter.getPrice() && room.isBreakfastIncluded() == filter.isBreakfastIncluded()
                    && room.isPetsAllowed() == filter.isPetsAllowed() && room.getDateAvailableFrom().toString().equals(filter.getDateAvailableFrom().toString())
                    && room.getHotel().getCity().equals(filter.getCity()) && room.getHotel().getCountry().equals(filter.getCountry()) && room.getHotel() == filter.getHotel()) {
                rooms.add(room.toString());
            }
        }
        return rooms;
    }

    public static void addRoom(Room room) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        roomDAO.verificationObjectID(room.getId());
        roomDAO.addObjectToFile(room);
    }

    public static void deleteRoom(long idRoom) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        roomDAO.findIdObject(idRoom);
        roomDAO.deleteObjectFromFile(idRoom);
    }

}
