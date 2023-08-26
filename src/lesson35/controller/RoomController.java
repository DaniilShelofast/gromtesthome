package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.service.RoomService;

import java.util.List;

public class RoomController {

    private final RoomService roomService = new RoomService();

    public void addRoom(Room room) throws Exception {
        roomService.addRoom(room);
    }

    public void deleteRoom(long idRoom) throws Exception {
        roomService.deleteRoom(idRoom);
    }

    public List<Room> findRooms(Filter filter) throws Exception {
        return roomService.findRooms(filter);
    }
}
