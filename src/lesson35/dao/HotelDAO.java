package lesson35.dao;

import lesson35.model.Hotel;

import java.util.LinkedList;

public class HotelDAO extends GeneralDAO<Hotel> {

    @Override
    public void addObjectToFile(Hotel hotel) {
        setPath("C:\\Users\\User\\Desktop//HotelDb.txt");
        super.addObjectToFile(hotel);
    }

    @Override
    public void deleteObjectFromFile(long id) throws Exception {
        setReadFile(recordObjectHotel(readFileText()));
        setPath("C:\\Users\\User\\Desktop//HotelDb.txt");
        super.deleteObjectFromFile(id);
    }

    public static LinkedList<Hotel> recordObjectHotel(LinkedList<String> lines) {
        LinkedList<Hotel> hotels = new LinkedList<>();
        for (String line : lines) {
            String[] data = line.split(", ");
            if (data.length == 5) {
                hotels.add(new Hotel(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]));
            }
        }
        return hotels;
    }

    @Override
    public LinkedList<String> readFileText() {
        setPath("C:\\Users\\User\\Desktop//HotelDb.txt");
        return super.readFileText();
    }
}
