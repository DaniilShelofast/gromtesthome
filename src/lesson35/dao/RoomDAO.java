package lesson35.dao;

import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import static lesson35.service.HotelService.findIdHotel;

public class RoomDAO {
    public static void addRoom(Room room) {
        GeneralDAO.addObjectToFile(room, "C:\\Users\\User\\Desktop//RoomDb.txt");
    }

    public static void deleteRoom(long idRoom) throws Exception {
        LinkedList<Room> rooms = recordObjectRoom(readFileTextRoom());
        rooms.removeIf(room -> room.getId() == idRoom);

        try (BufferedWriter ignored = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop//RoomDb.txt", false))) {
            for (Room room : rooms) {
                addRoom(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static LinkedList<String> readFileTextRoom() {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop//RoomDb.txt"))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static LinkedList<Room> recordObjectRoom(LinkedList<String> strings) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        LinkedList<Room> rooms = new LinkedList<>();
        for (String line : strings) {
            String[] s = line.split(", ");
            if (s.length == 7) {
                Date date = dateFormat.parse(s[5]);
                int idHotel = Integer.parseInt(s[6]);
                Hotel hotel = findIdHotel(idHotel);
                rooms.add(new Room(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Double.parseDouble(s[2]), Boolean.parseBoolean(s[3]), Boolean.parseBoolean(s[4]), date, hotel));
            }
        }
        return rooms;
    }

}


