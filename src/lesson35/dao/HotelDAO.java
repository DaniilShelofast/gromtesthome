package lesson35.dao;


import lesson35.model.Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class HotelDAO {
    public static void main(String[] args) throws Exception {
        findHotelByCity("Lviv");
    }

    private static final LinkedList<Hotel> hotels = new LinkedList<>();

    public HotelDAO() {
    }

    public static LinkedList<Hotel> readFile() throws Exception {
        LinkedList<Hotel> list = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop/HotelDb.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

            }
        } catch (IOException e) {
            System.err.println("Reading from file failed");
        }
        return list;
    }

    public static Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : readFile()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new Exception("Error:");
    }

    public static Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : readFile()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new Exception("Error:");
    }

    public static LinkedList<Hotel> getHotels() {
        return hotels;
    }
}
