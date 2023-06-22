package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.util.Date;
import java.util.Random;


public class DemoRoom {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        RoomController.addRoom(new Room(76, 3, 100.0, true, false, new Date(100, 2, 3), new Hotel(randomNumber, "", "", "", "")));

    }
}
