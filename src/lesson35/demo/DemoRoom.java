package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoRoom {
    public static void main(String[] args) throws Exception {
        RoomController roomController = new RoomController();
        String date_s = "2015-01-18 00:00:00";
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dt.parse(date_s);
        Hotel hotel = null;
        Room room = new Room(1, 1, true, true, date, hotel);
        roomController.addRoom(room);
    }
}
