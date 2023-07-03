package lesson35.dao;

import lesson35.model.Hotel;
import lesson35.model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class RoomDAO extends GeneralDAO<Room> {

    @Override
    public String getPath() {
        return "C:\\Users\\User\\Desktop//RoomDb.txt";
    }

    @Override
    public void addObjectToFile(Room room) {
        super.addObjectToFile(room);
    }

    @Override
    public void deleteObjectFromFile(long id) throws Exception {
        super.deleteObjectFromFile(id);
    }

    @Override
    public LinkedList<Room> readAll() throws Exception {
        HotelDAO hotelDao = new HotelDAO();
        LinkedList<String> strings = readFile();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        LinkedList<Room> rooms = new LinkedList<>();
        for (String line : strings) {
            String[] s = line.split(", ");
            if (s.length == 7) {
                int idHotel = Integer.parseInt(s[6]);
                Hotel hotel = hotelDao.findIdObject(idHotel);
                Date date = dateFormat.parse(s[5]);
                rooms.add(new Room(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Double.parseDouble(s[2]), Boolean.parseBoolean(s[3]), Boolean.parseBoolean(s[4]), date, hotel));
            }
        }
        return rooms;
    }

    @Override
    public LinkedList<String> readFile() {
        return super.readFile();
    }

}


