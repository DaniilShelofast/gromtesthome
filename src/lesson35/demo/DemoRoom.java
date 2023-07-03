package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.model.Filter;
import lesson35.model.Hotel;

import java.util.Date;
import java.util.Random;


public class DemoRoom {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        System.out.println(RoomController.findRooms(new Filter(1,50.0,true,false,new Date(105,5,4),"Ukraine","Kyiv",new Hotel(15, "Maximus hotel", "Ukraine", "Kyiv", "Street1"))));
        //RoomController.addRoom(new Room(randomNumber, 3, 100.0, true, false, new Date(100, 2, 3), new Hotel(32, "", "", "", "")));

    }
}
