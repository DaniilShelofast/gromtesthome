package lesson35.dao;

import lesson35.model.Hotel;

import java.util.LinkedList;

public class HotelDAO extends GeneralDAO<Hotel> {

    @Override
    public void addObjectToFile(Hotel hotel) {
        txtPath("C:\\Users\\User\\Desktop/HotelDb.txt");
        super.addObjectToFile(hotel);
    }

    @Override
    public void deleteObjectFromFile(long id) throws Exception {
        txtPath("C:\\Users\\User\\Desktop/HotelDb.txt");
        super.deleteObjectFromFile(id);
    }

    @Override
    public LinkedList<Hotel> recordObject(LinkedList<String> strings) {
        LinkedList<Hotel> hotels = new LinkedList<>();
        for (String line : strings) {
            String[] data = line.split(", ");
            if (data.length == 5) {
                hotels.add(new Hotel(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]));
            }
        }
        return hotels;
    }

    @Override
    public LinkedList<String> readFileText() {
        txtPath("C:\\Users\\User\\Desktop/HotelDb.txt");
        return super.readFileText();
    }
}
