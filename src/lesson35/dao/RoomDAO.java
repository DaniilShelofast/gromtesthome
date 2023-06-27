package lesson35.dao;

import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.service.HotelService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;


public class RoomDAO extends GeneralDAO<Room> {

    @Override
    public void addObjectToFile(Room room, String path) {
        super.addObjectToFile(room, "C:\\Users\\User\\Desktop//RoomDb.txt");
    }

    @Override
    public void deleteObjectFromFile(long id, String path) throws Exception {
        setReadFile(recordObjectRoom(readFileTextRoom()));
        super.deleteObjectFromFile(id, "C:\\Users\\User\\Desktop//RoomDb.txt");
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
        HotelService hotelService = new HotelService();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        LinkedList<Room> rooms = new LinkedList<>();
        for (String line : strings) {
            String[] s = line.split(", ");
            if (s.length == 7) {
                int idHotel = Integer.parseInt(s[6]);
                Hotel hotel = hotelService.findIdObject(idHotel);
                rooms.add(new Room(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Double.parseDouble(s[2]), Boolean.parseBoolean(s[3]), Boolean.parseBoolean(s[4]), dateFormat.parse(s[5]), hotel));
            }
        }
        return rooms;
    }

}


