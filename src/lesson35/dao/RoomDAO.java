package lesson35.dao;

import lesson35.model.Hotel;
import lesson35.model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class RoomDAO extends GeneralDAO<Room> {
    public static void main(String[] args) throws Exception {
        RoomDAO roomDAO = new RoomDAO();
       /* SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateInString = "15-05-2005 12:00:00";
        Date date = sdf.parse(dateInString);*/
      /*  String date_s = "2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dt.parse(date_s);*/

        Room room = new Room(4, 2, 134.5, true, true, new Date(110,01,05), new Hotel(34, "", "", "", ""));
        //roomDAO.addObjectToFile(room);
        roomDAO.deleteObjectFromFile(1);

    }

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
        HotelDAO  hotelDAO = new HotelDAO();
        LinkedList<String> strings = readFile();
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
    public LinkedList<String> readFile() {
        return super.readFile();
    }

}


