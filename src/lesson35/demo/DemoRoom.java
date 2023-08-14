package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoRoom {
    public static void main(String[] args) throws Exception {
        RoomController roomController = new RoomController();
        String date_s = "2016-01-18 00:00:00";
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = dt.parse(date_s);
        Hotel hotel = new Hotel(8402174472181398681L, "null", "Ukraine", "Lviv", "Street121");
        Hotel hotel1 = new Hotel(4, "Power house", "Ukraine", "Lutsk", "Street143");
        Room room = new Room(2, 1, true, true, date, hotel1);
        roomController.addRoom(room);
        // 1, 1.0, true, true, 18-01-2015 00:00:00, 8402174472181398681

        //System.out.println(roomController.findRooms(new Filter(null, null, null, null, null, null, null, hotel)));
    }
}
