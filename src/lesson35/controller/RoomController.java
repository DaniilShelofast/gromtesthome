package lesson35.controller;

import lesson35.model.Room;
import lesson35.service.RoomService;

public class RoomController {

    public static void addRoom(Room room, boolean append) throws Exception {
        RoomService.addRoom(room, append);
    }

    public static void deleteRoom(long idRoom) throws Exception {
        RoomService.deleteRoom(idRoom);
    }
}
