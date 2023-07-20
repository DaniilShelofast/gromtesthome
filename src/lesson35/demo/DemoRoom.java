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
        Room room = new Room(2, 134.5, true, true, date, new Hotel(1947405888845065656L, "", "", "", ""));
        //RoomController.deleteRoom(1);
        roomController.addRoom(room);//32, 1, 135.0, true, true, 18-01-2015 00:00:00, 15
        //System.out.println(roomController.findRooms(new Filter(1, 135.0, true, true, date, "Ukraine", "Kyiv", new Hotel(15, "Maximus hotel", "Ukraine", "Kyiv", "Street1"))));
    }
}
