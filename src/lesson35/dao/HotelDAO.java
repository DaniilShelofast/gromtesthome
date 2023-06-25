package lesson35.dao;

import lesson35.model.Hotel;

import java.io.*;
import java.util.LinkedList;

public class HotelDAO extends GeneralDAO<Hotel> {

    @Override
    public void addObjectToFile(Hotel hotel) {
        setPath("C:\\Users\\User\\Desktop//HotelDb.txt");
        super.addObjectToFile(hotel);
    }

    @Override
    public void deleteObjectFromFile(long id) throws Exception {
        setReadFile(recordObjectHotel(readFileTextHotel()));
        setPath("C:\\Users\\User\\Desktop//HotelDb.txt");
        super.deleteObjectFromFile(id);
    }

    /*public static void deleteHotel(long idHotel) {
        HotelDAO hotelDAO = new HotelDAO();
        LinkedList<Hotel> hotels = recordObjectHotel(readFileTextHotel());
        hotels.removeIf(h -> h.getId() == idHotel);
        try (BufferedWriter ignored = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop//HotelDb.txt", false))) {
            for (Hotel hotel : hotels) {
                hotelDAO.addObjectToFile(hotel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

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


    public static LinkedList<String> readFileTextHotel() {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop//HotelDb.txt"))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
