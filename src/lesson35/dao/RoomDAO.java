package lesson35.dao;

import lesson35.GeneralDAO;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class RoomDAO {

    public static void addRoom(Room room, boolean append) {
        GeneralDAO.addObjectToFile(room, "C:\\Users\\User\\Desktop//RoomDb.txt", append);
    }

    public static void deleteRoom(long idRoom) throws Exception {
        LinkedList<Room> rooms = recordObject(readFileText());
        rooms.removeIf(room -> room.getId() == idRoom);

        try (BufferedWriter ignored = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop//RoomDb.txt", false))) {
            for (Room room : rooms) {
                addRoom(room, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<String> readFileText() {
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

    public static LinkedList<Room> recordObject(LinkedList<String> strings) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        LinkedList<Room> rooms = new LinkedList<>();
        for (String line : strings) {
            String[] s = line.split(", ");
            if (s.length == 7) {
                Date date = dateFormat.parse(s[5]);
                Hotel hotel = new Hotel(Integer.parseInt(s[6]), "Hotel", "Country", "City", "Street");
                rooms.add(new Room(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Double.parseDouble(s[2]), Boolean.parseBoolean(s[3]), Boolean.parseBoolean(s[4]), date, hotel));
            }
        }
        return rooms;
    }

}
