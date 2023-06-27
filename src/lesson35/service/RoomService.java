package lesson35.service;

import lesson35.dao.RoomDAO;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.awt.*;

import static lesson35.dao.RoomDAO.readFileTextRoom;
import static lesson35.dao.RoomDAO.recordObjectRoom;

public class RoomService extends GeneralService<Room>{

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

    public static void addRoom(Room room) throws Exception {
        RoomService roomService = new RoomService();
        RoomDAO roomDAO = new RoomDAO();
        roomService.verificationObjectID(room.getId());
        roomDAO.addObjectToFile(room,"C:\\Users\\User\\Desktop//RoomDb.txt");
    }

    public static void deleteRoom(long idRoom) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        roomDAO.deleteObjectFromFile(idRoom,"C:\\Users\\User\\Desktop//RoomDb.txt");
    }

    @Override
    protected boolean verificationObjectID(long id) throws Exception {
        setReadFile(recordObjectRoom(readFileTextRoom()));
        return super.verificationObjectID(id);
    }

    @Override
    public Room findIdObject(long id) throws Exception {
        setReadFile(recordObjectRoom(readFileTextRoom()));
        return super.findIdObject(id);
    }
}
