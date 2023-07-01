package lesson35.dao;

import lesson35.model.Hotel;
import lesson35.model.Room;

import java.text.SimpleDateFormat;
import java.util.LinkedList;


public class RoomDAO extends GeneralDAO<Room> {

    @Override
    public void addObjectToFile(Room room) {
        txtPath("C:\\Users\\User\\Desktop//RoomDb.txt");
        super.addObjectToFile(room);
    }

    @Override
    public void deleteObjectFromFile(long id) throws Exception {
        txtPath("C:\\Users\\User\\Desktop//RoomDb.txt");
        super.deleteObjectFromFile(id);
    }

    @Override
    public LinkedList<Room> recordObject(LinkedList<String> strings)throws Exception {
        HotelDAO  hotelDAO = new HotelDAO();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        LinkedList<Room> rooms = new LinkedList<>();
        for (String line : strings) {
            String[] s = line.split(", ");
            if (s.length == 7) {
                int idHotel = Integer.parseInt(s[6]);
                Hotel hotel = hotelDAO.findIdObject(idHotel);
                rooms.add(new Room(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Double.parseDouble(s[2]), Boolean.parseBoolean(s[3]), Boolean.parseBoolean(s[4]), dateFormat.parse(s[5]), hotel));
            }
        }
        return rooms;
    }

    @Override
    public LinkedList<String> readFileText() {
        txtPath("C:\\Users\\User\\Desktop//RoomDb.txt");
        return super.readFileText();
    }

}


