package lesson35.dao;

import lesson35.exception.DataWritingException;
import lesson35.exception.ObjectConvertingException;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class RoomDAO extends GeneralDAO<Room> {

    public final HotelDAO hotelDAO = new HotelDAO();

    @Override
    public String getPath() {
        return "C:\\Users\\User\\Desktop//RoomDb.txt";
    }

    @Override
    public void addObjectToFile(Room room) throws DataWritingException {
        super.addObjectToFile(room);
    }

    @Override
    public void deleteObjectFromFile(long id) throws Exception {
        super.deleteObjectFromFile(id);
    }

    @Override
    public LinkedList<Room> readAll() throws Exception {
        return super.readAll();
    }

    @Override
    public Room convert(String string) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String[] data = string.split(", ");
        if (data.length == 7) {
            long idHotel = Long.parseLong(data[6]);
            Hotel hotel = hotelDAO.findObject(idHotel);
            Date date = dateFormat.parse(data[5]);
            return new Room(Long.parseLong(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2]), Boolean.parseBoolean(data[3]), Boolean.parseBoolean(data[4]), date, hotel);
        }
        throw new ObjectConvertingException("Database error", new Exception("Error..."));
    }
}


