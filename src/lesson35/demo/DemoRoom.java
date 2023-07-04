package lesson35.demo;

import lesson35.model.Hotel;
import lesson35.model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class DemoRoom {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        String date_s = "2015-01-18 00:00:00";
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dt.parse(date_s);
        Room room = new Room(randomNumber, 2, 134.5, true, true, date, new Hotel(15, "", "", "", ""));
        //RoomController.deleteRoom(1);
        //RoomController.addRoom(room);
        //System.out.println(RoomController.findRooms(new Filter(1, 35.0, true, true, date, "Ukraine", "Kyiv", new Hotel(15, "Maximus hotel", "Ukraine", "Kyiv", "Street1"))));
    }
}
