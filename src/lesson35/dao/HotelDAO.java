package lesson35.dao;


import lesson35.model.Hotel;

import java.io.*;
import java.util.LinkedList;

public class HotelDAO {

    private static final String fileName = "C:\\Users\\User\\Desktop//HotelDb.txt";

    private static LinkedList<Hotel> readHotels() {
        LinkedList<Hotel> hotels = new LinkedList<>();
        String[] data;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                data = line.split(", ");
                if (data.length >= 5) {
                    try {
                        int id = Integer.parseInt(data[0]);
                        String nameHotel = data[1];
                        String country = data[2];
                        String hotelCity = data[3];
                        String street = data[4];
                        hotels.add(new Hotel(id, nameHotel, country, hotelCity, street));
                    } catch (Exception e) {
                        System.err.println("Error: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public static Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : readHotels()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new Exception("Error : this city is not in our database.");
    }

    public static Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : readHotels()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new Exception("Error : this city is not in our database.");
    }

    public static void addHotel(Hotel hotel) throws Exception {

        findHotelById(hotel.getId());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            File line = new File(fileName);
            if (line.length() == 0) {
                writer.write(hotel.getId() + ", " + hotel.getName() + ", " + hotel.getCountry() + ", " + hotel.getCity() + ", " + hotel.getStreet());
            } else {
                writer.newLine();
                writer.write(hotel.getId() + ", " + hotel.getName() + ", " + hotel.getCountry() + ", " + hotel.getCity() + ", " + hotel.getStreet());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deleteHotel(long idHotel) {
        LinkedList<Hotel> hotels = readHotels();
        hotels.removeIf(h -> h.getId() == idHotel);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (Hotel hotel : hotels) {
                writer.write(hotel.getId() + ", " + hotel.getName() + ", " + hotel.getCountry() + ", " + hotel.getCity() + ", " + hotel.getStreet() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean findHotelById(long id) throws Exception {
        for (Hotel hotel : readHotels()) {
            if (hotel != null && hotel.getId() == id) {
                throw new Exception("Error : a hotel with such an ID already exists");
            }
        }
        return true;
    }
}
