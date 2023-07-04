package lesson33;

import lesson35.model.Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FindHotelsByCity {
    static String fileName = "C:\\Users\\User\\Desktop//HotelDb.txt";

    private static ArrayList<Hotel> readHotelsFromFile(String city) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        String[] data;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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

        ArrayList<Hotel> foundHotels = new ArrayList<>();
        for (Hotel h : hotels) {
            if (h.getCity().equals(city)) {
                foundHotels.add(h);
            }
        }
        return foundHotels;
    }

    public static void main(String[] args) {
        String city = "Lviv";
        System.out.println(readHotelsFromFile(city));
    }
}
