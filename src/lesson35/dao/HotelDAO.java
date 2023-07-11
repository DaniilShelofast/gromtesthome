package lesson35.dao;

import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import java.util.LinkedList;

public class HotelDAO extends GeneralDAO<Hotel> {

    public final static HotelDAO hotelDAO = new HotelDAO();

    public static void main(String[] args) throws Exception {
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
    public LinkedList<Hotel> readAll() throws Exception {
        return super.readAll();
    }

    @Override
    public Hotel convert(String string) throws BadRequestException {
        String[] data = string.split(", ");
        if (data.length == 5) {
            return new Hotel(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
        }
        throw new BadRequestException("Database error");
    }

}
