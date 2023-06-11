package lesson35.dao;

import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import java.io.*;
import java.util.LinkedList;

public class HotelDAO {

    public static LinkedList<Hotel> readHotels() {
        LinkedList<Hotel> hotels = new LinkedList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop//HotelDb.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 5) {
                    hotels.add(new Hotel(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]));
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
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : readHotels()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static void addHotel(Hotel hotel, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop//HotelDb.txt", append))) {
            File line = new File("C:\\Users\\User\\Desktop//HotelDb.txt");
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
        try (BufferedWriter ignored = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop//HotelDb.txt", false))) {
            for (Hotel hotel : hotels) {
                addHotel(hotel, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
