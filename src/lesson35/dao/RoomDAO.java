package lesson35.dao;

import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.*;
import java.util.LinkedList;

public class RoomDAO {

    private static final String fileName = "C:\\Users\\User\\Desktop//RoomDb.txt";

    private static LinkedList<Room> readRooms() {
        LinkedList<Room> rooms = new LinkedList<>();

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 7) {
                    try {
                        String stringDate = data[5];
                        Hotel hotel = new Hotel(Integer.parseInt(data[6]), "Hotel", "Country", "City", "Street");
                        rooms.add(new Room(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2]), Boolean.parseBoolean(data[3]), Boolean.parseBoolean(data[4]), stringDate, hotel));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public static void addRoom(Room room,boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop/RoomDb.txt", append))) {
            File line = new File("C:\\Users\\User\\Desktop//RoomDb.txt");
            if (line.length() == 0) {
                writer.write(room.getId() + ", " + room.getNumberOfGuests() + ", " + room.getPrice() + ", " + room.isBreakfastIncluded() + ", " + room.isPetsAllowed() + ", " + room.getDateAvailableFrom() + ", " + room.getHotel().getId());
            } else {
                writer.newLine();
                writer.write(room.getId() + ", " + room.getNumberOfGuests() + ", " + room.getPrice() + ", " + room.isBreakfastIncluded() + ", " + room.isPetsAllowed() + ", " + room.getDateAvailableFrom() + ", " + room.getHotel().getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRoom(long idRoom) {
        LinkedList<Room> rooms = readRooms();
        rooms.removeIf(room -> room.getId() == idRoom);
        try (BufferedWriter ignored = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop//RoomDb.txt",false))) {
            for (Room room : rooms){
                addRoom(room,true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       // addRoom(new Room(5, 3, 100.0, true, false, "Thu Jun 08 10:27:36 EEST 2021", new Hotel(10, "", "", "", "")),true);

        System.out.println(readRooms());
    }

}
