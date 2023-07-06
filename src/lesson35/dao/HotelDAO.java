package lesson35.dao;

import lesson35.model.Hotel;

import java.util.LinkedList;

public class HotelDAO extends GeneralDAO<Hotel> {
    public static void main(String[] args) {
        HotelDAO hotelDAO = new HotelDAO();
        System.out.println(hotelDAO.readAll());
    }

    @Override
    public String getPath() {
        return "C:\\Users\\User\\Desktop/HotelDb.txt";
    }

    @Override
    public void addObjectToFile(Hotel hotel) {
        super.addObjectToFile(hotel);
    }

    @Override
    public void deleteObjectFromFile(long id) throws Exception {
        super.deleteObjectFromFile(id);
    }

    @Override
    public LinkedList<Hotel> readAll() {
        LinkedList<String> strings = readFile();
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
    protected LinkedList<String> readFile() {
        return super.readFile();
    }

}
