package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;
import static lesson35.dao.GeneralDAO.generatedID;

public class DemoRoom {
    public static void main(String[] args) throws Exception {
        String date_s = "2015-01-18 00:00:00";
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dt.parse(date_s);
        Room room = new Room(generatedID(), 2, 134.5, true, true, date, new Hotel(15, "", "", "", ""));
        //RoomController.deleteRoom(1);
        //RoomController.addRoom(room);//32, 1, 135.0, true, true, 18-01-2015 00:00:00, 15
        System.out.println(RoomController.findRooms(new Filter(1, 135.0, true, true, date, "Ukraine", "Kyiv", new Hotel(15, "Maximus hotel", "Ukraine", "Kyiv", "Street1"))));
    }
}
