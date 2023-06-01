package lesson35.dao;

import lesson35.model.Hotel;
import lesson35.model.Room;

import java.util.LinkedList;

public class RoomDAO {
    private static final LinkedList<Room> rooms = new LinkedList<>();

    public static LinkedList<Room> getHotels() {
        return rooms;
    }
}
