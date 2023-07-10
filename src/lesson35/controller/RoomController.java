package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.List;

import static lesson35.service.RoomService.roomService;


public class RoomController {

    public static void addRoom(Room room) throws Exception {
        roomService.addRoom(room);
    }

    public static void deleteRoom(long idRoom) throws Exception {
        roomService.deleteRoom(idRoom);
    }

    public static List<Room> findRooms(Filter filter) throws Exception {
        return roomService.findRooms(filter);
    }
}
