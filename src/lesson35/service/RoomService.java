package lesson35.service;

import lesson35.dao.RoomDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.awt.*;

import static lesson35.dao.RoomDAO.readFileTextRoom;
import static lesson35.dao.RoomDAO.recordObjectRoom;

public class RoomService {


    public static void addRoom(Room room) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        checkIdRoom(room.getId());
        roomDAO.addObjectToFile(room);
    }

    public static void deleteRoom(long idRoom) throws Exception {
       // RoomDAO.deleteRoom(idRoom);
    }

    public static List findRooms(Filter filter) throws Exception {
        List rooms = new List();
        for (Room room : recordObjectRoom(readFileTextRoom())) {
            if (room.getNumberOfGuests() == filter.getNumberOfGuests() && room.getPrice() == filter.getPrice() && room.isBreakfastIncluded() == filter.isBreakfastIncluded()
                    && room.isPetsAllowed() == filter.isPetsAllowed() && room.getDateAvailableFrom().toString().equals(filter.getDateAvailableFrom().toString())
                    && room.getHotel().getCity().equals(filter.getCity()) && room.getHotel().getCountry().equals(filter.getCountry()) && room.getHotel() == filter.getHotel()) {
                rooms.add(room.toString());
            }
        }
        return rooms;
    }

    private static boolean checkIdRoom(long id) throws Exception {
        for (Room room : recordObjectRoom(readFileTextRoom())) {
            if (room.getId() == id) {
                throw new BadRequestException("Error : a room with this ID already exists.");
            }
        }
        return true;
    }

    public static Room findRoomId(long idRoom) throws Exception {
        for (Room room : recordObjectRoom(readFileTextRoom())) {
            if (room.getId() == idRoom) {
                return room;
            }
        }
        throw new Exception("Error : the data is incorrect, the room with this ID does not exist");
    }
}
