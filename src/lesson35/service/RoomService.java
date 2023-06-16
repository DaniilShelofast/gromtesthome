package lesson35.service;

import lesson35.dao.RoomDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.awt.*;

import static lesson35.dao.RoomDAO.readFileText;
import static lesson35.dao.RoomDAO.recordObject;

public class RoomService {


    public static void addRoom(Room room, boolean append) throws Exception {
        idRooms(room.getId());
        RoomDAO.addRoom(room, append);
    }

    public static void deleteRoom(long idRoom) throws Exception {
        RoomDAO.deleteRoom(idRoom);
    }

    public static List findRooms(Filter filter) throws Exception {
        List rooms = new List();
        for (Room room : recordObject(readFileText())) {
            if (room.getNumberOfGuests() == filter.getNumberOfGuests() && room.getPrice() == filter.getPrice() && room.isBreakfastIncluded() == filter.isBreakfastIncluded()
                    && room.isPetsAllowed() == filter.isPetsAllowed() && room.getDateAvailableFrom().toString().equals(filter.getDateAvailableFrom().toString())
                    && room.getHotel().getCity().equals(filter.getCity()) && room.getHotel().getCountry().equals(filter.getCountry()) && room.getHotel() == filter.getHotel()) {
                rooms.add(room.toString());
            }
        }
        return rooms;
    }

    private static boolean idRooms(long id) throws Exception {
        for (Room room : recordObject(readFileText())) {
            if (room.getId() == id) {
                throw new BadRequestException("Error");
            }
        }
        return true;
    }
}
