package lesson35.dao;


import lesson35.model.Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HotelDAO {

    private static ArrayList<Hotel> readHotels() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        String[] data;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop//HotelDb.txt"))) {
            while ((line = reader.readLine()) != null) {
                data = line.split(", ");
                if (data.length >= 5) {
                    int id = 0;
                    String nameHotel = "";
                    String country = "";
                    String hotelCity = "";
                    String street = "";
                    try {
                        id = Integer.parseInt(data[0]);
                        nameHotel = data[1];
                        country = data[2];
                        hotelCity = data[3];
                        street = data[4];
                        hotels.add(new Hotel(id, nameHotel, country, hotelCity, street));
                    } catch (Exception e) {
                        System.err.println("Error: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error:");
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
}
